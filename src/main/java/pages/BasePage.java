package pages;

import org.openqa.selenium.WebDriver;
import pages.utils.WebDriverManager;

public class BasePage implements IPage {

    protected WebDriver driver = null;

    public BasePage() {
        this.driver = WebDriverManager.getInstance();
//        driver instance for parallel test
//        this.driver = DriverPool.getDriver();
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }
}
