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

/**
 * @author Nazar Lelyak.
 * @version 1.00 2014-05-20.
*/
public class GmailLoginPage {

    private final WebDriver driver;

    public static final String LOGIN_URL = "https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=uk&service=mail";

    @FindBy(id = "Email")
    private TextField loginField;

    @FindBy(id = "Passwd")
    private TextField passwordField;

    @FindBy(id = "signIn")
    private Button loginBtn;

    public GmailLoginPage(WebDriver driver) {
        this.driver = driver;

        // Check that we're on the right page.
        if (!"gmail".equals(driver.getTitle().toLowerCase())) {
            throw new IllegalStateException("This is not the login page");
        }
        PageFactory.initElements(new ElementDecorator(driver), this);
    }

    public GmailPage loginAs(String username, String userpassword) {
        loginField.sendKeys(username);
        passwordField.sendKeys(userpassword);
        loginBtn.click();

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("gmail");
            }
        });

        return new GmailPage(driver);
    }

    public void setLogin(String userLogin) {
        loginField.sendKeys(userLogin);
    }

    public void setPassword(String userPass) {
        passwordField.sendKeys(userPass);
    }

    public void clickLoginBtn() {
        loginBtn.click();
//        todo check working without waiting ??
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.findElement(By.xpath("//*[@id=':4e']/div/div")).isEnabled();
            }
        });
    }
}
