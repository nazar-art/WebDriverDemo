package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.drivers.DriverManager;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class BasePage implements IPage {

    public static final int WAIT_TIME = 30;

    protected WebDriver driver;
    private WebDriverWait driverWait;

    public BasePage() {
        this.driver = DriverManager.getInstance();
//        driver instance for parallel test
//        this.driver = DriverPool.getDriver();
        driverWait = new WebDriverWait(driver, WAIT_TIME);
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    protected void waitPresence(String xpath) {
        driverWait.until(presenceOfElementLocated(By.xpath(xpath)));
    }

    protected void waitClickable(String xpath) {
        driverWait.until(elementToBeClickable(By.xpath(xpath)));
    }
}
