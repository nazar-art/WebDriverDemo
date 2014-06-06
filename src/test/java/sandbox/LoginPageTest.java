package sandbox;

import framework.UIElements.UIButton;
import framework.UIElements.UIControlBuilder;
import framework.UIElements.UIInputText;
import framework.UIElements.UIMenu;
import framework.pages.GmailMainPage;
import framework.seleniumEngine.PageManager;
import framework.seleniumEngine.SeleniumManager;
import framework.seleniumEngine.UIRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.utils.BrowserType;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

public class LoginPageTest {

    private PageManager pageManager = null;

    public static String USER_LOGIN = "testt3820@gmail.com";
    public static String USER_PASSWORD = "CreateAPassword";

    @BeforeTest
    public void setUp() {
        System.out.println("BeforeClass setUp() invoked" );
        SeleniumManager.start(BrowserType.Firefox);

        pageManager = new PageManager();
        pageManager.navigateTo(UIRepository.Pages.GmailLoginPage.self);
//        todo login here
        UIInputText emailField = (UIInputText) UIControlBuilder.buildControl(UIRepository.Pages.GmailLoginPage.emailField);
        emailField.typeText(USER_LOGIN);

        UIInputText passField = (UIInputText) UIControlBuilder.buildControl(UIRepository.Pages.GmailLoginPage.passwordField);
        passField.typeText(USER_PASSWORD);

        UIButton btnLogin = (UIButton) UIControlBuilder.buildControl(UIRepository.Pages.GmailLoginPage.btnLogin);
        btnLogin.click();
        new WebDriverWait(SeleniumManager.activeBrowser(), 30).until(titleContains("Gmail"));
    }

    @AfterTest
    public void tearDown() {
        System.out.println("AfterTest tearDown() invoked");
        UIMenu userProfile = (UIMenu) UIControlBuilder.buildControl(UIRepository.Pages.GmailMainPage.menuUserProfile);
        userProfile.click();
        // waiting for element presence
        new WebDriverWait(SeleniumManager.activeBrowser(), 30).until(presenceOfElementLocated(By.cssSelector("#gb_71")));
        UIButton signOutBtn = (UIButton) UIControlBuilder.buildControl(UIRepository.Pages.GmailMainPage.btnSignOut);
        signOutBtn.click();
        //
        SeleniumManager.closeQuietly();
        pageManager = null;
    }

//    @Test
    public void loginTestByRepository() {
        new WebDriverWait(SeleniumManager.activeBrowser(), 30).until(titleContains("Gmail"));

    }

    @Test
    public void testByPageObject() {
        GmailMainPage mainPage = (GmailMainPage) pageManager.navigateTo(UIRepository.Pages.GmailMainPage.self);
        mainPage.getBtnCompose().click();
        new WebDriverWait(SeleniumManager.activeBrowser(), 30).until(presenceOfElementLocated(By.xpath("//div[@class = 'Am Al editable']/iframe")));
    }

}
