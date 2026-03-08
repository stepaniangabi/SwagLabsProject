package tests;

import models.CustomerModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import sharedData.SharedData;
import utils.JsonReader;

public class AllItemsTest extends SharedData {
    @Test
    public void clickAllItemsPage() {
        CustomerModel testData = JsonReader.getCustomerData();
        // login
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginProcess(testData);

        // navighează la All Items folosind InventoryPage
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        inventoryPage.goToAllItems();

    }
}

