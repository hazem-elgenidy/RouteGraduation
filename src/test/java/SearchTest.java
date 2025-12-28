import Pages.HomePage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest{
    @Test
    public void searchValidKeyword() {
        HomePage home = new HomePage(driver);
        driver.get("https://eyouthlearning.com/search?query=كيف%20تنضم%20إلى%20برنامج%20المتدربين%20في%20إي%20يوث%20ليرنينج");
        Assert.assertTrue(driver.getTitle().contains("كيف تنضم"));
    }
}
