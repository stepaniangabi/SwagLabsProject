package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;
import sharedData.SharedData;

public class LogoutTest extends SharedData {

    @Test
    public void logoutSuccessfully() {
        // login
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginProcess("standard_user", "secret_sauce");

        // logout
        LogoutPage logoutPage = new LogoutPage(getDriver());
        logoutPage.logoutProcess();

        // validare
        Assert.assertTrue(logoutPage.isLoginPageDisplayed());
    }
}