package mobile.pages;

import utilities.drivers.SeleniumManager;
import org.openqa.selenium.WebDriver;
import pages.IPage;

public class AndroidBasePage implements IPage {

    protected WebDriver driver = null;

    public AndroidBasePage() {
        driver = SeleniumManager.activeBrowser();
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }
}
