package task5;

import mobile.business.GmailAndroidBO;
import mobile.business.LoginAndroidBO;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.URL;
import java.util.List;


public class TestGmailAndroidPage {

    public static final String TEST_MESSAGE = "This is test message";
    private static Logger log = Logger.getLogger(TestGmailAndroidPage.class);
    private WebDriver driver;
    private GmailAndroidBO androidBO;

    public static final String LOGIN_URL = "https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=uk&service=mail";

    public static String USER_LOGIN = "testt3820@gmail.com";
    public static String USER_PASSWORD = "CreateAPassword";

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Browser");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("platformVersion", "4.4.2");

        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        // login to gmail page
        driver.get(LOGIN_URL);
        LoginAndroidBO loginAndroidBO = new LoginAndroidBO();
        loginAndroidBO.login(USER_LOGIN, USER_PASSWORD);

        /*driver.findElement(By.id("Email")).sendKeys(USER_LOGIN);
        driver.findElement(By.id("Passwd")).sendKeys(USER_PASSWORD);
        driver.findElement(By.id("signIn")).click();
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().contains("gmail");
            }
        });*/
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void DraftLinkAndroidTest() {
        /*// move to gmail page
        driver.get("https://mail.google.com/mail/u/0/?tab=Xm&pli=1#inbox");
        // write new message
        driver.findElement(By.xpath("//div[@class = 'T-I J-J5-Ji T-I-KE L3']")).click();
        driver.findElement(By.id(":6r")).sendKeys(TEST_MESSAGE);*/

        List<WebElement> draftLetters = androidBO.checkSavingDraftLetter(TEST_MESSAGE);
        Assert.assertTrue(letterContainsTextMessage(draftLetters, TEST_MESSAGE));
    }

    /**
     * Check if list of letters from page contains text message.
     *
     * @param webElementList list of web elements.
     * @param message        test message.
     * @return if letter contain message true, otherwise false.
     */
    public boolean letterContainsTextMessage(List<WebElement> webElementList, String message) {
        for (WebElement element : webElementList) {
            String fullLetterText = element.getText().trim();
            System.out.printf("full: %s%n", fullLetterText);
            if (fullLetterText.startsWith("-")) {
                String letterText = fullLetterText.substring(2);
                System.out.printf("short: %s%n", letterText);
                if (letterText.equals(message)) {
                    return true;
                }
            }
        }
        return false;
    }

}
