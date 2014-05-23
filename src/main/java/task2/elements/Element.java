package task2.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @author Nazar Lelyak.
 * @version 1.00 2014-05-23.
 */
public class Element implements WebElement {

    protected WebElement wrappedElement;

    public Element(WebElement wrappedElement) {
        this.wrappedElement = wrappedElement;
    }

    @Override
    public void click() {
        wrappedElement.click();
    }

    @Override
    public void submit() {
        wrappedElement.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        wrappedElement.sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        wrappedElement.clear();
    }

    @Override
    public String getTagName() {
        return wrappedElement.getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return wrappedElement.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return wrappedElement.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return wrappedElement.isEnabled();
    }

    @Override
    public String getText() {
        return wrappedElement.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return wrappedElement.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return wrappedElement.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return wrappedElement.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return wrappedElement.getLocation();
    }

    @Override
    public Dimension getSize() {
        return wrappedElement.getSize();
    }

    @Override
    public String getCssValue(String propertyName) {
        return wrappedElement.getCssValue(propertyName);
    }
}
