package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@name='customer[email]']")
    private WebElement email;

    @FindBy(xpath = "//input[@name='customer[password]']")
    private WebElement password;

    @FindBy(xpath = "//input[@value='Sign In']")
    private WebElement signInButton;

    @FindBy(xpath = "//errors//li[1]")
    private WebElement errorMessage;

    public LoginPage() {
        PageFactory.initElements(wd, this);
    }

    public boolean isPageOpened() {
        return email.isEnabled() && password.isEnabled();
    }

    public boolean isErrorMessageAppeared() {
        return errorMessage.isDisplayed();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void loginWithCredentials(String userLogin, String userPassword) {
        email.sendKeys(userLogin);
        password.sendKeys(userPassword);
        signInButton.click();
    }
}
