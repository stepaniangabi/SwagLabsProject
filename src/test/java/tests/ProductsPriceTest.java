package tests;

import models.CustomerModel;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import sharedData.SharedData;
import utils.JsonReader;

import java.util.List;

public class ProductsPriceTest extends SharedData {
    @Test
    public void verifyAllProductsHavePrice() {

        // luam datele din JSON
        CustomerModel testData = JsonReader.getCustomerData();

        // login
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginProcess(testData);

        // mergem pe pagina de produse
        ProductsPage productsPage = new ProductsPage(getDriver());

        List<WebElement> prices = productsPage.getProductPrices();

        for (WebElement price : prices) {
            String priceText = price.getText();
            // afisam pretul in consola
            System.out.println("Pret produs: " + priceText);

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
    }
}
