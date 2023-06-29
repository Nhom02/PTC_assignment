package testcases;

import base.BaseClass;
import helpers.CustomDataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

@Test()
public class LoginTest extends BaseClass{
    public LoginTest() {
        super();
    }

    @BeforeTest
    public void setUp() {
        intialization();
    }
    @Test(dataProvider = "ValidLoginData", dataProviderClass = CustomDataProvider.class)
    public void verifyUserCannotLoginWithWrongCredentials(String email, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.goToPage();
        loginPage.doLogin(email, password);
        String errorMessage = loginPage.getEmailError();
        Assert.assertEquals(errorMessage, "The inputted email or\n" +
                "password is not correct.");

    }

    @Test(dataProvider = "InvalidLoginData", dataProviderClass = CustomDataProvider.class)
    public void verifyUserLoginSuccesfully(String email, String password) {
        LoginPage loginPage = new LoginPage();
        WelcomePage welcomPage = new WelcomePage();
        loginPage.goToPage();
        loginPage.doLogin(email, password);
        String successMessage = welcomPage.getLoggedInMessage();
        Assert.assertEquals(successMessage, "You have logged-in successfully!.");
    }
}