package pages;

import org.openqa.selenium.WebDriver;
import task2.WebDriverManager;

import java.sql.DriverManager;

public class BasePage implements IPage {

    protected WebDriver driver = null;

    public BasePage() {
        this.driver = WebDriverManager.getInstance();
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }
}
