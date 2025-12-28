package Pages;

import org.openqa.selenium.WebDriver;

public class SearchPage {


    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}