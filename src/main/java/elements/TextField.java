package elements;

import org.openqa.selenium.WebElement;

public class TextField extends Element {
    public TextField(WebElement wrappedElement) {
        super(wrappedElement);
    }

    public void clear() {
        wrappedElement.clear();
    }

    public void typeText(String msg) {
        wrappedElement.sendKeys(msg);
    }
}
