package mobile.helper;

import io.appium.java_client.AppiumDriver;

public class Helper {
    private static AppiumDriver driver;

    public static Boolean isTextOnScreen(String expectedText){
        return driver.getPageSource().contains(expectedText);
    }

    public static void setDriver(AppiumDriver driver) {
        Helper.driver = driver;
    }
}
