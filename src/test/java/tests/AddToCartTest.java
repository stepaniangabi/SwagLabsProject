package tests;

import models.CustomerModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import sharedData.SharedData;
import utils.JsonReader;

public class AddToCartTest extends SharedData {

    @Test
    public void addProductToCartSuccessfully() {

        CustomerModel testData = JsonReader.getCustomerData();
        // login
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginProcess(testData);

        // CartPage
        CartPage cartPage = new CartPage(getDriver());

        // Adaugă primul produs (Backpack) în coș
        cartPage.addProductToCart("add-to-cart-sauce-labs-backpack");

        // Validare: badge-ul arată 1
        Assert.assertEquals(cartPage.getCartBadgeText(), "1");
    }
}