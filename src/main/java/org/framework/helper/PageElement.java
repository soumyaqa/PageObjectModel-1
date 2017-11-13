package org.framework.helper;

import org.framework.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

public class PageElement {
    public static WebElement element;

    public boolean isVisible(WebElement element) {
        return element.isDisplayed();
    }

    public boolean isSelected() {
        return element.isSelected();
    }

    public boolean isEnabled() {
        return element.isEnabled();
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void setText(WebElement element, String strValue) {
        element.sendKeys(strValue);
    }

    public void clearElement(WebElement element) {
        element.clear();
    }

    public void selectDropdownValue(String strValue) {
        element.sendKeys(strValue);
    }
}