package task2;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.Field;

public class ElementDecorator extends DefaultFieldDecorator {

    public ElementDecorator(SearchContext searchContext) {
        super(new DefaultElementLocatorFactory(searchContext));
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        Class<?> decoratableClass = decoratableClass(field);

        // if class of this parameter is decoratable
        if (decoratableClass != null) {
            ElementLocator locator = factory.createLocator(field);
            if (locator == null) {
                return null;
            }

            // create element for custom class
            return createElement(loader, locator, decoratableClass);
        }

        return super.decorate(loader, field);
    }

    private Class<?> decoratableClass(Field field) {
        Class<?> clazz = field.getType();
        // field should have constructor for WebElement
        try {
            clazz.getConstructor(WebElement.class);
        } catch (Exception e) {
            return null;
        }

        return clazz;
    }

    protected <T> T createElement(ClassLoader loader, ElementLocator locator, Class<T> clazz) {
        WebElement proxy = proxyForLocator(loader, locator);
        return createInstance(clazz, proxy);
    }

    private <T> T createInstance(Class<T> clazz, WebElement element) {
        try {
            return clazz.getConstructor(WebElement.class).newInstance(element);
        } catch (Exception e) {
            throw new AssertionError("WebElement can't be represented as " + clazz);
        }
    }

}
