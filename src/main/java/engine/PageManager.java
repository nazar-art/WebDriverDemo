package engine;

/**
 * @author Nazar Lelyak.
 * @version 1.00 2014-05-21.
 */
public class PageManager {
    private static SeleniumManager seleniumManager = SeleniumManager.getInstance();

    private String baseUrl = WebAppConfig.getInstance().getBaseUrl();
}
