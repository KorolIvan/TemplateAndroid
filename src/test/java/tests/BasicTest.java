package tests;

import dataInfo.ConfigurationProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * @author by Ivan Korol on 6/21/2017.
 */
public class BasicTest {

    private static AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        // set up appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", ConfigurationProperties.getProperty("configuration", "device_name"));
        capabilities.setCapability("platformName", ConfigurationProperties.getProperty("configuration", "platform_name"));
        capabilities.setCapability("platformVersion", ConfigurationProperties.getProperty("configuration", "platform_version"));
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
        capabilities.setCapability("appium-version", ConfigurationProperties.getProperty("configuration", "appium_version"));
        capabilities.setCapability("appPackage", ConfigurationProperties.getProperty("configuration", "app_package"));
        capabilities.setCapability("appActivity", ConfigurationProperties.getProperty("configuration", "app_activity"));

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.closeApp();
            driver.quit();
        }
    }

}
