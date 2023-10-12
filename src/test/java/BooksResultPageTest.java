import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.BooksResultsPage;
import pages.MainPage;
import utils.UseCaseBase;

public class BooksResultPageTest extends UseCaseBase {

    private static final Logger logger = LogManager.getLogger(BooksResultPageTest.class);

    private static BooksResultsPage booksPage;

    private static final String language = "English Only";

    @BeforeAll
    public static void classSetup() {
        MainPage mainPage = new MainPage();
        mainPage.navigateToMainPage();
        booksPage = mainPage.chooseLanguage(language);
    }

    @Test
    public void isPageOpened() {
        Assertions.assertTrue(booksPage.isPageOpened());
        Assertions.assertEquals(booksPage.getLanguageHeader(), language);
    }


}
