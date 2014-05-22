package pages.implementation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.interfaces.IButton;

/**
 * @author Nazar Lelyak.
 * @version 1.00 2014-05-22.
 */
public class ButtonImpl extends AbstractElement implements IButton {

    protected ButtonImpl(WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public ExpectedCondition<WebElement> isReady() {
        return ExpectedConditions.elementToBeClickable(wrappedElement);
    }
}
