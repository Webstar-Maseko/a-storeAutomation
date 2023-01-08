package org.webstar.Pages.AdminPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.webstar.Factory.Interactions.CommonFunctions;

public class AdminLogin extends CommonFunctions {

    WebDriver driver;
    public AdminLogin(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    //======>
    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name="password")
    private WebElement password;

    @FindBy(css = ".btn")
    private WebElement loginBtn;

    @FindBy(css = "p.text-danger")
    private WebElement invalidCredError;

    @FindBy(xpath = "//span[.='please enter your registered email']")
    private WebElement requiredEmail;

    @FindBy(xpath = "//span[.='invalid password']" )
    private WebElement requiredPassword;

    //========> Functions

    public void fillCreds(String email,String pswd){
        fill(username,"email",email);
        fill(password,"password",pswd);
    }

    public Boolean verifyCreds(){
        return waitForElement(invalidCredError);
    }

    public Boolean verifyRequiredEmail(){
        return waitForElement(requiredEmail);
    }

    public Boolean verifyRequiredPswd(){
        return waitForElement(requiredPassword);
    }
    public void clickLoginBtn(){
        click(loginBtn,"Login");
    }

    public Dashboard doLogin(){
        clickLoginBtn();
        return new Dashboard(driver);
    }


}
