package tests;

import models.CustomerModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import sharedData.SharedData;
import utils.JsonReader;

public class RemoveProductFromCartTest extends SharedData {
    @Test
    public void removeProductFromCart() {
        // Citește datele clientului
        CustomerModel testData = JsonReader.getCustomerData();

        // Login
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginProcess(testData);

        // Adaugă produs în coș
        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage.addProductToCartByIndex(0); // primul produs

        // Verifică că produsul a fost adăugat
        CartPage cartPage = new CartPage(getDriver());
        Assert.assertTrue(cartPage.isProductInCart(), "Produsul nu a fost adăugat în coș!");

        // Șterge produsul din coș
        cartPage.removeProductFromCartByIndex(0);

        // Verifică că coșul e gol
        Assert.assertEquals(cartPage.getNumberOfProductsInCart(), 0, "Coșul nu a fost gol după ștergere!");
    }
}
