package dev.mrrobot.config;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {

    private static final String CONSTANTS = "constants";
    private static final String STEPS = "enable_allure_steps";
    private static Properties properties;

    private Config() {
    }

    private static Properties getProperties() {
        if (properties == null) properties = new Properties();
        return properties;
    }

    @SneakyThrows
    public static void loadProperties() {
        getProperties().load(new FileInputStream("src/main/resources/config.properties"));
    }

    public static String getConstantType() {
        return properties.getProperty(CONSTANTS);
    }

    public static boolean isAllureStepsEnabled() {
        return properties.getProperty(STEPS).equals("true");
    }
}
