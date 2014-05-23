package framework.controlPages;

import framework.UIElements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author nlelyak.
 * @version 1.00 2014-05-23.
 */
public class GmailMainPage extends BaseUIPage {

    private UIButton btnCompose;
    private UIFrame frameForNewMessage;
    private UILink linkDraftMessages;
    private UIMenu menuUserProfile;
    private UIButton btnSighOut;

    public UIButton getBtnCompose() {
        btnCompose = new UIButton();
        WebElement element = pageWrapper.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']"));
        btnCompose.assign(element);
        return btnCompose;
    }

    public UIFrame getFrameForNewMessage() {
        frameForNewMessage = new UIFrame();
        WebElement element = pageWrapper.findElement(By.xpath("//div[@class = 'Am Al editable']/iframe"));
        frameForNewMessage.assign(element);
        return frameForNewMessage;
    }

    public UILink getLinkDraftMessages() {
        linkDraftMessages = new UILink();
        WebElement element = pageWrapper.findElement(By.xpath("//a[starts-with(@title, 'Drafts')]"));
        linkDraftMessages.assign(element);
        return linkDraftMessages;
    }

    public UIMenu getMenuUserProfile() {
        menuUserProfile = new UIMenu();
        WebElement element = pageWrapper.findElement(By.cssSelector(".gb_0"));
        menuUserProfile.assign(element);
        return menuUserProfile;
    }

    public UIButton getBtnSighOut() {
        btnSighOut = new UIButton();
        WebElement element = pageWrapper.findElement(By.cssSelector("#gb_71"));
        btnSighOut.assign(element);
        return btnSighOut;
    }
}
