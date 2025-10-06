package com.rakib.spring.protocols.mock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.http.UniformDistribution;
import org.springframework.stereotype.Component;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalToJson;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

@Component
public class MockServer {
    private WireMockServer wireMockServer;
    public MockServer() {
        wireMockServer = new WireMockServer(
                WireMockConfiguration.options().port(8081)
                        .notifier(new ConsoleNotifier(true))
        );
        wireMockServer.start();

        configureFor("localhost", wireMockServer.port());
        stubFor(post(urlEqualTo("/external"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"status\": \"Resource created successfully!\"}")
                        .withFixedDelay(100)));
        Runtime.getRuntime().addShutdownHook(new Thread(wireMockServer::stop));
    }

    public String getURL() {
        return wireMockServer.baseUrl();
    }
}
