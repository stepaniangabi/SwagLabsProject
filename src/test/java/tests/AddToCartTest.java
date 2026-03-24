package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import models.CustomerModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import sharedData.SharedData;
import utils.JsonReader;
import utils.LogUtility;

@Feature("Add To Cart Test")
@Story("Add To Cart Test")
public class AddToCartTest extends SharedData {

    @Test(description = "TC-6: User can add product to cart successfully")
    public void addProductToCartSuccessfully() {
        String testName = "addProductToCartSuccessfully";
        LogUtility.startTest(testName);

        CustomerModel testData = JsonReader.getCustomerData();
        LogUtility.infoLog("Loaded customer test data");

        // Login
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginProcess(testData);
        LogUtility.infoLog("User logged in successfully");

        // CartPage
        CartPage cartPage = new CartPage(getDriver());

        // Adaugă primul produs (Backpack) în coș
        cartPage.addProductToCart("add-to-cart-sauce-labs-backpack");
        LogUtility.infoLog("Added 'Sauce Labs Backpack' to cart");

        // Validare: badge-ul arată 1
        Assert.assertEquals(cartPage.getCartBadgeText(), "1");
        LogUtility.infoLog("Verified cart badge shows 1");

        LogUtility.finishTest(testName);
    }
}
