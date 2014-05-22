package pages.implementation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import pages.interfaces.IElement;

/**
 * @author Nazar Lelyak.
 * @version 1.00 2014-05-22.
 */
public abstract class AbstractElement implements IElement {

    protected WebElement wrappedElement;

    protected AbstractElement(WebElement wrappedElement) {
        this.wrappedElement = wrappedElement;
    }

    @Override
    public boolean isDisplayed() {
        return wrappedElement.isDisplayed();
    }

    @Override
    public void click() {
        wrappedElement.click();
    }

    @Override
    public abstract ExpectedCondition<WebElement> isReady();
}
