package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CoursesPage {
    private WebDriver driver;
    public CoursesPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = ".course-card") // Assume class for cards
    public
    List<WebElement> courseCards;

    public void selectFirstCourse() {
        if (!courseCards.isEmpty()) {
            courseCards.get(0).click();
        }
    }

    public boolean isCourseCardUIComplete(WebElement card) {
        // Check for image, title, instructor, subscribe button
        return card.findElement(By.tagName("img")).isDisplayed() &&
                card.findElement(By.cssSelector(".title")).isDisplayed() && // Adjust selectors
                card.findElement(By.cssSelector(".instructor")).isDisplayed() &&
                card.findElement(By.cssSelector(".subscribe-btn")).isDisplayed();
    }
}