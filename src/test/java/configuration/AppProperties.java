package configuration;

public class AppProperties {

    public static String getAllUrl() {
        return ConfigurationProperties.getProperties().getProperty("app.url");
    }

    public static boolean isSleepingOn(){
        return Boolean.parseBoolean(ConfigurationProperties.getProperties().getProperty("is.sleeping.on"));
    }
}