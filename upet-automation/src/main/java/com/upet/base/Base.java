package com.upet.base;

import com.upet.utils.CommonUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class Base {
    public static final String AUTOMATE_USERNAME = "taeupwork_qSwAs8";
    public static final String AUTOMATE_ACCESS_KEY = "JQCA46mFEp1A6bjRJxQz";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public static RemoteWebDriver driver;

    public static void gearUp(Scenario sc) {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("os_version", "Big Sur");
            caps.setCapability("resolution", "1920x1080");
            caps.setCapability("browser", "Chrome");
            caps.setCapability("browser_version", "latest");
            caps.setCapability("os", "OS X");
            caps.setCapability("name", CommonUtils.generateRandomString(10)); // test name
            caps.setCapability("build", sc.getName()); // CI/CD job or build name
            driver = new RemoteWebDriver(new URL(URL), caps);
            driver.get("https://test.app.upet.co/public/sign-up");

            //Setting the status of test as 'passed' or 'failed' based on the condition; if title of the web page contains 'BrowserStack'
            WebDriverWait wait = new WebDriverWait(driver, 5);
            try {
                wait.until(ExpectedConditions.titleContains("Create account"));
                markTestStatus("passed", "Yaay title contains 'Create account'!", driver);
            } catch (Exception e) {
                markTestStatus("failed", "Naay title does not contain 'Create account'!", driver);
            }
            System.out.println(driver.getTitle());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    // This method accepts the status, reason and WebDriver instance and marks the test on BrowserStack
    public static void markTestStatus(String status, String reason, WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+status+"\", \"reason\": \""+reason+"\"}}");
    }

    public static void goodbye(){
        driver.quit();
    }
}
