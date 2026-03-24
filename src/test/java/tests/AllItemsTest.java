package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import models.CustomerModel;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import sharedData.SharedData;
import utils.JsonReader;
import utils.LogUtility;

@Feature("All Items Test")
@Story("All Items Test")
public class AllItemsTest extends SharedData {
    @Test(description = "TC-9: User can open All Items page from menu")
    public void clickAllItemsPage() {
        String testName = "AllItemsTest";
        LogUtility.startTest(testName);  // log start test

        CustomerModel testData = JsonReader.getCustomerData();

        // login
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginProcess(testData);

        // navighează la All Items folosind InventoryPage
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        inventoryPage.goToAllItems();

        LogUtility.finishTest(testName); // log finish test
    }
}