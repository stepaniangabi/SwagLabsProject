package tests;

import models.CustomerModel;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import sharedData.SharedData;
import utils.JsonReader;

public class ProductsTest extends SharedData {

    @Test
    public void productsPageDisplayed() {
        CustomerModel testData = JsonReader.getCustomerData();

        // login
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginProcess(testData);

        // verificam titlul "Products"
        String pageTitle = getDriver().findElement(By.className("title")).getText();
        Assert.assertEquals(pageTitle, "Products", "Titlul paginii nu este 'Products'");

        // verificam ca exista produse pe pagina
        int numberOfProducts = getDriver().findElements(By.className("inventory_item")).size();
        Assert.assertTrue(numberOfProducts > 0, "Nu exista produse pe pagina");
    }
}