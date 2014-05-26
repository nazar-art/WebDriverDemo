package task2.elements;

import org.openqa.selenium.WebElement;

public class Button extends Element {
    public Button(WebElement wrappedElement) {
        super(wrappedElement);
    }

    public void click() {
        wrappedElement.click();
    }

}
