package framework.seleniumEngine;

import framework.UIElements.BaseUIPage;
import framework.UIElements.UIControlBuilder;

public class PageManager {
    private static SeleniumManager seleniumManager = SeleniumManager.getInstance();

//    private String baseUrl = WebAppConfig.getInstance().getBaseUrl();

    public BaseUIPage navigateTo(UIMapping pageMapping) {
        String navigateUrl = pageMapping.getLocator();
        seleniumManager.activeBrowser().get(navigateUrl);

        return UIControlBuilder.buildPage(pageMapping);
    }

}
