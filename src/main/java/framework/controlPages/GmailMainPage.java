package framework.controlPages;

import framework.UIElements.*;

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

//    todo finish implementation

    public UIButton getBtnCompose() {
        return btnCompose;
    }

    public UIFrame getFrameForNewMessage() {
        return frameForNewMessage;
    }

    public UILink getLinkDraftMessages() {
        return linkDraftMessages;
    }

    public UIMenu getMenuUserProfile() {
        return menuUserProfile;
    }

    public UIButton getBtnSighOut() {
        return btnSighOut;
    }
}
