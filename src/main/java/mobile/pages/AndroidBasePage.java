package mobile.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.drivers.SeleniumManager;
import org.openqa.selenium.WebDriver;
import pages.IPage;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public abstract class AndroidBasePage implements IPage {

    public static final int WAIT_TIME = 30;

    protected WebDriver driver = null;

    private WebDriverWait driverWait;

    public AndroidBasePage() {
        driver = SeleniumManager.activeBrowser();
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
