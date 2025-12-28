package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseDetailsPage {
    private WebDriver driver;
    public CourseDetailsPage(WebDriver driver) {
        this.driver = driver;
    }


    @FindBy(xpath = "//h2[text()='حول الدورة التدريبية']")
    private WebElement aboutSection;

    public boolean isAboutSectionDisplayed() {
        return aboutSection.isDisplayed();
    }


}