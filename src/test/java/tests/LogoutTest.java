package tests;

import models.CustomerModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;
import sharedData.SharedData;
import utils.JsonReader;

public class LogoutTest extends SharedData {

    @Test
    public void logoutSuccessfully() {
        CustomerModel testData = JsonReader.getCustomerData();

        // login
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginProcess(testData);

        // logout
        LogoutPage logoutPage = new LogoutPage(getDriver());
        logoutPage.logoutProcess();

        // validare
        Assert.assertTrue(logoutPage.isLoginPageDisplayed());
    }
}