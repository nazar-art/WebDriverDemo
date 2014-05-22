package pages.implementation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.interfaces.ILabel;

/**
 * @author Nazar Lelyak.
 * @version 1.00 2014-05-22.
 */
public class LabelImpl extends AbstractElement implements ILabel {

    public LabelImpl(WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public ExpectedCondition<WebElement> isReady() {
        return ExpectedConditions.visibilityOf(wrappedElement);
    }

    @Override
    public String getText() {
        return wrappedElement.getText();
    }
}
