package org.webstar.Factory.BrowserConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserSetup {

    public static ThreadLocal<WebDriver> driver;

    //Set up a constructor to instintiate to thread local
    public BrowserSetup(){
        driver = new ThreadLocal<>();
    }

    //Setup the respective driver based on the browser name
    public void setupBrowser(String browser){

        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

            driver.set(new ChromeDriver(options));
        } else if (browser.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            driver.set(new EdgeDriver(options));

        } else if (browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            driver.set(new FirefoxDriver(options));
        }
    }

    public WebDriver getDriver(){
        return driver.get();
    }
}
