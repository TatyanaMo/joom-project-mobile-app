package tests.account;

import mobile.enums.LoginTitle;
import mobile.helper.TestDescription;
import mobile.screens.JoomHomeScreen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class GetProfileScreenTest extends BaseTest {
    private final LoginTitle loginTitle = LoginTitle.LOGIN_TITLE;

    @Test
    @DisplayName("Open login test")
    @TestDescription("Close advertisement, skip the quiz, open login screen")
    public void getLoginScreen() {
        JoomHomeScreen joomHomeScreen = new JoomHomeScreen(driver);
        joomHomeScreen
                .closeAdvertisement()
                .skipQuiz()
                .openLoginScreen()
                .verifyLoginScreenOpened(loginTitle);
    }
}
