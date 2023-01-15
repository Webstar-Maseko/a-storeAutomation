package org.webstar.Pages.AdminPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.webstar.Factory.Interactions.CommonFunctions;

public class AdminRegister extends CommonFunctions {
    WebDriver driver;

    public AdminRegister(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    //================> inspections
    @FindBy(xpath = "//a[.='Register']")
    private WebElement registerLink;

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "firstName")
    private WebElement firstName;

    @FindBy(name = "lastName")
    private WebElement lastName;

    @FindBy(name = "phone")
    private WebElement phoneNumber;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "confirmPwd")
    private WebElement confirmPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement registerBtn;

    @FindBy(xpath = "//h5[normalize-space()='Admin Register']")
    private WebElement registrationHeader;

    //=========Interactions
    public void register(String email,String name,String surname,String phone,String pwd,String confirmPwd){
        fill(username,"email",email);
        fill(firstName,"Firstname", name);
        fill(lastName,"LastName",surname);
        fill(phoneNumber,"Phone",phone);
        fill(password,"password",pwd);
        fill(confirmPassword,"Confirm password",confirmPwd);
    }

    public void clickRegisterLink(){
        click(registerLink,"Register");
        waitForElement(registrationHeader);
    }

    public void clickRegisterBtn(){
        click(registerBtn,"Register");
    }

    public Dashboard doRegister(){
        clickRegisterBtn();
        return  new Dashboard(driver);
    }


}
