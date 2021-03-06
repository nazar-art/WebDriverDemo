package utilities.files;

import org.apache.log4j.Logger;
import utilities.BrowserType;

import java.io.*;
import java.util.Properties;

public class PropertiesFileHandler {
    private static Logger log = Logger.getLogger(PropertiesFileHandler.class);

    public static final String CONFIG_PROPERTIES = "src/main/resources/config.properties";
    public static final String KEY = "browser.type";

    public static BrowserType readBrowserType() {
        BrowserType browserType = null;
        Properties properties = new Properties();

        try (InputStream inputStream = new BufferedInputStream(
                new FileInputStream(CONFIG_PROPERTIES))) {

            properties.load(inputStream);
            browserType = Enum.valueOf(BrowserType.class, properties.getProperty(KEY));

        } catch (FileNotFoundException e) {
            log.error("Properties file wasn't found - " + e);

        } catch (IOException e) {
            log.error("Problem with reading properties file - " + e);
        }
        return browserType;
    }
}
