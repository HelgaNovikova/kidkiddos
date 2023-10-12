import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.BooksResultsPage;
import pages.CartPage;
import pages.MainPage;
import pages.ProductPage;
import utils.UseCaseBase;
import static org.junit.jupiter.api.Assertions.*;

public class CartPageTest extends UseCaseBase {
    private static final String language = "English Only";
    private static CartPage cartPage;
    private final int bookQuantity = 6;

    private static final Logger logger = LogManager.getLogger(CartPageTest.class);

    @BeforeAll
    public static void classSetup() {
        MainPage mainPage = new MainPage();
        mainPage.navigateToMainPage();
        BooksResultsPage booksPage = mainPage.chooseLanguage(language);
        ProductPage productPage = booksPage.chooseBook();
        productPage.chooseBookFormat("Hardcover");
        productPage.setQuantity(5);
        cartPage = productPage.addToCart();
    }

    @Test
    public void pageIsOpened() {
        assertTrue(cartPage.isPageOpened());
    }

    @Test
    public void bookInfoIsShownCorrectly() {
        assertTrue(cartPage.isBookDataCorrect());
    }

    @Test
    public void updateCart() {
        double bookPrice = cartPage.getBookPrice();
        cartPage.changeBookQuantity(bookQuantity);
        assertEquals(bookQuantity, cartPage.getBookQuantity());
        cartPage.updateOrder();
        assertEquals(bookPrice * bookQuantity, cartPage.getOrderSum());
        assertEquals(bookQuantity, cartPage.getBookQuantity());
    }
}
