package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import models.CustomerModel;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import sharedData.SharedData;
import utils.JsonReader;
import utils.LogUtility;
import java.util.List;

@Feature("Products Price Test")
@Story("Verify that all products have a price")
public class ProductsPriceTest extends SharedData {
    @Test(description = "TC-4: Verify all products display a valid price with $ symbol")
    public void verifyAllProductsHavePrice() {
        String testName = "ProductsPriceTest";
        LogUtility.startTest(testName);  // Start test log

        // luam datele din JSON
        CustomerModel testData = JsonReader.getCustomerData();
        LogUtility.infoLog("Loaded customer data from JSON");

        // login
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginProcess(testData);
        LogUtility.infoLog("Performed login successfully");

        // mergem pe pagina de produse
        ProductsPage productsPage = new ProductsPage(getDriver());
        LogUtility.infoLog("Navigated to Products page");

        List<WebElement> prices = productsPage.getProductPrices();
        LogUtility.infoLog("Retrieved all product prices from page");

        for (WebElement price : prices) {
            String priceText = price.getText();
            LogUtility.infoLog("Product price found: " + priceText);

            // verificam ca pretul exista
            Assert.assertFalse(
                    priceText.isEmpty(),
                    "Un produs nu are pret afisat!"
            );

            // verificam ca pretul contine simbolul $
            Assert.assertTrue(
                    priceText.contains("$"),
                    "Pretul nu este afisat corect!"
            );
        }

        LogUtility.finishTest(testName); // Finish test log
    }
}