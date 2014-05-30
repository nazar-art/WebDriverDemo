package framework.seleniumEngine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author Nazar Lelyak.
 * @version 1.00 2014-05-21.
 */
public class FindManager {

    private SeleniumManager seleniumManager = SeleniumManager.getInstance();

    public WebElement findUIElement(UIMapping uiMapping) {
        WebElement element = null;

        if (uiMapping.getSearchLevelType() == SearchLevelType.Page) {
            if (uiMapping.getSearchType() == SearchType.ByXpath) {
                element = SeleniumManager.activeBrowser().findElement(By.xpath(uiMapping.getLocator()));
            } else {
                throw new RuntimeException();
            }
        } else {
            throw new RuntimeException();
        }
        return element;
    }
}
