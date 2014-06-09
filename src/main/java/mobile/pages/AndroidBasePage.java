package mobile.pages;

import framework.seleniumEngine.SeleniumManager;
import org.openqa.selenium.WebDriver;
import pages.IPage;
import pages.utils.BrowserType;

public class AndroidBasePage implements IPage {

    protected WebDriver driver = null;

    public AndroidBasePage() {
        driver = SeleniumManager.start(BrowserType.Android_Chrome);
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }
}
