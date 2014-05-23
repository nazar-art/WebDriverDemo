package sandbox;

import framework.seleniumEngine.BrowserType;
import framework.seleniumEngine.PageManager;
import framework.seleniumEngine.SeleniumManager;
import framework.seleniumEngine.UIRepository;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author nlelyak.
 * @version 1.00 2014-05-23.
 */
public class LoginTest {
    @BeforeClass
    public void setUp() {
        // code that will be invoked when this test is instantiated
        System.out.println("BeforeClass setUp invoked");
    }

    @Test
    public void LoginTestByRepository() {
/*
        SeleniumManager.start(BrowserType.Firefox);
        PageManager pageManager = new PageManager();

        pageManager.navigateTo(UIRepository.Pages.LoginPage.self);

        //LoginPage loginPage = (LoginPage) UIControlBuilder.buildPage(UIRepository.Pages.PageLogin.self);
        //UIRepository.Pages.PageLogin.

        UI_InputButton btnLogin = (UI_InputButton) UIControlBuilder.buildControl(UIRepository.Pages.PageLogin.BtnLogin);
        btnLogin.Click();

        UI_InputButton btnSubmitSelected = (UI_InputButton) UIControlBuilder.buildControl(UIRepository.Pages.PageIndex.BtnSubmitSelected);
        btnSubmitSelected.IsNotEnabled();
*/
    }
}
