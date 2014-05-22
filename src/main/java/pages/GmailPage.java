package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
    public static final String MORE_OPTIONS_LINK_CSS = "//*[@class='ait']";
    public static final String ALL_MAIL_XPATH = "//*[@title='All Mail']";
    public static final String XPATH_ALL_LETTERS_FROM_PAGE = "//div[@id=':2'] //td[@tabindex='-1'] //span[2]";
    public static final String PROFILE_OPTIONS_DROPDOWN_MENU = ".gb_0";
    public static final String LOGIN_URL = "https://www.gmail.com/";

    @FindBy(xpath = COMPOSE_BTN_XPATH)
    private WebElement composeBtn;

    @FindBy(css = SIGN_OUT_CSS)
    private WebElement signOutLink;

    @FindBy(xpath = MESSAGE_FRAME_XPATH)
    private WebElement frameMessageEditor;

    @FindBy(xpath = SAVE_CLOSE_MESSAGE_XPATH)
    private WebElement frameSaveAndCloseBtn;

    @FindBy(xpath = MAIL_INBOX_LINK_XPATH)
    private WebElement inboxMessagesLink;

    @FindBy(xpath = MAIL_DRAFTS_LINK_XPATH)
    private WebElement draftMessagesLink;

    @FindBy(xpath = MORE_OPTIONS_LINK_CSS)
    private WebElement moreOptionsLink;

    @FindBy(xpath = ALL_MAIL_XPATH)
    private WebElement allMailLink;

    @FindBy(css = PROFILE_OPTIONS_DROPDOWN_MENU)
    private WebElement userOptionsDropDownMenu;

    public GmailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickProfileImage() {
        userOptionsDropDownMenu.click();
    }

    public void clickSignOut() {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.
                elementToBeClickable(signOutLink));
        signOutLink.click();
    }

    public void pressComposeButton() {
        composeBtn.click();
    }

    public void sendTextToMessageFrame(String msg) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.
                elementToBeClickable(frameMessageEditor));
        driver.switchTo().frame(frameMessageEditor);

        WebElement element = driver.switchTo().activeElement();
        element.sendKeys(msg);
        driver.switchTo().defaultContent();
        frameSaveAndCloseBtn.click();
    }

    public void clickAllMailLink() {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.
                elementToBeClickable(moreOptionsLink));
        moreOptionsLink.click();

        (new WebDriverWait(driver, 10)).until(ExpectedConditions.
                elementToBeClickable(allMailLink));
        allMailLink.click();
    }

    public void clickInboxLink() {
        inboxMessagesLink.click();
    }

    public void clickDraftLink() {
        draftMessagesLink.click();
    }

    public List<WebElement> takeAllMessage() {
        List<WebElement> elements = null;
        try {
            Thread.sleep(1000);
            elements =
                    driver.findElements(By.xpath(XPATH_ALL_LETTERS_FROM_PAGE));
        } catch (InterruptedException e) {
            log.error(e);
        }
        return elements;
    }

    public List<WebElement> takeInboxMessage() {
        return driver.findElements(By.xpath(XPATH_ALL_LETTERS_FROM_PAGE));
    }

    public List<WebElement> takeDraftMessage() {
        return driver.findElements(By.xpath(XPATH_ALL_LETTERS_FROM_PAGE));
    }
}
