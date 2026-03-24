package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import models.CustomerModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import sharedData.SharedData;
import utils.JsonReader;
import utils.LogUtility;

@Feature("Invalid Login Test")
@Story("Invalid Login Test")
public class InvalidLoginTest extends SharedData {
    @Test(description = "TC-2: Login with invalid password shows error message")
    public void loginWithInvalidPasswordShowsError() {
        String testName = "InvalidLoginTest";
        LogUtility.startTest(testName);  // log start test

        // Citește datele clientului
        CustomerModel testData = JsonReader.getCustomerData();

        // Folosim parola greșită
        testData.setPassword("wrongPassword123");
        LogUtility.infoLog("Set an invalid password for the test user");

        // Login
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginProcess(testData);
        LogUtility.infoLog("Performed login with invalid password");

        // Validare: mesajul de eroare
        String errorMessage = loginPage.getErrorMessage();
        LogUtility.infoLog("Captured error message: " + errorMessage);

        Assert.assertTrue(errorMessage.contains("Username and password do not match"),
                "Mesajul de eroare nu este corect: " + errorMessage);

        LogUtility.finishTest(testName); // log finish test
    }
}