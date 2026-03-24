package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import models.CustomerModel;
import org.testng.annotations.Test;
import pages.LoginPage;
import sharedData.SharedData;
import utils.JsonReader;
import utils.LogUtility;

@Feature("Login Test")
@Story("Login Test")
public class LoginTest extends SharedData {

    @Test(description = "TC-1: Valid login with correct username and password ")
    public void validLogin() {
        String testName = "validLogin";
        LogUtility.startTest(testName);  // log start test

        CustomerModel testData = JsonReader.getCustomerData();
        LogUtility.infoLog("Loaded customer test data");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginProcess(testData);
        LogUtility.infoLog("User attempted login with valid credentials");

        LogUtility.finishTest(testName); // log finish test
    }
}