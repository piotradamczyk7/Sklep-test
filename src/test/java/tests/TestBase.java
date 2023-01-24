package tests;

import configuration.ConfigurationProperties;
import configuration.PropertiesLoader;
import driver.BrowserType;
import driver.manager.DriverUtils;

import static navigation.ApplicationURLs.APPLICATION_URL;

import io.qameta.allure.Step;
import org.testng.annotations.*;
import driver.manager.DriverManager;

import java.util.Properties;

public class TestBase {

    @Step("Loading configuration from configuration.properties")
    @BeforeClass
    public void beforeClass() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);
    }

    @Step("Setting up browser to: {browserType} and navigating to Starting Page")
    @Parameters("browserType")
    @BeforeMethod
    public void beforeTest(@Optional BrowserType browserType) {
        DriverManager.setWebDriver(browserType);
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);
    }

    @Step("Disposing browser")
    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }

}