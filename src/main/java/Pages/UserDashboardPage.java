package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserDashboardPage {

    private WebDriver driver;
    public UserDashboardPage(WebDriver driver) {
        this.driver = driver;

    }


    @FindBy(css = ".my-courses .course-card") // Assume
    private WebElement subscribedCourse;

    public boolean isCourseSubscribed(String courseName) {
        return subscribedCourse.getText().contains(courseName);
    }
}