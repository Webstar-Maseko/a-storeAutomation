package org.webstar.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.webstar.Base.BaseTest;

public class AdminLoginTest extends BaseTest {


    @Test(priority = 1, description = "Try to login without specifying email")
    public void login_without_email() {
        try {

            adminLogin.fillCreds("",prop.getProperty("password"));
            adminLogin.clickLoginBtn();
            Assert.assertTrue(adminLogin.verifyRequiredEmail());

        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail(ex.getMessage());
        }
    }

    @Test(priority = 2, description = "Try to login without specifying password")
    public void login_without_password() {
        try {
            driver.get(url);
            adminLogin.fillCreds(prop.getProperty("email"),"" );
            adminLogin.clickLoginBtn();
            Assert.assertTrue(adminLogin.verifyRequiredPswd());

        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail(ex.getMessage());
        }
    }

    @Test(priority = 3, description = "Try to login with invalid credentials")
    public void login_invalid_credentials() {
        try {
            driver.get(url);
            adminLogin.fillCreds(prop.getProperty("email"),"password321!" );
            adminLogin.clickLoginBtn();
            Assert.assertTrue(adminLogin.verifyCreds());
        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail(ex.getMessage());
        }
    }

    @Test(priority = 4, description = "Login on the application with valid credentials")
    public void login_valid_credentials() {
        try {
            driver.get(url);
            adminLogin.fillCreds(prop.getProperty("email"), prop.getProperty("password") );
            dashboard = adminLogin.doLogin();
            Assert.assertTrue(dashboard.verifyDashboard());
        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail(ex.getMessage());
        }
    }
}
