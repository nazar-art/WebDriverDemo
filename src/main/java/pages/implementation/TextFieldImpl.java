package pages.implementation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.interfaces.ITextField;

/**
 * @author Nazar Lelyak.
 * @version 1.00 2014-05-22.
 */
public class TextFieldImpl extends AbstractElement implements ITextField {

    public TextFieldImpl(WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public ExpectedCondition<WebElement> isReady() {
        return ExpectedConditions.elementToBeClickable(wrappedElement);
    }

    @Override
    public void clear() {
        wrappedElement.clear();
    }

    @Override
    public void typeText(String text) {
        wrappedElement.sendKeys(text);
    }

    @Override
    public void clearAndType(String text) {
        clear();
        typeText(text);
    }
}
