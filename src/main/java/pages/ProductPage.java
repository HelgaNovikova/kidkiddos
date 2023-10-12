package pages;

import model.Book;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//h1[@class='product-single__title']")
    private WebElement bookTitle;

    @FindBy(xpath = "//span[@id='ProductPrice-product-template']//span[@class='cbb-price-digits']")
    private WebElement bookPrice;

    @FindBy(xpath = "//label[contains(text(),'Format')]/following-sibling::select")
    private WebElement formatDropdown;

    @FindBy(xpath = "//label[text()='format'/following-sibling::select]/option[@selected='selected']")
    private WebElement selectedFormat;

    @FindBy(xpath = "//input[@id = 'Quantity']")
    private WebElement quantity;

    @FindBys({
            @FindBy(xpath = "//button[@type='submit']"),
            @FindBy(xpath = "//button[@name='add']")
    })
    private WebElement addToCart;

    private Book book;

    public ProductPage(Book book) {
        this.book = book;
        PageFactory.initElements(wd, this);
    }

    public String getBookTitle() {
        return bookTitle.getText();
    }

    public boolean isBookCorrect() {
        return (getBookTitle().equals(book.getTitle())) && (getBookPrice() == book.getPrice());
    }

    public double getBookPrice() {
        return Double.parseDouble(bookPrice.getText());
    }

    public void chooseBookFormat(String format) {
        formatDropdown.click();
        WebElement chosenFormat = formatDropdown.findElement(By.xpath("//*[text()='" + format + "']"));
        chosenFormat.click();
        book.setPrice(getBookPrice());
        book.setFormat(format);
    }

    public String getSelectedFormat() {
        return selectedFormat.getText();
    }

    public void setQuantity(int number) {
        quantity.clear();
        quantity.sendKeys(Integer.toString(number));
        book.setQuantity(number);
    }

    public CartPage addToCart() {
        addToCart.click();
        return new CartPage(book);
    }
}
