package org.framework.helper;

import org.framework.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {
    public static WebDriver driver;
    String strPagename;

    public WebDriver setupDriver(String strWebDriverType) {
        try {
            if (strWebDriverType.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else if (strWebDriverType.equals("chrome")) {
                driver = new ChromeDriver();
            } else if (strWebDriverType.equals("safari")) {
                driver = new SafariDriver();
            } else if (strWebDriverType.equals("opera")) {
                driver = new OperaDriver();
            }
        } catch (Exception exception) {
            System.out.println("Don't know which webdriver to start!!");
        }
        return driver;
    }

    public HomePage openWebPage(String strUrl) throws InterruptedException {
        driver.get(strUrl);
        return new HomePage(driver);
    }

    public String getPagename() {
        return strPagename;
    }

    public void setPagename() {
        strPagename = driver.getTitle();
    }
}
