package mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.SneakyThrows;
import mobile.dto.AddUserData;
import mobile.enums.AccountTitle;
import mobile.helper.Helper;
import mobile.locators.SignUpPopUpLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class SignUpPopUpScreen extends BaseScreen {

    private static final Logger log = LoggerFactory.getLogger(SignUpPopUpScreen.class);

    public SignUpPopUpScreen(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = SignUpPopUpLocators.SIGN_UP_BUTTON_XPATH)
    private WebElement signUpButton;

    public void signUp() {
        waitUntilElementIsVisible(signUpButton);
        signUpButton.click();
    }

    @AndroidFindBy(xpath = SignUpPopUpLocators.INPUT_FIRST_NAME_FIELD_XPATH)
    private WebElement inputFirstNameField;

    public void setFirstName(String firstName) {
        waitUntilElementIsVisible(inputFirstNameField);
        inputFirstNameField.click();
        inputFirstNameField.sendKeys(firstName);
    }

    @AndroidFindBy(xpath = SignUpPopUpLocators.INPUT_LAST_NAME_FIELD_XPATH)
    private WebElement inputLastNameField;

    public void setLastName(String lastName) {
        waitUntilElementIsVisible(inputLastNameField);
        inputLastNameField.click();
        inputLastNameField.sendKeys(lastName);
    }

    @AndroidFindBy(xpath = SignUpPopUpLocators.INPUT_EMAIL_FIELD_XPATH)
    private WebElement inputEmailField;

    public void setEmail(String email) {
        waitUntilElementIsVisible(inputEmailField);
        inputEmailField.click();
        inputEmailField.sendKeys(email);
    }

    @AndroidFindBy(xpath = SignUpPopUpLocators.INPUT_PASSWORD_FIELD_XPATH)
    private WebElement inputPasswordField;

    public void setPassword(String password) {
        waitUntilElementIsVisible(inputPasswordField);
        inputPasswordField.click();
        inputPasswordField.sendKeys(password);
    }

    @AndroidFindBy(xpath = SignUpPopUpLocators.INPUT_PASSWORD_CONFIRMATION_FIELD_XPATH)
    private WebElement inputPasswordConfirmationField;

    public void setPasswordConfirmation(String passwordConfirmation) {
        waitUntilElementIsVisible(inputPasswordConfirmationField);
        inputPasswordConfirmationField.click();
        inputPasswordConfirmationField.sendKeys(passwordConfirmation);
    }

    @AndroidFindBy(xpath = SignUpPopUpLocators.FINISH_SIGN_UP_BUTTON_XPATH)
    private WebElement continueSignUpButton;

    public void continueSignUp() {
        waitUntilElementIsVisible(continueSignUpButton);
        continueSignUpButton.click();
        log.info("System login: Completed");
    }

    @SneakyThrows
    public SignUpPopUpScreen registrationNewUser(AddUserData addUserData) throws InterruptedException {
        signUp();
        setFirstName(addUserData.getUserFirstName());
        setLastName(addUserData.getUserLastName());
        setEmail(addUserData.getUserEmail());
        setPassword(addUserData.getUserPassword());
        setPasswordConfirmation(addUserData.getUserPasswordConfirmation());
        log.info("Registration: User '{}' successful", addUserData.getUserEmail());

        continueSignUp();
        Thread.sleep(1000);
        return this;
    }

    public void verifyUserRegistered(AccountTitle accountTitle) {
        assertThat(Helper.isTextOnScreen(accountTitle.getValue()))
                .as("Check if text '%s' is visible on the screen", accountTitle.getValue())
                .isTrue();

        log.info("Verified '{}' text is visible", accountTitle.getValue());
    }




}
