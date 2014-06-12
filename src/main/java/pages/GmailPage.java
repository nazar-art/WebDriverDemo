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
import utilities.TestUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static utilities.TestUtils.interrupt;

public class GmailPage extends BasePage {

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private Button composeBtn;

    @FindBy(xpath = "//div[@class='gb_ha']//a[contains(text(), 'Sign')]")
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

    @FindBy(xpath = "//a[@class='gb_y gb_4 gb_e']/span[@class='gb_W gbii']")
    private Menu userOptionsDropDownMenu;

    @FindAll( {@FindBy(xpath = "//div[@id=':2'] //td[@tabindex='-1'] //span[2]")} )
    private List<WebElement> allMessagesPerPage;

    public GmailPage() {
        PageFactory.initElements(new ElementDecorator(driver), this);
    }

    public void clickProfileOptionMenu() {
        userOptionsDropDownMenu.click();
    }

    public void clickSignOut() {
        waitClickable("//div[@class='gb_ha']//a[contains(text(), 'Sign')]");
        signOutLink.click();
    }

    public void pressComposeButton() {
        composeBtn.click();
    }

    public void sendTextToMessageFrame(String msg) {
        waitClickable("//div[@class = 'Am Al editable']/iframe");
        driver.switchTo().frame(frameMessageEditor);
        WebElement element = driver.switchTo().activeElement();
        element.sendKeys(msg);
        driver.switchTo().defaultContent();
        saveAndCloseFrameBtn.click();
    }

    public void clickDraftLink() {
        draftMessagesLink.click();
        interrupt(TimeUnit.SECONDS, 1);
    }

    public synchronized List<WebElement> takeAllMessages() {
        return allMessagesPerPage;
    }

    public void clickComposeBtn() {
//        new WebDriverWait(driver, 30).until(presenceOfElementLocated(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']")));
        waitPresence("//div[@class='T-I J-J5-Ji T-I-KE L3']");
        composeBtn.click();
    }

    public void typeTextToMessage(String msg) {
        waitPresence("//div[@class = 'Am Al editable']/iframe");
        driver.switchTo().frame(frameMessageEditor);
        WebElement element = driver.switchTo().activeElement();
        element.sendKeys(msg);
        driver.switchTo().defaultContent();
    }

    public void clickSaveAndCloseBtn() {
        saveAndCloseFrameBtn.click();
    }

    public List<WebElement> takeInboxMessage() {
        return driver.findElements(By.xpath(TestUtils.XPATH_ALL_LETTERS_FROM_PAGE));
    }

    public List<WebElement> takeDraftMessage() {
        return allMessagesPerPage;
    }

    public void clickAllMailLink() {
        moreOptionsLink.click();
        allMailLink.click();
    }

    public void clickInboxLink() {
        inboxMessagesLink.click();
    }

}
