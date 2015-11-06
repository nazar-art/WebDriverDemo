package elements;

import org.openqa.selenium.WebElement;

public class Link extends Element {
    public Link(WebElement wrappedElement) {
        super(wrappedElement);
    }

    public void click() {
        wrappedElement.click();
    }

    public void isEnabled() {
        wrappedElement.isEnabled();
    }

    public void isDisplayed() {
        wrappedElement.isDisplayed();
    }

}
