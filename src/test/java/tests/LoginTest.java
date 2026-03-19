package tests;

import models.CustomerModel;
import org.testng.annotations.Test;
import pages.LoginPage;
import sharedData.SharedData;
import utils.JsonReader;

public class LoginTest extends SharedData {

    @Test
    public void validLogin() {
        CustomerModel testData = JsonReader.getCustomerData();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginProcess(testData);
    }
}