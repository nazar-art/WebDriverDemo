package framework.UIElements;

import org.openqa.selenium.WebElement;

/**
 * @author nlelyak.
 * @version 1.00 2014-05-23.
 */
public class BaseUIPage {
    // todo - move to config file
    public String baseUrl = "https://www.gmail.com";

    protected WebElement pageWrapper;

    public void assign(WebElement element) {
        // todo: add validation of assign compatibility
        pageWrapper = element;
    }

}
