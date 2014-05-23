package framework.seleniumEngine;

import framework.UIElements.*;
import framework.controlPages.GmailLoginPage;

/**
 * @author nlelyak.
 * @version 1.00 2014-05-23.
 */
public class UIRepository {

   public static class Pages {

        public static class GmailLoginPage {
            public static UIMapping self = new UIMapping(SearchLevelType.Page, SearchType.ByUrl, "https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=uk&service=mail", framework.controlPages.GmailLoginPage.class);

            public static UIMapping emailField = new UIMapping(SearchLevelType.Page, SearchType.ByXpath, "//input[@id='Email']", UIInputText.class);

public static UIMapping passwordField = new UIMapping(SearchLevelType.Page, SearchType.ByXpath, "//input[@id='Passwd']", UIInputText.class);

            public static UIMapping btnSignIn = new UIMapping(SearchLevelType.Page, SearchType.ByXpath, "//input[@id='signIn']", UIButton.class);

            public static UIMapping loginPanel = new UIMapping(SearchLevelType.Page, SearchType.ByCss, ".card.signin-card.clearfix", UIForm.class);
        }
   }

    public static class GmailMainPage {
//            todo add all needed elements
            public static UIMapping self = new UIMapping(SearchLevelType.Page, SearchType.ByUrl, "/mail/u/0/#inbox", GmailLoginPage.class);

        public static UIMapping btnCompose = new UIMapping(SearchLevelType.Page, SearchType.ByXpath, "//div[@class='T-I J-J5-Ji T-I-KE L3']", UIButton.class);

        public static UIMapping frameForNewMessage = new UIMapping(SearchLevelType.Page, SearchType.ByXpath, "//div[@class = 'Am Al editable']/iframe", UIFrame.class);

        public static UIMapping btnSaveAndClose = new UIMapping(SearchLevelType.Page, SearchType.ByXpath, "//img[@aria-label='Save & Close']", UIFrame.class);

        public static UIMapping linkDraftMessages = new UIMapping(SearchLevelType.Page, SearchType.ByXpath, "//a[starts-with(@title, 'Drafts')]", UILink.class);

        public static UIMapping menuUserProfile = new UIMapping(SearchLevelType.Page, SearchType.ByCss, ".gb_0", UIMenu.class);

        public static UIMapping btnSignOut = new UIMapping(SearchLevelType.Page, SearchType.ByCss, "#gb_71", UIButton.class);

    }
}
