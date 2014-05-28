package pages;

import elements.Button;
import elements.ElementDecorator;
import elements.Link;
import elements.Menu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.utils.TestUtils;

import java.util.Collections;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;
import static pages.utils.TestUtils.interrupt;

public class GmailPage extends BasePage {

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private Button composeBtn;

    @FindBy(css = "#gb_71")
    private Link signOutLink;

    @FindBy(xpath = "//div[@class = 'Am Al editable']/iframe")
    private WebElement frameMessageEditor;

    @FindBy(xpath = "//img[@aria-label='Save & Close']")
    private Button saveAndCloseFrameBtn;

    @FindBy(xpath = "//*[starts-with(@title, 'Inbox')]")
    private Link inboxMessagesLink;

    @FindBy(xpath = "//a[starts-with(@title, 'Drafts')]")
    private Link draftMessagesLink;

    @FindBy(xpath = "//*[@class='ait']")
    private Link moreOptionsLink;

    @FindBy(xpath = "//*[@title='All Mail']")
    private Link allMailLink;

    @FindBy(css = ".gb_0")
    private Menu userOptionsDropDownMenu;

    @FindAll({@FindBy(xpath = "//div[@id=':2'] //td[@tabindex='-1'] //span[2]")})
    private WebElement allMessagesPerPage;

    public GmailPage() {
        PageFactory.initElements(new ElementDecorator(driver), this);
    }

    public void clickProfileOptionMenu() {
        userOptionsDropDownMenu.click();
    }

    public void clickSignOut() {
        /*(new WebDriverWait(driver, 10)).until(ExpectedConditions.
                elementToBeClickable(signOutLink));*/
        interrupt(SECONDS, 1);
        signOutLink.click();
    }

    public void pressComposeButton() {
        composeBtn.click();
    }

    public void sendTextToMessageFrame(String msg) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(frameMessageEditor));
        driver.switchTo().frame(frameMessageEditor);
        WebElement element = driver.switchTo().activeElement();
        interrupt(SECONDS, 1);
        element.sendKeys(msg);
        interrupt(SECONDS, 1);
        driver.switchTo().defaultContent();
        saveAndCloseFrameBtn.click();
    }

    public void clickAllMailLink() {
        interrupt(SECONDS, 1);
        moreOptionsLink.click();

        interrupt(SECONDS, 1);
        allMailLink.click();
    }

    public void clickInboxLink() {
        inboxMessagesLink.click();
    }

    public void clickDraftLink() {
        draftMessagesLink.click();
    }

    public synchronized List<WebElement> takeAllMessages() {
        List<WebElement> elements = null;
        interrupt(SECONDS, 1);
        elements = driver.findElements(By.xpath(TestUtils.XPATH_ALL_LETTERS_FROM_PAGE));
        return Collections.synchronizedList(elements);
    }

    public List<WebElement> takeInboxMessage() {
        return driver.findElements(By.xpath(TestUtils.XPATH_ALL_LETTERS_FROM_PAGE));
    }

    @SuppressWarnings("unchecked")
    public List<WebElement> takeDraftMessage() {
        return (List<WebElement>) allMessagesPerPage;
    }

    public void clickComposeBtn() {
        composeBtn.click();
    }

    public void typeTextToMessage(String msg) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(frameMessageEditor));
        driver.switchTo().frame(frameMessageEditor);
        WebElement element = driver.switchTo().activeElement();
        element.sendKeys(msg);
        driver.switchTo().defaultContent();
    }

    public void clickSaveAndCloseBtn() {
        saveAndCloseFrameBtn.click();
    }

}
