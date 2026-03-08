package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import sharedData.SharedData;

public class ProductsTest extends SharedData {

    @Test
    public void productsPageDisplayed() {

        // login
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginProcess("standard_user", "secret_sauce");

        // verificam titlul "Products"
        String pageTitle = getDriver().findElement(By.className("title")).getText();
        Assert.assertEquals(pageTitle, "Products", "Titlul paginii nu este 'Products'");

        // verificam ca exista produse pe pagina
        int numberOfProducts = getDriver().findElements(By.className("inventory_item")).size();
        Assert.assertTrue(numberOfProducts > 0, "Nu exista produse pe pagina");
    }
}