package engine;

/**
 * @author Nazar Lelyak.
 * @version 1.00 2014-05-21.
 */
public class WebAppConfig {
    private String baseUrl;

    private static volatile WebAppConfig instance = new WebAppConfig();

    private WebAppConfig() {
        initConfig();
    }

    private void initConfig() {
        String fPath = "../resources/webAutomationConfig.xml";


    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public static WebAppConfig getInstance() {
        return instance;
    }
}
