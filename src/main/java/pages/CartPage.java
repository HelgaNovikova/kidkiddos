package pages;

import model.Book;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    @FindBy(xpath = "//div[@class='list-view-item__title']/a")
    private WebElement bookTitle;

    @FindBy(xpath = "//td[@class='cart__price-wrapper cart-flex-item']//span[@class='cbb-price-digits']")
    private WebElement bookPrice;

    @FindBy(xpath = "//div[@class='cart__meta-text']")
    private WebElement bookFormat;

    @FindBy(xpath = "//label[text()='Quantity']/following-sibling::input")
    private WebElement bookQuantity;

    @FindBy(xpath = "//span[@class ='cart__subtotal']//span[@class='cbb-price-digits']")
    private WebElement orderSum;

    @FindBy(xpath = "//a[text()='Continue shopping']/following-sibling::input[@value='Update']")
    private WebElement updateOrderButton;

    @FindBy(xpath = "//h1[text()='Your cart']")
    private WebElement pageTitle;

    private Double expectedOrderSum;

    private Book book;

    public Book getBook() {
        return book;
    }

    public CartPage(Book book) {
        this.book = book;
        PageFactory.initElements(wd, this);
    }

    public boolean isPageOpened() {
        return pageTitle.isDisplayed();
    }

    public void changeBookQuantity(int number) {
        bookQuantity.clear();
        bookQuantity.sendKeys(Integer.toString(number));
        book.setQuantity(number);
        expectedOrderSum = number * book.getPrice();
    }

    public void updateOrder() {
        updateOrderButton.click();
    }

    public double getOrderSum() {
        return Double.parseDouble(orderSum.getText());
    }

    public String getBookTitle() {
        return bookTitle.getText();
    }

    public double getBookPrice() {
        return Double.parseDouble(bookPrice.getText());
    }

    public String getBookFormat() {
        return bookFormat.getText().trim().substring(8);
    }

    public int getBookQuantity() {
        return Integer.parseInt(bookQuantity.getAttribute("value"));
    }

    public boolean isBookDataCorrect() {
        return book.getTitle().equals(getBookTitle()) &&
                book.getPrice() == getBookPrice() &&
                book.getFormat().equals(getBookFormat()) &&
                book.getQuantity() == getBookQuantity();
    }
}
