package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import sharedData.SharedData;

public class AddToCartTest extends SharedData {

    @Test
    public void addProductToCartSuccessfully() {
        // login
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginProcess("standard_user", "secret_sauce");

        // CartPage
        CartPage cartPage = new CartPage(getDriver());

        // Adaugă primul produs (Backpack) în coș
        cartPage.addProductToCart("add-to-cart-sauce-labs-backpack");

        // Validare: badge-ul arată 1
        Assert.assertEquals(cartPage.getCartBadgeText(), "1");
    }
}