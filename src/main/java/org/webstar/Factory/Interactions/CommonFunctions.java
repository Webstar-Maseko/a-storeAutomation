package org.webstar.Factory.Interactions;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.webstar.ExtentReport.ExtentTestManager.getTest;

public class CommonFunctions {
    WebDriver driver;
    WebDriverWait wait;

    JavascriptExecutor js;

    public CommonFunctions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        js = (JavascriptExecutor) driver;
    }

    protected void click(WebElement element, String name) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));

            js.executeScript("arguments[0].click()", element);
            getTest().log(Status.PASS, name + " was clicked");
            System.out.println(name + " was clicked");
        } catch (Exception ex) {
            ex.printStackTrace();
            getTest().log(Status.PASS, name + " couldn't be clicked");
            System.out.println(name + " couldn't be clicked");
        }
    }

    protected void fill(WebElement element, String name, String text) {
        if (waitForElement(element)) {
            element.clear();
            element.sendKeys(text);
            getTest().log(Status.PASS, text + " was successfully sent to " + name + " input box");
            System.out.println(text + " was successfully sent to " + name + " input box");
        } else {
            getTest().log(Status.PASS, text + " couldn't be sent to " + name + " input box because it cannot be found ");
            System.out.println(text + " couldn't be sent to " + name + " input box because it cannot be found ");
        }
    }

    protected Boolean waitForElement(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;


        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    protected Boolean waitForInvisibilityOfElement(WebElement element) {
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
            return true;


        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    protected Boolean waitForElements(List<WebElement> elements) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
            return true;


        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    protected void goToElement(WebElement element) {
        try {

            js.executeScript("arguments[0].scrollIntoView(true)", element);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
