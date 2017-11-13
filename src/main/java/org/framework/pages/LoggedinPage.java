package org.framework.pages;

import org.framework.helper.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import static java.util.concurrent.TimeUnit.SECONDS;

public class LoggedinPage extends PageElement{
    private static WebDriver driver;

    public LoggedinPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        Wait wait = new FluentWait(driver).withTimeout(60, SECONDS)
                                          .pollingEvery(5, SECONDS);
    }

    public WebElement labelUserAccount() {
        return driver.findElement(By.xpath("//div[@class='gravatar-wrapper-24']//img[@class='-avatar js-avatar-me']"));
    }

    public boolean isUserAccountDisplayed() throws InterruptedException {
        return isVisible(labelUserAccount());
    }
}
