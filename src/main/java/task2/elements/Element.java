package task2.elements;

import org.openqa.selenium.WebElement;

public class Element implements IElement {

    protected WebElement wrappedElement;

    public Element(WebElement wrappedElement) {
        this.wrappedElement = wrappedElement;
    }

}
