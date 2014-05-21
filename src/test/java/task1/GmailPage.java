package task1;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @author Nazar Lelyak.
 * @version 1.00 2014-05-20.
 */
public class GmailPage {
    private static Logger log = Logger.getLogger(GmailPage.class);
    private WebDriver driver;

    public static final String XPATH_ALL_LETTERS_FROM_PAGE = "//div[@id=':2'] //td[@tabindex='-1'] //span[2]";

    public static final String LOGIN_URL = "https://www.gmail.com/";

    public GmailPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickProfileImage() {
        driver.findElement(By.cssSelector(".gb_X")).click();
    }

    public void clickSignOut() {
        try {
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("#gb_71")).click();
        } catch (InterruptedException e) {
            log.error(e);
        }
    }

    public void pressComposeButton() {
        driver.findElement(By.xpath("//*[@id=':4e']/div/div")).click();
    }

    public void sendTextToMessageFrame(String msg) {
        try {
            Thread.sleep(1000);
            driver.switchTo().frame(driver.findElement(By.xpath("//div[@class = 'Am Al editable']/iframe")));
            WebElement element = driver.switchTo().activeElement();
            element.sendKeys(msg);
            driver.switchTo().defaultContent();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@aria-label='Save & Close']")).click();
        } catch (InterruptedException e) {
            log.error(e);
        }
    }

    public void clickAllMailLink() {
        try {
            Thread.sleep(1000);
            driver.findElement(By.cssSelector(".ait")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@title='All Mail']")).click();
        } catch (InterruptedException e) {
            log.error(e);
        }
    }

    public void clickInboxLink() {
        driver.findElement(By.xpath("//*[@href='https://mail.google.com/mail/#inbox']")).click();
    }

    public void clickDraftLink() {
        driver.findElement(By.xpath("//*[@href='https://mail.google.com/mail/#drafts']")).click();
    }

    public List<WebElement> takeAllMessage() {
        return driver.findElements(By.xpath(XPATH_ALL_LETTERS_FROM_PAGE));
    }

    public List<WebElement> takeInboxMessage() {
        return driver.findElements(By.xpath(XPATH_ALL_LETTERS_FROM_PAGE));
    }

    public List<WebElement> takeDraftMessage() {
        return driver.findElements(By.xpath(XPATH_ALL_LETTERS_FROM_PAGE));
    }
}
