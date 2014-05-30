package sandbox;

import framework.UIElements.UIButton;
import framework.UIElements.UIControlBuilder;
import framework.seleniumEngine.PageManager;
import framework.seleniumEngine.SeleniumManager;
import framework.seleniumEngine.UIRepository;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.utils.BrowserType;

public class LoginPageTest {
    PageManager pageManager;

    @BeforeTest
    public void setUp() {
        System.out.println("BeforeClass setUp invoked" );
        SeleniumManager.start(BrowserType.Firefox);
        pageManager = new PageManager();
    }

    @AfterTest
    public void tearDown() {

        SeleniumManager.stop();
    }

    @Test
    public void loginTestByRepository() {
        pageManager.navigateTo(UIRepository.Pages.GmailLoginPage.self);
        UIButton btnLogin = (UIButton) UIControlBuilder.buildControl(UIRepository.Pages.GmailLoginPage.btnSignIn);
        btnLogin.click();

//        UIButton btnSubmitSelected = (UIButton) UIControlBuilder.buildControl(UIRepository.Pages.PageIndex.BtnSubmitSelected);
//        btnSubmitSelected.isNotEnabled();
    }

}
