package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import task2.ElementDecorator;
import task2.elements.Button;
import task2.elements.TextField;

public class GmailLoginPage extends BasePage {

    public static final String LOGIN_URL = "https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=uk&service=mail";
    public static final String XPATH_EXPRESSION = "//*[@id=':4e']/div/div";

    @FindBy(id = "Email")
    private TextField loginField;

    @FindBy(id = "Passwd")
    private TextField passwordField;

    @FindBy(id = "signIn")
    private Button loginBtn;

    public GmailLoginPage() {
        PageFactory.initElements(new ElementDecorator(driver), this);
    }

    public GmailPage loginAs(String userName, String userPass) {
        loginField.sendKeys(userName);
        passwordField.sendKeys(userPass);
        loginBtn.click();

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("gmail");
            }
        });

        return new GmailPage();
    }

    public void setLogin(String userLogin) {
        loginField.clear();
        loginField.sendKeys(userLogin);
    }

    public void setPassword(String userPass) {
        passwordField.clear();
        passwordField.sendKeys(userPass);
    }

    public void clickLoginBtn() {
        loginBtn.click();
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.findElement(By.xpath(XPATH_EXPRESSION)).isEnabled();
            }
        });
    }
}
