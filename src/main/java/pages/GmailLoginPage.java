package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import elements.ElementDecorator;
import elements.Button;
import elements.TextField;
import pages.utils.DriverPool;

public class GmailLoginPage extends BasePage {

    public static volatile String LOGIN_URL = "https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=uk&service=mail";
    public static volatile String XPATH_EXPRESSION = "//*[@id=':4e']/div/div";

    @FindBy(id = "Email")
    private volatile TextField loginField;

    @FindBy(id = "Passwd")
    private volatile TextField passwordField;

    @FindBy(id = "signIn")
    private volatile Button loginBtn;

    public GmailLoginPage() {
//        PageFactory.initElements(new ElementDecorator(driver), this);
        PageFactory.initElements(new ElementDecorator(DriverPool.getInstance()), this);
    }

    public GmailPage loginAs(String userName, String userPass) {
        loginField.typeText(userName);
        passwordField.typeText(userPass);
        loginBtn.click();

        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("gmail");
            }
        });

        return new GmailPage();
    }

    public void setLogin(String userLogin) {
        loginField.clear();
        loginField.typeText(userLogin);
    }

    public void setPassword(String userPass) {
        passwordField.clear();
        passwordField.typeText(userPass);
    }

    public void clickLoginBtn() {
        loginBtn.click();
        (new WebDriverWait(driver, 30)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.findElement(By.xpath(XPATH_EXPRESSION)).isEnabled();
            }
        });
    }
}
