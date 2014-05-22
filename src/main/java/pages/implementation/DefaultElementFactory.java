package pages.implementation;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import pages.interfaces.IElement;
import task2.IElementFactory;

import java.lang.reflect.InvocationTargetException;

import static java.text.MessageFormat.format;

/**
 * @author Nazar Lelyak.
 * @version 1.00 2014-05-22.
 */
public class DefaultElementFactory implements IElementFactory {

    private static Logger log = Logger.getLogger(DefaultElementFactory.class);

    @Override
    public <E extends IElement> E create(final Class<E> elementClass, final WebElement wrappedElement) {
        try {
            return findImplementationFor(elementClass)
                    .getDeclaredConstructor(WebElement.class)
                    .newInstance(wrappedElement);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    private <E extends IElement> Class<? extends E> findImplementationFor(final Class<E> elementClass) {
        try {
            return (Class<? extends E>) Class.forName(format("{0}.{1}Impl", getClass().getPackage().getName(), elementClass.getSimpleName()));
        } catch (ClassNotFoundException e) {
            log.error("DefaultElementFactory class - findImplementationFor()", e);
            throw new RuntimeException(e);
        }
    }
}
