package utilities;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProrpertiesFileHandler {

    private static Logger log = Logger.getLogger(ProrpertiesFileHandler.class);

    public static final String CONFIG_PROPERTIES = "src/main/resources/config.properties";
    public static final String KEY = "browser.type";

    public static BrowserType readBrowserType() {
        BrowserType browserType = null;
        Properties properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream(CONFIG_PROPERTIES);

            properties.load(inputStream);
            browserType = Enum.valueOf(BrowserType.class, properties.getProperty(KEY));
            inputStream.close();
        } catch (FileNotFoundException e) {
            log.error("Properties file wasn't found - " + e);
        } catch (IOException e) {
            log.error("Problem with reading properties file - " + e);
        }

        return browserType;
    }
}
