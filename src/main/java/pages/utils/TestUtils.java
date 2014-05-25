package pages.utils;

import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class TestUtils {

    private static Logger log = Logger.getLogger(TestUtils.class);

    public static final String TEST_MESSAGE_FOR_GMAIL_PAGE_TEST = "This is the test message for draft link";
    public static final String XPATH_ALL_LETTERS_FROM_PAGE = "//div[@id=':2'] //td[@tabindex='-1'] //span[2]";

    public static void interrupt(TimeUnit timeUnit, long time) {
        synchronized (TestUtils.class) {
            try {
                timeUnit.sleep(time);
            } catch (InterruptedException e) {
                log.error("interrupt exception, more details - ", e);
            }
        }
    }

}
