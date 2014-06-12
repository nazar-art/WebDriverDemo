package pages;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.drivers.DriverManager;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public abstract class BasePage implements IPage {

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

    public WebElement fluentWait(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        return wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
    }
}
