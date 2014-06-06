package pages.appium;

import elements.Button;
import elements.ElementDecorator;
import elements.TextField;
import framework.seleniumEngine.SeleniumManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.utils.BrowserType;

public class LoginAndroidPage {

    private WebDriver driver = SeleniumManager.start(BrowserType.Android_Chrome);

    @FindBy(id = "Email")
    private TextField loginField;

    @FindBy(id = "Passwd")
    private TextField passwordField;

    @FindBy(id = "signIn")
    private Button loginBtn;

    public LoginAndroidPage() {
        PageFactory.initElements(new ElementDecorator(driver), this);
    }

    public GmailAndroidPage loginAs(String userName, String userPass) {
//        driver.get(LOGIN_URL);
        loginField.typeText(userName);
        passwordField.typeText(userPass);
        loginBtn.click();

        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().contains("gmail");
            }
        });

        return new GmailAndroidPage();
    }

}
