package framework.UIElements;

import framework.seleniumEngine.FindManager;
import utilities.drivers.SeleniumManager;
import framework.seleniumEngine.UIMapping;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author nlelyak.
 * @version 1.00 2014-05-23.
 */
public class UIControlBuilder {
    private static Logger log = Logger.getLogger(UIControlBuilder.class);

    private static SeleniumManager manager = SeleniumManager.getInstance();

    private static FindManager findManager = new FindManager();

    public static BaseUIControl buildControl(UIMapping uiMapping) {
        Object controlInst = null;

        try {
            // get control type
            Class controlType = uiMapping.getControlType();
            // create control instance
            controlInst = controlType.newInstance();

            WebElement pageControl = findManager.findUIElement(uiMapping);
            ((BaseUIControl) controlInst).assign(pageControl);
        } catch (InstantiationException ex) {
            log.error("Unable to create object", ex);
        } catch (IllegalAccessException ex) {
            log.error("No access during object creation", ex);
        }

        // cast instance
        return (BaseUIControl) controlInst;
    }

    public static BaseUIPage buildPage(UIMapping uiMapping) {
        Object controlInst = null;

//        String baseUrl = WebAppConfig.getInstance().getBaseUrl();

        // validate if page can be construct
        String currentUrl = manager.activeBrowser().getCurrentUrl();
//        String expUrl = baseUrl + uiMapping.getLocator();
        String expUrl = uiMapping.getLocator();

        // todo - replace by smart validation
        if (!currentUrl.equalsIgnoreCase(expUrl)) {
            throw new RuntimeException("Requested Page not found. Page url - " + expUrl);
        }

        try {
            // get control type
            Class controlType = uiMapping.getControlType();
            // create control instanceA
            controlInst = controlType.newInstance();

            //manager.activeBrowser().get(currentUrl);
            // find page root
            WebElement pageRoot = manager.activeBrowser().findElement(By.xpath("//body"));
            ((BaseUIPage) controlInst).assign(pageRoot);

        } catch (InstantiationException ex) {
            log.error("Unable to create object.", ex);
        } catch (IllegalAccessException ex) {
            log.error("No access during object creation.", ex);
        }

        // cast instance
        return (BaseUIPage) controlInst;
    }
}
