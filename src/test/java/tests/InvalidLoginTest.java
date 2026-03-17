package tests;

import models.CustomerModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import sharedData.SharedData;
import utils.JsonReader;

public class InvalidLoginTest extends SharedData {
    @Test
    public void loginWithInvalidPasswordShowsError() {
        // Citește datele clientului
        CustomerModel testData = JsonReader.getCustomerData();

        // Folosim parola greșită
        testData.setPassword("wrongPassword123");

        // Login
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginProcess(testData);

        // Validare: mesajul de eroare
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Username and password do not match"), "Mesajul de eroare nu este corect: " + errorMessage);
    }
}
