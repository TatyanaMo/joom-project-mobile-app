package mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

//@Slf4j
public class Initializer {
    private static final Logger log = LoggerFactory.getLogger(Initializer.class);
    private static AppiumDriver driver;
    public static Properties config = new Properties();

    static {
        try (InputStream input= Initializer.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
              log.error("Unable to find config.properties");
            }
            config.load(input);
        } catch (Exception ex) {
            log.error("Failed to load configuration", ex);
            throw new ExceptionInInitializerError();
        }
    }

    public static AppiumDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    private static void initDriver() {
        try {
            URI appiumServerURI = new URI(config.getProperty("appium.server.url"));
            URL appiumServerURL = appiumServerURI.toURL();

            UiAutomator2Options options = new UiAutomator2Options()
                    .setDeviceName(config.getProperty("device.name"))
                    .setPlatformName(config.getProperty("platform.name"))
                    .setAppPackage(config.getProperty("app.package"))
                    .setAppActivity(config.getProperty("app.activity"))
                    .setAutomationName(config.getProperty("automation.name"))
                    .setNewCommandTimeout(Duration.ofSeconds(Long.parseLong(config.getProperty("new.command.timeout"))));

            driver = new AndroidDriver(appiumServerURL, options);
            log.info("Driver initialized successfully");
        } catch (Exception e) {
            log.error("Driver initialization failed", e);
            throw new RuntimeException(e);
        }
    }

    public static void quiteDriver() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
