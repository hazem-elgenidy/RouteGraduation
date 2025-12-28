package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage {

    private WebDriver driver;
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }


    @FindBy(id = "username") // Inspect for real IDs
    private WebElement usernameField;

    // Similar for other fields: email, password, etc.

    @FindBy(xpath = "//button[text()='انشاء']")
    private WebElement createButton;

    @FindBy(xpath = "//div[contains(text(), 'اسم المستخدم مطلوب')]")
    private WebElement usernameError;

    public void fillRegistrationFormExceptUsername(String email, String pass /* other data */) {
        // Fill other fields
        createButton.click();
    }

    public boolean isUsernameErrorDisplayed() {
        return usernameError.isDisplayed();
    }
}