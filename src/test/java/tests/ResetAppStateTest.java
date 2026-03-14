package tests;

import models.CustomerModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.ResetAppStatePage;
import sharedData.SharedData;
import utils.JsonReader;

public class ResetAppStateTest extends SharedData {

    @Test
    public void resetAppStateClearsCart() {
        // Citește datele clientului
        CustomerModel testData = JsonReader.getCustomerData();

        // Login
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginProcess(testData);

        // Adaugă un produs în coș
        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage.addProductToCartByIndex(0); // primul produs

        // Verifică că produsul a fost adăugat
        CartPage cartPage = new CartPage(getDriver());
        Assert.assertTrue(cartPage.isProductInCart(), "Produsul nu a fost adaugat in cart!");

        // Deschide burger menu și dă reset
        ResetAppStatePage resetPage = new ResetAppStatePage(getDriver());
        resetPage.clickResetAppState();

        // Așteaptă ca coșul să fie gol folosind metoda din CartPage
        cartPage.waitForCartToBeEmpty();

        // Verifică că coșul a fost resetat
        Assert.assertEquals(cartPage.getNumberOfProductsInCart(), 0, "Cosul nu a fost resetat!");
    }
}