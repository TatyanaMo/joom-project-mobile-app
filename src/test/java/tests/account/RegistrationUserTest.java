package tests.account;

import lombok.SneakyThrows;
import mobile.dto.AddUserData;
import mobile.enums.AccountTitle;
import mobile.generator.FakeRandomGenerator;
import mobile.helper.TestDescription;
import mobile.screens.JoomHomeScreen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static mobile.Initializer.config;


public class RegistrationUserTest extends BaseTest {

    private final AccountTitle newUserData = FakeRandomGenerator.getRandomOption(AccountTitle.class);

    private final AddUserData addUserData = new AddUserData(
            config.getProperty("USER_FIRST_NAME"),
            config.getProperty("USER_LAST_NAME"),
            config.getProperty("USER_EMAIL"),
            config.getProperty("USER_PASSWORD"),
            config.getProperty("USER_PASSWORD_CONFIRMATION")
    );

    @SneakyThrows
    @Test
    @DisplayName("User registration")
    @TestDescription("Close advertisement, skip the quiz, open login screen, sign up")
    public void testRegistrationUser() throws InterruptedException {
     JoomHomeScreen joomHomeScreen = new JoomHomeScreen(driver);
     joomHomeScreen
             .closeAdvertisement()
             .skipQuiz()
             .openLoginScreen()
             .openRegistrationForm()
             .sighUpWithEmail()
             .registrationNewUser(addUserData)
             .verifyUserRegistered(newUserData);
    }
}
