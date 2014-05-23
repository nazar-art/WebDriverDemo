package framework.UIElements;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

/**
 * @author nlelyak.
 * @version 1.00 2014-05-23.
 */
public abstract class BaseUIControl {
    private static Logger log = Logger.getLogger(BaseUIControl.class);
    public WebElement controlWrapper;

    public void assign(WebElement element) {
        // todo: add validation of assign compatibility
        controlWrapper = element;
    }

    public boolean isExist() {
        boolean result = controlWrapper != null;
        if (result) {
            // replace by smart assert
            System.out.println("Control state is exist passed");
            log.info("Control state is exist passed");
            return result;
        }
        throw new RuntimeException("Control does not exist");
    }

    public boolean isNotExist() {
        boolean result = controlWrapper == null;
        if (result) {
            // replace by smart assert
            System.out.println("Control state is NOT exist passed");
            log.info("Control state is NOT exist passed");
            return result;
        }
        throw new RuntimeException("Control does not exist");
    }

    public boolean isVisible() {
        if (controlWrapper.isDisplayed()) {
            // replace by smart assert
            System.out.println("Control state is visible passed");
            log.info("Control state is visible passed");
            return true;
        }
        throw new RuntimeException("Control is not visible");
    }

    public boolean isNotVisible() {
        if (!controlWrapper.isDisplayed()) {
            // replace by smart assert
            System.out.println("Control state is not visible passed");
            log.info("Control state is not visible passed");
            return true;
        }
        throw new RuntimeException("Control is in visible state ");
    }

}
