package zDemo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.drivers.DriverManager;

public class FacebookDemoTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getInstance();
        driver.get("https://www.facebook.com");
    }

    @Test
    public void testContainsAndStartsWith() throws Exception {
        System.out.println("CURRENT URL:" + driver.getCurrentUrl());

        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.facebook.com"));
        Assert.assertTrue(driver.getCurrentUrl().startsWith("https://www.facebook.com"));
    }

    @Test
    public void testEquals() throws Exception {
        System.out.println("CURRENT URL:" + driver.getCurrentUrl());

        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.facebook.com"));
        Assert.assertTrue(driver.getCurrentUrl().contentEquals("https://www.facebook.com"));
    }

    @AfterMethod
    public void tearDown() throws Exception {
        DriverManager.closeQuietly();
    }
}
