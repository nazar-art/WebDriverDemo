package pages;

import org.openqa.selenium.WebDriver;
import utilities.DriverManager;

public class BasePage implements IPage {

    protected WebDriver driver = null;

    public BasePage() {
        this.driver = DriverManager.getInstance();
//        driver instance for parallel test
//        this.driver = DriverPool.getDriver();
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }
}
