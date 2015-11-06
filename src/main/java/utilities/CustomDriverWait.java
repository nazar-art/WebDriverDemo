package utilities;

import org.apache.log4j.Logger;

public class CustomDriverWait {

    private static Logger log = Logger.getLogger(CustomDriverWait.class);

    private CustomDriverWait() {
    }

    /*public static ExpectedCondition<IElement> presenceOfElementLocated(final By locator) {
        return new ExpectedCondition<IElement>() {
            @Override
            public IElement apply(WebDriver driver) {
                return findElement(locator, driver);
            }

            @Override
            public String toString() {
                return "presence of element located by: " + locator;
            }
        };
    }*/

    /*private static IElement findElement(By by, WebDriver driver) {
        try {
            return driver.findElement(by);
        } catch (NoSuchElementException e) {
            log.error("No such element exception - ", e);
            throw e;
        } catch (WebDriverException e) {
            log.error("WebDriver exception - ", e);
            throw e;
        }
    }*/
}
