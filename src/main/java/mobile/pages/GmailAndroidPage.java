package mobile.pages;

import elements.Button;
import elements.ElementDecorator;
import elements.Link;
import elements.Menu;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GmailAndroidPage extends AndroidBasePage {

    @FindBy(xpath = "")
    private Button composeBtn;

    @FindBy(xpath = "")
    private Link signOutLink;

    @FindBy(xpath = "")
    private WebElement frameMessageEditor;

    @FindBy(xpath = "")
    private Button saveAndCloseBtn;

    @FindBy(xpath = "")
    private Link draftMessagesLink;

    @FindBy(xpath = "")
    private Link moreOptionsLink;

    @FindBy(xpath = "")
    private Menu userOptionsDropDownMenu;

    @FindAll({@FindBy(xpath = "")})
    private WebElement allMessagesPerPage;

    public GmailAndroidPage() {
        PageFactory.initElements(new ElementDecorator(driver), this);
    }


    public void clickComposeBtn() {
        composeBtn.click();
    }

    public void clickDraftLink() {
        draftMessagesLink.click();
    }

    public void typeTextToMsg(String msg) {
        // todo
    }

    @SuppressWarnings("uncheckeed")
    public List<WebElement> takeAllMsgFromPage() {
        return (List<WebElement>) allMessagesPerPage;
    }

    public void clickSaveAndCloseBtn() {
        saveAndCloseBtn.click();
    }
}
