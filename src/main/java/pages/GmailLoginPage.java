package pages;

import elements.Button;
import elements.ElementDecorator;
import elements.TextField;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailLoginPage extends BasePage {

    public static String LOGIN_URL = "https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=uk&service=mail";
    public static String XPATH_EXPRESSION = "//*[@id=':4e']/div/div";

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
        loginField.typeText(userName);
        passwordField.typeText(userPass);
        loginBtn.click();

//        waitPresence("/html/head/title[contains(text(), 'Gmail')]");
        fluentWait(By.xpath("/html/head/title[contains(text(), 'Gmail')]"));
        return new GmailPage();
    }

    public void setLogin(String userLogin) {
        loginField.typeText(userLogin);
    }

    public void setPassword(String userPass) {
        passwordField.typeText(userPass);
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }
}
