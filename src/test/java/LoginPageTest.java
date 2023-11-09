import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.NoSuchElementException;
import org.opentest4j.AssertionFailedError;
import pages.LoginPage;
import pages.MainPage;
import utils.UseCaseBase;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTest extends UseCaseBase {

    private static final Logger logger = LogManager.getLogger(LoginPageTest.class);
    private static final String errorMessage = "Incorrect email or password.";

    private static LoginPage loginPage;

//    @BeforeAll
//    public static void classSetup() {
//        MainPage mainPage = new MainPage();
//        mainPage.navigateToMainPage();
//        loginPage = mainPage.login();
//    }
//
//    @ParameterizedTest
//    @MethodSource("loginNegative")
//    public void loginNegative(String login, String password) {
//        try {
//            loginPage.loginWithCredentials(login, password);
//            assertTrue(loginPage.isErrorMessageAppeared());
//            assertEquals(errorMessage, loginPage.getErrorMessage());
//        } catch (AssertionFailedError | NoSuchElementException e) {
//            loginPage.takeScreenshot("error");
//            throw e;
//        }
//    }

    private static Stream<Arguments> loginNegative() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of("user@user.com", "password")
        );
    }
}
