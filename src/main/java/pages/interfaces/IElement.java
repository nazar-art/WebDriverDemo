package pages.interfaces;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * @author Nazar Lelyak.
 * @version 1.00 2014-05-22.
 */
public interface IElement {
    public boolean isDisplayed();
    public void click();
    public ExpectedCondition<WebElement> isReady();
}
