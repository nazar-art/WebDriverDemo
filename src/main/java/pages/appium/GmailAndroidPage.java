package pages.appium;

import elements.Button;
import elements.ElementDecorator;
import elements.Link;
import elements.Menu;
import framework.seleniumEngine.SeleniumManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.GmailPage;
import pages.utils.BrowserType;

public class GmailAndroidPage extends GmailPage {

    private WebDriver driver = SeleniumManager.start(BrowserType.Android_Chrome);

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private Button composeBtn;

    @FindBy(css = "#gb_71")
    private Link signOutLink;

    @FindBy(xpath = "//div[@class = 'Am Al editable']/iframe")
    private WebElement frameMessageEditor;

    @FindBy(xpath = "//img[@aria-label='Save & Close']")
    private Button saveAndCloseFrameBtn;

    @FindBy(xpath = "//a[starts-with(@title, 'Drafts')]")
    private Link draftMessagesLink;

    @FindBy(xpath = "//*[@class='ait']")
    private Link moreOptionsLink;

    @FindBy(css = ".gb_0")
    private Menu userOptionsDropDownMenu;

    @FindAll({@FindBy(xpath = "//div[@id=':2'] //td[@tabindex='-1'] //span[2]")})
    private WebElement allMessagesPerPage;

    public GmailAndroidPage() {
        PageFactory.initElements(new ElementDecorator(driver), this);
    }

//    todo finish page logic
}
