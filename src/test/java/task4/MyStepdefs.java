package task4;

import business.GmailHeaderPanelBO;
import business.GmailLeftPanelBO;
import business.GmailMainContentBO;
import business.LoginBO;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.utils.WebDriverManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static pages.utils.TestUtils.interrupt;

public class MyStepdefs {

    public WebDriver driver = WebDriverManager.getInstance();

    private GmailHeaderPanelBO headerPanelBO;
    private LoginBO loginBO;
    private GmailMainContentBO mainContentBO;
    private GmailLeftPanelBO leftPanelBO;

    @Before
    public void setUp() {
        driver.manage().window().maximize();
        mainContentBO = new GmailMainContentBO();
    }

    @After
    public void tearDown() {
        headerPanelBO = new GmailHeaderPanelBO();

        new WebDriverWait(driver, 30).until(presenceOfElementLocated(By.cssSelector(".gb_0")));
        headerPanelBO.clickProfileOptionMenu();
        new WebDriverWait(driver, 30).until(presenceOfElementLocated(By.cssSelector("#gb_71")));
        headerPanelBO.clickSignOutBtn();

        WebDriverManager.closeQuietly();
    }

    @Given("^Login to gmail page \"([^\"]*)\" with credentials login - \"([^\"]*)\" and password - \"([^\"]*)\"$")
    public void Login_to_gmail_page_with_credentials_login_and_password_(String url, String login, String pass) {
        loginBO = new LoginBO();
        driver.get(url);
        loginBO.login(login, pass);
    }

    @When("^press compose button$")
    public void press_compose_button() {
        new WebDriverWait(driver, 30).until(presenceOfElementLocated(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']")));
        mainContentBO.clickComposeBtn();
    }

    @And("^fill email message \"([^\"]*)\"$")
    public void fill_email_message(String msg) {
        new WebDriverWait(driver, 30).until(presenceOfElementLocated(By.xpath("//div[@class = 'Am Al editable']/iframe")));
        mainContentBO.writeNewMessage(msg);
        interrupt(TimeUnit.SECONDS, 1);
    }

    @And("^click 'Save & Close'$")
    public void click_Save_Close() {
        mainContentBO.clickSaveAndCloseBtn();
    }

    @And("^click 'Draft' link$")
    public void click_Draft_link() {
        leftPanelBO = new GmailLeftPanelBO();
        leftPanelBO.clickDraftLink();
    }

    @Then("^Draft folder should contains letter with \"([^\"]*)\"$")
    public void Draft_folder_should_contains_letter_with(String msg) {
        List<WebElement> allMessages = mainContentBO.takeAllLettersFromPage();
        assertTrue("any letter doesn't contain test message",
                letterContainsTextMessage(allMessages, msg));
    }

    /**
     * Check if list of letters from page contains text message.
     *
     * @param webElementList list of web elements.
     * @param message        test message.
     * @return if letter contain message true, otherwise false.
     */
    public boolean letterContainsTextMessage(List<WebElement> webElementList, String message) {
        for (WebElement element : webElementList) {
            String fullLetterText = element.getText().trim();
//            System.out.printf("full: %s%n", fullLetterText);
            if (fullLetterText.startsWith("-")) {
                String letterText = fullLetterText.substring(2);
//                System.out.printf("short: %s%n", letterText);
                if (letterText.equals(message)) {
                    return true;
                }
            }
        }
        return false;
    }
}
