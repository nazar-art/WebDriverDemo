package mobile.pages;

import elements.Button;
import elements.ElementDecorator;
import elements.Link;
import elements.Menu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class GmailAndroidPage extends AndroidBasePage {

    @FindBy(xpath = "//div[@onclick=\\\"_e(event, 'sa')\\\"]")
    private Button composeBtn;

    @FindBy(xpath = "//div/a[@id='gb_71']")
    private Link signOutLink;

    @FindBy(xpath = "//div[@id='cmcbody']")
    private WebElement newMessageEditor;

    @FindBy(xpath = "//div[@class='M j T b hc Gs Ue']/div[@class='V j Y Gn Kh']")
    private Button closeMsgBtn;

    @FindBy(xpath = "//div[@onclick=\"_e(event, 'Sb','^r')\"]")
    private Link draftMessagesLink;

    @FindBy(xpath = "//div[@onclick=\"_e(event, 'Ub','^smartlabel_personal')\"]")
    private Link primaryLink;

    @FindBy(xpath = "//span[@class='gb_W gbii']")
    private Menu userOptionsDropDownMenu;

    @FindAll({@FindBy(xpath = "//div//div[@class='Kh Cm']")})
    private WebElement allMessagesPerPage;

    public GmailAndroidPage() {
        PageFactory.initElements(new ElementDecorator(driver), this);
    }

    public void clickComposeBtn() {
//        primaryLink.click();
        new WebDriverWait(driver, 30).until(presenceOfElementLocated(By.xpath("//div[@onclick=\\\"_e(event, 'sa')\\\"]")));
        composeBtn.click();
    }

    public void clickDraftLink() {
        draftMessagesLink.click();
    }

    public void typeTextToMsg(String msg) {
        primaryLink.click();
        new WebDriverWait(driver, 30).until(presenceOfElementLocated(By.xpath("//div[@onclick=\\\"_e(event, 'sa')\\\"]")));
        composeBtn.click();
        new WebDriverWait(driver, 30).until(presenceOfElementLocated(By.xpath("//div[@id='cmcbody']")));
        newMessageEditor.sendKeys(msg);
    }

    @SuppressWarnings("unchecked")
    public List<WebElement> takeAllMsgFromPage() {
        return (List<WebElement>) allMessagesPerPage;
    }

    public void clickCloseMessageBtn() {
        closeMsgBtn.click();
    }
}
