import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import utils.UseCaseBase;

import static org.junit.jupiter.api.Assertions.*;

public class MainPageTest extends UseCaseBase {

    private static MainPage mainPage;
    public static final Logger logger = LogManager.getLogger(MainPageTest.class);

    @BeforeAll
    public static void classSetup() {
        mainPage = new MainPage();
    }

    @BeforeEach
    public void beforeTest() {
        mainPage.navigateToMainPage();
    }

    @Test
    public void mainPageLoadTest() {
        logger.info("Main page load test");
        Boolean success = mainPage.isLogoVisible();
        mainPage.takeScreenshot("MainPageTest");
        assertTrue(success);
    }

    @Test
    public void openLoginPage() {
        LoginPage loginPage = mainPage.login();
        assertTrue(loginPage.isPageOpened());
    }
}
