package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    public MainPage() {
        PageFactory.initElements(wd, this);
    }

    @FindBy(xpath = "//img[@itemprop='logo']")
    private WebElement logo;

    @FindBy(xpath = "//a[@class='site-header__account']")
    private WebElement login;

    @FindBy(xpath = "//a[@aria-controls = 'SiteNavLabel-books-by-language']")
    private WebElement booksByLanguageMenuItem;

    public BooksResultsPage chooseLanguage(String language) {
        booksByLanguageMenuItem.click();
        WebElement chosenOne = wd.findElement(By.xpath("//div[@id='SiteNavLabel-books-by-language']//a[text()='" + language + "']"));
        chosenOne.click();
        return new BooksResultsPage();
    }

    public void navigateToMainPage() {
        wd.get(properties.getProperty("url"));
    }

    public LoginPage login() {
        login.click();
        return new LoginPage();
    }

    public boolean isLogoVisible() {
        return logo.isDisplayed();
    }

}
