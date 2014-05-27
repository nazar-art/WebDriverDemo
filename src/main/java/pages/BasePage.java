package pages;

import org.openqa.selenium.WebDriver;
import pages.utils.DriverPool;

public class BasePage implements IPage {

    protected WebDriver driver = null;

    public BasePage() {
//        this.driver = WebDriverManager.getInstance();
        this.driver = DriverPool.getInstance();
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }
}
