package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import models.CustomerModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;
import sharedData.SharedData;
import utils.JsonReader;
import utils.LogUtility;

@Feature("Logout Test")
@Story("Logout Test")
public class LogoutTest extends SharedData {

    @Test(description = "TC-10: User can logout successfully")
    public void logoutSuccessfully() {
        String testName = "logoutSuccessfully";
        LogUtility.startTest(testName);

        CustomerModel testData = JsonReader.getCustomerData();
        LogUtility.infoLog("Loaded customer test data");

        // login
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginProcess(testData);
        LogUtility.infoLog("User logged in successfully");

        // logout
        LogoutPage logoutPage = new LogoutPage(getDriver());
        logoutPage.logoutProcess();
        LogUtility.infoLog("User clicked logout and completed logout process");

        // validare
        Assert.assertTrue(logoutPage.isLoginPageDisplayed(), "Login page is not displayed after logout");
        LogUtility.infoLog("Verified login page is displayed after logout");

        LogUtility.finishTest(testName);
    }
}
