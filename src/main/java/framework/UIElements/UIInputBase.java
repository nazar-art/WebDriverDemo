package framework.UIElements;

/**
 * @author nlelyak.
 * @version 1.00 2014-05-23.
 */
public class UIInputBase extends BaseUIEnabledControl {
    public void typeText(String textToSet) {
        controlWrapper.sendKeys(textToSet);
    }
}
