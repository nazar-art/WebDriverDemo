package pages.implementation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.interfaces.ILink;

/**
 * @author Nazar Lelyak.
 * @version 1.00 2014-05-22.
 */
public class LinkImpl extends AbstractElement implements ILink {

    public LinkImpl(WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public ExpectedCondition<WebElement> isReady() {
        return ExpectedConditions.visibilityOf(wrappedElement);
    }

    @Override
    public void clickLink() {
        wrappedElement.click();
    }
}
