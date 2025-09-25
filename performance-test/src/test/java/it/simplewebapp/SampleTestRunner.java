package it.simplewebapp;

import com.intuit.karate.gatling.KarateProtocol;
import com.intuit.karate.gatling.KarateProtocol$;
import com.intuit.karate.gatling.javaapi.KarateProtocolBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;

import static com.intuit.karate.gatling.javaapi.KarateDsl.*;
import static io.gatling.javaapi.core.CoreDsl.constantUsersPerSec;
import static io.gatling.javaapi.core.CoreDsl.scenario;

public class SampleTestRunner extends Simulation {
    public SampleTestRunner () {
        GatingConfig config = new GatingConfig();
        KarateProtocolBuilder protocolBuilder = karateProtocol(
                uri("/transform").nil()
        );
        ScenarioBuilder transform = scenario("transform").exec(karateFeature("classpath:it/simplewebapp/simplewebapp.feature"));

        setUp(
                transform.injectOpen(constantUsersPerSec(config.getTps()).during(config.getDuration())).protocols(protocolBuilder)
        );
    }
}
