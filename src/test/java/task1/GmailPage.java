package task1;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * @author Nazar Lelyak.
 * @version 1.00 2014-05-20.
 */
public class GmailPage {
    private static Logger log = Logger.getLogger(GmailPage.class);
    private WebDriver driver;

    public static final String COMPOSE_BTN_XPATH = "//*[@class='T-I J-J5-Ji T-I-KE L3']";
    public static final String SIGN_OUT_CSS = "#gb_71";
    public static final String MESSAGE_FRAME_XPATH = "//div[@class = 'Am Al editable']/iframe";
    public static final String SAVE_CLOSE_MESSAGE_XPATH = "//*[@aria-label='Save & Close']";
    public static final String MAIL_INBOX_LINK_XPATH = "//*[@href='https://mail.google.com/mail/#inbox']";
    public static final String MAIL_DRAFTS_LINK_XPATH = "//*[@href='https://mail.google.com/mail/#drafts']";
    public static final String MORE_OPTIONS_LINK_CSS = ".ait";
    public static final String ALL_MAIL_XPATH = "//*[@title='All Mail']";
    public static final String XPATH_ALL_LETTERS_FROM_PAGE = "//div[@id=':2'] //td[@tabindex='-1'] //span[2]";
    public static final String PROFILE_OPTIONS_DROPDOWN_MENU = ".gb_0";
    public static final String LOGIN_URL = "https://www.gmail.com/";

    public GmailPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickProfileImage() {
        driver.findElement(By.cssSelector(PROFILE_OPTIONS_DROPDOWN_MENU)).click();
    }

    public void clickSignOut() {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.
                elementToBeClickable(By.cssSelector(SIGN_OUT_CSS)));
            driver.findElement(By.cssSelector(SIGN_OUT_CSS)).click();
    }

    public void pressComposeButton() {
        driver.findElement(By.xpath(COMPOSE_BTN_XPATH)).click();
    }

    public void sendTextToMessageFrame(String msg) {
            (new WebDriverWait(driver, 10)).until(ExpectedConditions.
                    elementToBeClickable(By.xpath(MESSAGE_FRAME_XPATH)));
            driver.switchTo().frame(driver.findElement(By.xpath(MESSAGE_FRAME_XPATH)));

            WebElement element = driver.switchTo().activeElement();
            element.sendKeys(msg);
            driver.switchTo().defaultContent();
            driver.findElement(By.xpath(SAVE_CLOSE_MESSAGE_XPATH)).click();
    }

    public void clickAllMailLink() {
            (new WebDriverWait(driver, 10)).until(ExpectedConditions.
                    elementToBeClickable(By.cssSelector(MORE_OPTIONS_LINK_CSS)));
            driver.findElement(By.cssSelector(MORE_OPTIONS_LINK_CSS)).click();

            (new WebDriverWait(driver, 10)).until(ExpectedConditions.
                    elementToBeClickable(By.xpath(ALL_MAIL_XPATH)));
            driver.findElement(By.xpath(ALL_MAIL_XPATH)).click();
    }

    public void clickInboxLink() {
        driver.findElement(By.xpath(MAIL_INBOX_LINK_XPATH)).click();
    }

    public void clickDraftLink() {
        driver.findElement(By.xpath(MAIL_DRAFTS_LINK_XPATH)).click();
    }

    public List<WebElement> takeAllMessage() {
        return driver.findElements(By.xpath(XPATH_ALL_LETTERS_FROM_PAGE));
    }

    public List<WebElement> takeInboxMessage() {
        return driver.findElements(By.xpath(XPATH_ALL_LETTERS_FROM_PAGE));
    }

    public List<WebElement> takeDraftMessage() {
        return driver.findElements(By.xpath(XPATH_ALL_LETTERS_FROM_PAGE));
    }
}
