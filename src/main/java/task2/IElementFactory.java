package task2;

import org.openqa.selenium.WebElement;
import pages.interfaces.IElement;

/**
 * @author Nazar Lelyak.
 * @version 1.00 2014-05-22.
 */
public interface IElementFactory {
    <E extends IElement> E create(Class<E> elementClass, WebElement wrappedElement);
}
