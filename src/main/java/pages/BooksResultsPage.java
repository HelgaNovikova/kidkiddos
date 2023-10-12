package pages;

import model.Book;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BooksResultsPage extends BasePage {

    @FindBy(xpath = "//div[@id='Collection']/div/div/div/a")
    List<WebElement> booksList;

    @FindBy(xpath = "//div[@class='_close']")
    private WebElement popUpClose;

    @FindBy(xpath = "//div[contains(@class, 'section-header')]/h1")
    private WebElement languageHeader;

    public BooksResultsPage() {
        PageFactory.initElements(wd, this);
    }

    private void closePopUp() {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(popUpClose));
        popUpClose.click();
    }

    public boolean isPageOpened() {
        return languageHeader.isDisplayed();
    }

    public String getLanguageHeader() {
        return languageHeader.getText();
    }

    public ProductPage chooseBook() {
        // closePopUp();
        var index = (int) (Math.random() * (booksList.size() - 1));
        WebElement chosenBookTitle = booksList.get(index).findElement(By.xpath("./div[contains(@class,'item__title')]"));
        String bookTitle = chosenBookTitle.getText();
        double price = Double.parseDouble(booksList.get(index).findElement(By.xpath(".//span[@class='cbb-price-digits']")).getText());
        chosenBookTitle.click();
        return new ProductPage(new Book(bookTitle, price));
    }
}
