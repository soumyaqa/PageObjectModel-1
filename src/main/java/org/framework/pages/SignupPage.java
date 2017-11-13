package org.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import static java.util.concurrent.TimeUnit.SECONDS;

public class SignupPage {
    private static WebDriver driver;

    public SignupPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        Wait wait = new FluentWait(driver).withTimeout(60, SECONDS)
                                          .pollingEvery(5, SECONDS);
    }

    public WebElement usernameField() throws InterruptedException {
        return driver.findElement(By.id("display-name"));
    }

    public WebElement emailField() throws InterruptedException {
        return driver.findElement(By.id("email"));
    }

    public WebElement passwordField() throws InterruptedException {
        return driver.findElement(By.id("password"));
    }

    public WebElement signUpButton() throws InterruptedException {
        return driver.findElement(By.id("submit-button"));
    }

    public WebElement labelConfirmEmailSent() throws InterruptedException {
        return driver.findElement(By.xpath("//div[@class='val-message val-success']"));
    }

    public SignupPage enterUsername(String strUsername) throws InterruptedException {
        usernameField().sendKeys(strUsername);
        return this;
    }

    public SignupPage enterEmail(String strEmail) throws InterruptedException {
        emailField().sendKeys(strEmail);
        return this;
    }

    public SignupPage enterPassword(String strPassword) throws InterruptedException {
        passwordField().sendKeys(strPassword);
        return this;
    }

    public SignupPage clickSignup() throws InterruptedException {
        signUpButton().click();
        return this;
    }

    public boolean isSuccessEmailSent() throws InterruptedException {
        return labelConfirmEmailSent().isDisplayed();
    }
}
