package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import models.CustomerModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import sharedData.SharedData;
import utils.JsonReader;

@Feature("Cart Management")
@Story("Remove Product from Cart")
public class RemoveProductFromCartTest extends SharedData {

    @Test(description = "TC-7: Remove a product from the shopping cart successfully")
    public void removeProductFromCart() {

        CustomerModel testData = JsonReader.getCustomerData();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginProcess(testData);

        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage.addProductToCartByIndex(0);

        productsPage.clickCart();

        CartPage cartPage = new CartPage(getDriver());

        Assert.assertTrue(cartPage.isProductInCart());

        cartPage.removeProductFromCartByIndex(0);

        cartPage.waitForCartToBeEmpty();

        Assert.assertEquals(cartPage.getNumberOfProductsInCart(), 0);
    }
}