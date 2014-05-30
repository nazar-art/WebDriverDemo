package framework.UIElements;

import org.apache.log4j.Logger;

/**
 * @author nlelyak.
 * @version 1.00 2014-05-23.
 */
public class BaseUIEnabledControl extends BaseUIControl {

    private static Logger log = Logger.getLogger(BaseUIEnabledControl.class);

    public boolean isEnabled() {
        if ((isVisible()) && (controlWrapper.isEnabled())) {
            // replace by smart assert
            log.info("Control state is enabled passed");
            return true;
        }
        throw new RuntimeException("Control is not enabled");
    }

    public boolean isNotEnabled() {
        if ((isVisible()) && (!controlWrapper.isEnabled())) {
            // replace by smart assert
            log.info("Control state is not enabled passed");
            return true;
        }
        throw new RuntimeException("Control is not enabled");
    }

    public void click() {
        controlWrapper.click();
        // todo : add current page
    }


    public boolean verifyText(String expText) {
        String actText = controlWrapper.getText();

        // todo: improve verify flow
        boolean compareRes = actText.equals(expText);
        if (compareRes) {
            log.info("Control Text verification passed");
            return true;
        }
        throw new RuntimeException(String.format("Control Text verification failed. Actual - %s, Expected - %s" +
                "", actText, expText));
    }

}
