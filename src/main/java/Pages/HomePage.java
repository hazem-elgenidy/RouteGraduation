package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='بحث']") // Inspect for real XPath
    private WebElement searchInput;

    @FindBy(xpath = "//button[text()='بحث']") // Or search icon
    private WebElement searchButton;

    @FindBy(linkText = "جميع الدورات") // Or class for all courses
    private WebElement allCoursesLink;

    @FindBy(linkText = "انضم لنا")
    private WebElement joinUsButton;

    @FindBy(xpath = "//footer//a[contains(@href, 'facebook.com')]")
    private WebElement facebookIcon;

    // Similar for linkedinIcon, instagramIcon

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterSearchKeyword(String keyword) {
        searchInput.sendKeys(keyword);
        searchButton.click();
    }

    public void clickAllCourses() {
        allCoursesLink.click();
    }

    public void clickJoinUs() {
        joinUsButton.click();
    }

    public void scrollToFooterAndClickFacebook() {
        // Use JavascriptExecutor to scroll
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", facebookIcon);
        facebookIcon.click();
    }

    public boolean isUserLoggedIn() {
        // Check for user profile icon or logout button
        By profileIcon = By.xpath("//img[@alt='User Profile']"); // Example XPath
        return driver.findElements(profileIcon).size() > 0;
    }

    // Similar methods for LinkedIn, Instagram
}