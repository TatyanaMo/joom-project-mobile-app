package mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import mobile.locators.JoomHomeLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
@Setter
public class JoomHomeScreen extends BaseScreen{
    private static final Logger log = LoggerFactory.getLogger(JoomHomeScreen.class);

    public JoomHomeScreen(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public JoomHomeScreen closeAdvertisement() {
        int xCoordinate = 996;
        int yCoordinate = 190;
        tapByCoordinate(xCoordinate, yCoordinate);
        log.info("Advertisement closed");
        return new JoomHomeScreen((driver));
    }

    @AndroidFindBy(xpath = JoomHomeLocators.SKIP_SPINNING_WHEEL_XPATH)
    private WebElement skipQuizButton;

    public JoomHomeScreen skipQuiz() {
        waitUntilElementIsVisible(skipQuizButton);
        log.info("Spinning wheel: Skipped");
        return new JoomHomeScreen(driver);
    }

    @AndroidFindBy(xpath = JoomHomeLocators.PROFILE_BUTTON_XPATH)
    private WebElement openProfileButton;

    public ProfileScreen openLoginScreen() {
        waitUntilElementIsVisible(openProfileButton);
        log.info("Profile: Opened");
        return new ProfileScreen(driver);
    }
}
