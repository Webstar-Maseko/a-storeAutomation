package org.webstar.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.webstar.Base.BaseTest;
import org.webstar.Utilities.FileHandler;
import org.webstar.Utilities.RandomUser;

public class RegistrationTest extends BaseTest {

    @Test(priority = 1, description = "Register a new user on the platform")
    public void register_new_user() {
        try {
            String password = "Password123.";
            String email = RandomUser.getEmail();
            adminRegister.clickRegisterLink();
            adminRegister.register(email, RandomUser.getName(), RandomUser.getLastName(), "0748592573", password, password);
            dashboard = adminRegister.doRegister();
            Assert.assertTrue(dashboard.verifyDashboard());
            //Save the newly registered user to a txt file
            FileHandler.writeToFile("registration.txt", email);

        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail(ex.getMessage());
        }
    }
}
