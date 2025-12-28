import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest {

    private WebDriver driver;
    HomePage homePage;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);

    }
//    @Test
//    public void registerWithEmptyFields() {
//        homePage.goToRegisterPage();
//
//
//    }
}