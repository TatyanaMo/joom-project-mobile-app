package tests;

import io.appium.java_client.AppiumDriver;
import mobile.Initializer;
import mobile.helper.Helper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BaseTest {

    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    protected static AppiumDriver driver;

    @BeforeEach
    public void setUp() throws InterruptedException {
        log.info("Initializing before test\n");
        driver = Initializer.getDriver();
        Helper.setDriver(driver);
        Thread.sleep(2000);
        log.info("Starting test!\n");
    }

    @AfterEach
    public void tearDown() {
        log.info("Driver: Closing after test\n");
        Initializer.quiteDriver();
    }
}
