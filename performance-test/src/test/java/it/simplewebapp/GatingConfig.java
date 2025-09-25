package it.simplewebapp;

import java.io.InputStream;
import java.util.Properties;

public class GatingConfig {
    private final double tps;
    private final int duration;

    public GatingConfig() {
        Properties props = new Properties();

        try (InputStream inputStream = GatingConfig.class.getClassLoader().getResourceAsStream("gating.properties")) {
            if (inputStream == null) {
                System.out.println("Unable to find gating.properties");
            } else {
                props.load(inputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.tps = Integer.parseInt(props.getProperty("tps"));
        this.duration = Integer.parseInt(props.getProperty("duration"));
    }

    public double getTps() {
        return tps;
    }

    public int getDuration() {
        return duration;
    }
}
