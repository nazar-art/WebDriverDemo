package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import task2.ElementDecorator;
import task2.elements.*;

import java.util.List;

/**
 * @author Nazar Lelyak.
 * @version 1.00 2014-05-20.
 */
public class GmailPage {

    private static Logger log = Logger.getLogger(GmailPage.class);

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private Button composeBtn;

    @FindBy(css = "#gb_71")
    private Link signOutLink;

//    @FindBy(xpath = "//div[@class = 'Am Al editable']/iframe")
    @FindBy(xpath = "//iframe[@tabindex='1']")
    private WebElement frameMessageEditor;

    @FindBy(xpath = "//img[@aria-label='Save & Close']")
    private Button frameSaveAndCloseBtn;

    @FindBy(xpath = "//*[starts-with(@title, 'Inbox')]")
    private TextField inboxMessagesLink;

    @FindBy(xpath = "//a[starts-with(@title, 'Drafts')]")
    private Link draftMessagesLink;

    @FindBy(xpath = "//*[@class='ait']")
    private Link moreOptionsLink;

    @FindBy(xpath = "//*[@title='All Mail']")
    private Link allMailLink;

    @FindBy(css = ".gb_0")
    private Menu userOptionsDropDownMenu;

    public GmailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new ElementDecorator(driver), this);
    }

    public void clickProfileOptionMenu() {
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
//        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(frameMessageEditor));
        try {
            Thread.sleep(1000);
            driver.switchTo().frame(frameMessageEditor);
            WebElement element = driver.switchTo().activeElement();
            Thread.sleep(1000);
            element.sendKeys(msg);
            Thread.sleep(1000);
            driver.switchTo().defaultContent();
            frameSaveAndCloseBtn.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

    public List<WebElement> takeAllMessages() {
        List<WebElement> elements = null;
        try {
            Thread.sleep(1000);
            elements =
                    driver.findElements(By.xpath(TestUtils.XPATH_ALL_LETTERS_FROM_PAGE));
        } catch (InterruptedException e) {
            log.error(e);
        }
        return elements;
    }

    public List<WebElement> takeInboxMessage() {
        return driver.findElements(By.xpath(TestUtils.XPATH_ALL_LETTERS_FROM_PAGE));
    }

    public List<WebElement> takeDraftMessage() {
        return driver.findElements(By.xpath(TestUtils.XPATH_ALL_LETTERS_FROM_PAGE));
    }

    public void clickComposeBtn() {
        composeBtn.click();
    }

    public void typeTextToMessage(String msg) {
        frameMessageEditor.sendKeys(msg);
    }

    public void clickSaveAndCloseBtn() {
        frameSaveAndCloseBtn.click();
    }

}
