package framework.seleniumEngine;

import framework.UIElements.BaseUIPage;
import framework.UIElements.UIControlBuilder;

/**
 * @author Nazar Lelyak.
 * @version 1.00 2014-05-21.
 */
public class PageManager {
    private static SeleniumManager seleniumManager = SeleniumManager.getInstance();

    private String baseUrl = WebAppConfig.getInstance().getBaseUrl();

    public BaseUIPage navigateTo(UIMapping pageMapping) {
        String navigateUrl = baseUrl + pageMapping.getLocator();
        seleniumManager.activeBrowser().get(navigateUrl);

        return UIControlBuilder.buildPage(pageMapping);
    }

}
