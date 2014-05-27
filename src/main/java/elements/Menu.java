package elements;

import org.openqa.selenium.WebElement;

/**
 * @author Nazar Lelyak.
 * @version 1.00 2014-05-23.
 */
public class Menu extends Element {
    public Menu(WebElement wrappedElement) {
        super(wrappedElement);
    }

    public void click() {
        wrappedElement.click();
    }
}
