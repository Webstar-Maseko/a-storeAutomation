package org.webstar.Pages.AdminPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.webstar.Factory.Interactions.CommonFunctions;

public class Dashboard extends CommonFunctions {
    WebDriver driver;
    public Dashboard(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//div[.='Dashboard']")
    private WebElement dashboardHeader;

    public Boolean verifyDashboard(){
        return waitForElement(dashboardHeader);
    }
}
