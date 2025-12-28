package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
   @FindBy (id = "username")
    private WebElement usernameField;

    @FindBy (id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='تسجيل الدخول']") // Assume text
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(text(), 'error message')]") // Adjust for real error
    private WebElement errorMessage;

    public void login(String user, String pass) {
        usernameField.sendKeys(user);
        passwordField.sendKeys(pass);
        loginButton.click();
    }

    public boolean isErrorDisplayed() {
        return errorMessage.isDisplayed();
    }

    public boolean areValidationMessagesDisplayed() {
        // Check for required field errors
        return true; // Implement based on elements
    }
}