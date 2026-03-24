package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import models.CustomerModel;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import sharedData.SharedData;
import utils.JsonReader;
import utils.LogUtility;

@Feature("Products Page Test")
@Story("Verify products page displays correct title and products list")
public class ProductsTest extends SharedData {

    @Test(description = "TC-3: Verify that Products page displays title and products list")
    public void productsPageDisplayed() {
        String testName = "productsPageDisplayed";
        LogUtility.startTest(testName);

        CustomerModel testData = JsonReader.getCustomerData();
        LogUtility.infoLog("Loaded customer test data");

        // login
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginProcess(testData);
        LogUtility.infoLog("User logged in successfully");

        // verificam titlul "Products"
        String pageTitle = getDriver().findElement(By.className("title")).getText();
        Assert.assertEquals(pageTitle, "Products", "Titlul paginii nu este 'Products'");
        LogUtility.infoLog("Verified page title is 'Products'");

        // verificam ca exista produse pe pagina
        int numberOfProducts = getDriver().findElements(By.className("inventory_item")).size();
        Assert.assertTrue(numberOfProducts > 0, "Nu exista produse pe pagina");
        LogUtility.infoLog("Verified there are " + numberOfProducts + " products displayed on the page");

        LogUtility.finishTest(testName);
    }
}
