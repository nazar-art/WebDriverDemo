package zDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.drivers.DriverManager;

import static org.testng.Assert.assertEquals;

public class GitHubTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getInstance();
        driver.get("https://github.com/codesolid");
    }

    @Test
    public void testFirst() throws Exception {
        driver.findElement(By.linkText("tutorials")).click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("span.col-11"))));

        assertEquals(driver.findElement(By.xpath("//title")).getText(), "GitHub - CodeSolid/tutorials: Tutorials");
        assertEquals(driver.getCurrentUrl(), "https://github.com/CodeSolid/tutorials");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        DriverManager.closeQuietly();
    }
}
