package org.test.signup;

import org.framework.helper.DriverManager;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.testng.annotations.*;

public class SignupTest {
    public static WebDriver driver;
    public String strUrl = "http://www.stackoverflow.com";

    @BeforeTest
    public void setup(){
        driver = new DriverManager().setupDriver("firefox");
        driver.manage().window().maximize();
    }

    @Test
    public void testValidSignup() throws InterruptedException {
        Boolean boolValidSignup = new DriverManager().openWebPage(strUrl).clickSignupLink()
                                                     .enterUsername("kj").enterEmail("tomjerry@tj.com").enterPassword("Kjkj12345$").clickSignup()
                                                     .isSuccessEmailSent();
        Assert.assertTrue(boolValidSignup);
    }

    @Test
    public void testInvalidSignup() throws InterruptedException {
        Boolean boolInvalidSignup = new DriverManager().openWebPage(strUrl).clickSignupLink()
                                                       .enterUsername("kj").enterEmail("tomjerry@tj.com").enterPassword("Kjkj12345$").clickSignup()
                                                       .isSuccessEmailSent();
        Assert.assertFalse(boolInvalidSignup);
    }

    @Ignore
    public void close(){
        driver.quit();
    }
}
