package org.webstar.Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.webstar.Factory.BrowserConfig.BrowserSetup;
import org.webstar.Pages.AdminPages.AdminLogin;
import org.webstar.Pages.AdminPages.AdminRegister;
import org.webstar.Pages.AdminPages.Dashboard;
import org.webstar.Utilities.ReadProperties;

import java.util.Properties;

public class BaseTest {

    BrowserSetup setup;
    protected WebDriver driver;
    protected String url;

    protected Properties prop;
    protected AdminLogin adminLogin;
    protected Dashboard dashboard;
    protected AdminRegister adminRegister;


    @Parameters({"url","browser"})
    @BeforeTest
    protected void setupTest(String url,@Optional String browser) {
        try {
            prop = new ReadProperties().init_Prop();
            this.url = url;

            if(browser !=null)
                prop.setProperty("browser",browser);

            setup = new BrowserSetup();
            setup.setupBrowser(prop.getProperty("browser"));
            driver = setup.getDriver();
            driver.get(url);
            driver.manage().window().maximize();


            //Page objects
            adminLogin  = new AdminLogin(driver);
            adminRegister = new AdminRegister(driver);



            //


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }



    @AfterTest
    protected void tearDown() {
        try{
            driver.quit();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public WebDriver getDriver(){
        return driver;
    }
}
