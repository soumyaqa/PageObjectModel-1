package org.framework.pages;

import org.framework.helper.DriverManager;
import org.framework.helper.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.util.concurrent.TimeUnit.SECONDS;

public class LoginPage extends PageElement{
    private static WebDriver driver;

    public LoginPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        Wait wait = new FluentWait(driver).withTimeout(60, SECONDS)
                                          .pollingEvery(5, SECONDS);
    }

    public WebElement emailField() {
        return driver.findElement(By.id("email"));
    }

    public WebElement passwordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement loginButton() {
        return driver.findElement(By.id("submit-button"));
    }

    public LoginPage enterEmail(String strEmail) {
        setText(emailField(), strEmail);
        return this;
    }

    public LoginPage enterPassword(String strPassword){
        setText(passwordField(), strPassword);
        return this;
    }

    public LoggedinPage clickLogin() throws InterruptedException {
        clickElement(loginButton());
        return new LoggedinPage(driver);
    }
}
