package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import models.CustomerModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.ResetAppStatePage;
import sharedData.SharedData;
import utils.JsonReader;
import utils.LogUtility;

@Feature("Reset App State")
@Story("Reset App State clears the cart")
public class ResetAppStateTest extends SharedData {

    @Test(description = "TC-8: Reset app state clears the cart after adding product")
    public void resetAppStateClearsCart() {
        String testName = "ResetAppStateTest";
        LogUtility.startTest(testName);

        // Citește datele clientului
        CustomerModel testData = JsonReader.getCustomerData();
        LogUtility.infoLog("Loaded customer data from JSON");

        // Login
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginProcess(testData);
        LogUtility.infoLog("Performed login successfully");

        // Adaugă un produs în coș
        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage.addProductToCartByIndex(0);
        LogUtility.infoLog("Added first product to cart");

        // Verifică că produsul a fost adăugat
        CartPage cartPage = new CartPage(getDriver());
        Assert.assertTrue(cartPage.isProductInCart(), "Produsul nu a fost adaugat in cart!");
        LogUtility.infoLog("Verified product is in cart");

        // Deschide burger menu și dă reset
        ResetAppStatePage resetPage = new ResetAppStatePage(getDriver());
        resetPage.clickResetAppState();
        LogUtility.infoLog("Clicked Reset App State");

        // Așteaptă ca coșul să fie gol folosind metoda din CartPage
        cartPage.waitForCartToBeEmptyAfterReset();
        LogUtility.infoLog("Waited for cart to be empty after reset");

        // Verifică că coșul a fost resetat
        Assert.assertEquals(cartPage.getNumberOfProductsInCart(), 0, "Cosul nu a fost resetat!");
        LogUtility.infoLog("Verified cart has been reset");

        LogUtility.finishTest(testName);
    }
}