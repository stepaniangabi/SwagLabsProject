package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import sharedData.SharedData;

public class AllItemsTest extends SharedData {
    @Test
    public void clickAllItemsPage() {
        // login
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginProcess("standard_user", "secret_sauce");

        // navighează la All Items folosind InventoryPage
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        inventoryPage.goToAllItems();

    }
}

