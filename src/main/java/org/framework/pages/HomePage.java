package org.framework.pages;

import org.framework.helper.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import static java.util.concurrent.TimeUnit.SECONDS;

public class HomePage extends PageElement{
    private static WebDriver driver;

    public HomePage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        Wait wait = new FluentWait(driver).withTimeout(60, SECONDS)
                                          .pollingEvery(5, SECONDS);
    }

    public WebElement loginLink() {
        return driver.findElement(By.linkText("Log In"));
    }

    public WebElement signupLink() {
        return driver.findElement(By.linkText("Sign Up"));
    }

    public LoginPage clickLoginLink() throws InterruptedException {
        clickElement(loginLink());
        return new LoginPage(driver);
    }

    public SignupPage clickSignupLink() throws InterruptedException {
        clickElement(signupLink());
        return new SignupPage(driver);
    }
}
