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

    @FindBy(xpath = "//div[starts-with(@class, 'M j T b hc Fn Pn Re')]")
    private Button composeBtn;

    @FindBy(xpath = "//div/a[@id='gb_71']")
    private Link signOutLink;

    @FindBy(xpath = "//div[@id='cmcbody']")
    private WebElement newMessageEditor;

    @FindBy(xpath = "//div[@class='M j T b hc Gs Ue']/div[@class='V j Y Gn Kh']")
    private Button closeMsgBtn;

    @FindBy(xpath = "//div[@class='Jl ec']/span[contains(text(), 'Drafts')]")
    private Link draftMessagesLink;

    @FindBy(xpath = "//div[@class='M j T b hc zp q m']/div[contains(text(), 'Save')]")
    private Link saveLetter;

    @FindBy(xpath = "//span[@class='gb_W gbii']")
    private Menu userOptionsMenu;

    @FindBy(xpath = "//div[starts-with(@class, 'V j Ld')]")
    private Button optionsBtn;

    @FindAll({ @FindBy(xpath = "//div//div[@class='Kh Cm']") })
    private List<WebElement> allMessagesPerPage;

    public GmailAndroidPage() {
        PageFactory.initElements(new ElementDecorator(driver), this);
    }

    public void clickComposeBtn() {
        new WebDriverWait(driver, 30).until(presenceOfElementLocated(By.xpath("//div[starts-with(@class, 'M j T b hc Fn Pn Re')]")));
        composeBtn.click();
    }

    public void clickDraftLink() {
        new WebDriverWait(driver, 30).until(presenceOfElementLocated(By.xpath("//div[starts-with(@class, 'V j Ld')]")));
        optionsBtn.click();
        new WebDriverWait(driver, 30).until(presenceOfElementLocated(By.xpath("//div[@class='Jl ec']/span[contains(text(), 'Drafts')]")));
        draftMessagesLink.click();
        new WebDriverWait(driver, 30).until(presenceOfElementLocated(By.xpath("//div//div[@class='Kh Cm']")));
    }

    public void typeTextToMsg(String msg) {
        newMessageEditor.sendKeys(msg);
    }

    public List<WebElement> takeAllMsgFromPage() {
        return allMessagesPerPage;
    }

    public void clickCloseMessageBtn() {
        closeMsgBtn.click();
        new WebDriverWait(driver, 30).until(presenceOfElementLocated(By.xpath("//div[@class='M j T b hc zp q m']/div[contains(text(), 'Save')]")));
        saveLetter.click();
    }

    public void logOutUser() {
        new WebDriverWait(driver, 30).until(presenceOfElementLocated(By.xpath("//span[@class='gb_W gbii']")));
        userOptionsMenu.click();
        new WebDriverWait(driver, 30).until(presenceOfElementLocated(By.xpath("//div/a[@id='gb_71']")));
        signOutLink.click();
    }
}
