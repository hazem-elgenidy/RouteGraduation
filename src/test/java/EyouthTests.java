import Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class EyouthTests extends BaseTest {
    HomePage homePage;
    // Initialize other pages in @BeforeMethod or per test

    @Test
    @Description("Test Case #1: Search with a valid keyword")
    public void testSearchValidKeyword() {
        homePage = new HomePage(driver);
        homePage.enterSearchKeyword("كيف تنضم إلى البنك");
        SearchPage searchPage = new SearchPage(driver);
        Assert.assertTrue(searchPage.getPageTitle().contains("كيف تنضم إلى البنك"), "Title does not contain keyword");
    }

    @Test
    @Description("Test Case #2: Open course details")
    public void testOpenCourseDetails() {
        homePage = new HomePage(driver);
        homePage.clickAllCourses();
        CoursesPage coursesPage = new CoursesPage(driver);
        coursesPage.selectFirstCourse();
        CourseDetailsPage detailsPage = new CourseDetailsPage(driver);
        Assert.assertTrue(detailsPage.isAboutSectionDisplayed(), "About section not displayed");
    }

    @Test
    @Description("Test Case #3: Open registration page")
    public void testOpenRegistrationPage() {
        homePage = new HomePage(driver);
        homePage.clickJoinUs();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "URL does not contain /signup");
    }

    @Test
    @Description("Test Case #4: Register with an empty username field")
    public void testRegisterEmptyUsername() {
        driver.get(config.getProperty("baseUrl") + "/signup");
        RegistrationPage regPage = new RegistrationPage(driver);
        regPage.fillRegistrationFormExceptUsername("email@example.com", "pass123" /* other data */);
        Assert.assertTrue(regPage.isUsernameErrorDisplayed(), "Validation error not displayed");
    }

    @Test
    public void testLoginValidCredentials() {
        driver.get(config.getProperty("baseUrl") + "signin?redirect=/signin");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(config.getProperty("validUsername"), config.getProperty("validPassword"));
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isUserLoggedIn(), "User not logged in successfully");
    }

    @Test
    @Description("Test Case #5: Login with invalid credentials")
    public void testLoginInvalidCredentials() {
        driver.get(config.getProperty("baseUrl") + "signin?redirect=/signin");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(config.getProperty("invalidUsername"), config.getProperty("invalidPassword"));
        Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message not displayed");
    }

    @Test
    @Description("Test Case #6: Login with empty fields")
    public void testLoginEmptyFields() {
        driver.get(config.getProperty("baseUrl") + "/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");
        Assert.assertTrue(loginPage.areValidationMessagesDisplayed(), "Validation messages not displayed");
    }

    @Test
    @Description("Test Case #7: End-to-end")
    public void testEndToEndSubscription() {
        driver.get(config.getProperty("baseUrl") + "/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(config.getProperty("validUsername"), config.getProperty("validPassword"));
        homePage = new HomePage(driver);
        homePage.clickAllCourses();
        CoursesPage coursesPage = new CoursesPage(driver);
        // Assume we select a course and get its name
        String courseName = "Sample Course"; // Get dynamically
        coursesPage.selectFirstCourse();
        CourseDetailsPage detailsPage = new CourseDetailsPage(driver);

        UserDashboardPage dashboard = new UserDashboardPage(driver);
        Assert.assertTrue(dashboard.isCourseSubscribed(courseName), "Subscribed course not found");
    }

    @Test
    @Description("Test Case #8: Verify Facebook link")
    public void testVerifyFacebookLink() {
        homePage = new HomePage(driver);
        homePage.scrollToFooterAndClickFacebook();
        // Switch to new window
        String mainWindow = driver.getWindowHandle();
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("facebook.com"), "URL does not contain facebook.com");
    }

    // Similar for #9 LinkedIn, #10 Instagram (handle new tab)

    @Test
    @Description("Test Case #11: Verify course cards UI")
    public void testVerifyCourseCardsUI() {
        homePage = new HomePage(driver);
        homePage.clickAllCourses();
        CoursesPage coursesPage = new CoursesPage(driver);
        WebElement firstCard = coursesPage.courseCards.get(0);
        Assert.assertTrue(coursesPage.isCourseCardUIComplete(firstCard), "Course card UI incomplete");
    }
}