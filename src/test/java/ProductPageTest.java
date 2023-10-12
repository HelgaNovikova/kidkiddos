import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.BooksResultsPage;
import pages.MainPage;
import pages.ProductPage;
import utils.UseCaseBase;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductPageTest extends UseCaseBase {

    private static final String language = "English Only";
    private static ProductPage productPage;

    @BeforeAll
    public static void classSetup() {
        MainPage mainPage = new MainPage();
        mainPage.navigateToMainPage();
        BooksResultsPage booksPage = mainPage.chooseLanguage(language);
        productPage = booksPage.chooseBook();
    }

    @Test
    public void bookChosenCorrectly() {
        assertTrue(productPage.isBookCorrect());
    }
}
