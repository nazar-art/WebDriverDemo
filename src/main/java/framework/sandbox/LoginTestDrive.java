package framework.sandbox;

import framework.UIElements.UIButton;
import framework.UIElements.UIControlBuilder;
import framework.seleniumEngine.PageManager;
import framework.seleniumEngine.SeleniumManager;
import framework.seleniumEngine.UIRepository;
import org.apache.log4j.Logger;
import pages.utils.BrowserType;

public class LoginTestDrive {

    private static Logger log = Logger.getLogger(LoginTestDrive.class);

//    @BeforeClass
    public void setUp() {
//        System.out.println("BeforeClass setUp invoked");
        log.info("BeforeClass setUp invoked");
        SeleniumManager.start(BrowserType.Firefox);
        PageManager pageManager = new PageManager();

        pageManager.navigateTo(UIRepository.Pages.GmailLoginPage.self);
    }

//    @Test
    public void LoginTestByRepository() {
        UIButton btnLogin = (UIButton) UIControlBuilder.buildControl(UIRepository.Pages.GmailLoginPage.btnSignIn);
        btnLogin.click();

        /*UIButton btnCompose = (UIButton) UIControlBuilder.buildControl(UIRepository.GmailMainPage.btnCompose);
        btnCompose.click();
        UIFrame frame = (UIFrame) UIControlBuilder.buildControl(UIRepository.)
        UIButton btnSaveAndClose = (UIButton) UIControlBuilder.buildControl(UIRepository.GmailMainPage.btnSaveAndClose);
        btnSaveAndClose.click();*/
//        todo finish test logic
    }
}
