package mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobile.enums.LoginTitle;
import mobile.helper.Helper;
import mobile.locators.LoginLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfileScreen extends BaseScreen{
    private static final Logger log = LoggerFactory.getLogger(ProfileScreen.class);

    public ProfileScreen(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void verifyLoginScreenOpened(LoginTitle loginTitle) {
        assertThat(Helper.isTextOnScreen(loginTitle.getValue()))
                .as("Check if the text '%s' is visible on screen", loginTitle.getValue())
                .isTrue();

        log.info("Verified '{}' text is visible", loginTitle.getValue());
    }

    @AndroidFindBy(xpath = LoginLocators.LOGIN_BUTTON_XPATH)
    private WebElement registrationButton;

    public ProfileScreen openRegistrationForm() {
        waitUntilElementIsVisible(registrationButton);
        registrationButton.click();
        log.info("Login profile: Opened");
        return this;
    }

    @AndroidFindBy(xpath = LoginLocators.MORE_OPTIONS_BUTTON_XPATH)
    private WebElement moreOptionButton;

    public void showMoreOption() {
        waitUntilElementIsVisible(moreOptionButton);
        moreOptionButton.click();
    }

    @AndroidFindBy(xpath = LoginLocators.LOGIN_WITH_EMAIL_BUTTON_XPATH)
    private WebElement signUpWithEmailButton;

    public SignUpPopUpScreen sighUpWithEmail() {
        showMoreOption();

        waitUntilElementIsVisible(signUpWithEmailButton);
        signUpWithEmailButton.click();
        log.info("Sign up with email: Accepted");
        return new SignUpPopUpScreen(driver);
    }
}
