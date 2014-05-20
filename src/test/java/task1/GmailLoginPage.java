package task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Nazar Lelyak.
 * @version 1.00 2014-05-20.
 */
public class GmailLoginPage {
    private final WebDriver driver;
    public static final String LOGIN_URL = "https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=uk&service=mail";

    public GmailLoginPage(WebDriver driver) {
        this.driver = driver;

        // Check that we're on the right page.
        if (!"Gmail".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the login page");
        }
    }
    public GmailPage loginAs(String username, String userpassword) {
        driver.findElement(By.id("Email")).sendKeys(username);
        driver.findElement(By.id("Passwd")).sendKeys(userpassword);
        driver.findElement(By.id("signIn")).submit();

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("gmail");
            }
        });
        // Return a new page object representing the destination.
        return new GmailPage(driver);
    }
}
