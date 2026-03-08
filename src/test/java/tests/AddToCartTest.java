package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import sharedData.SharedData;

public class AddToCartTest extends SharedData {

    @Test
    public void addProductToCartSuccessfully(){

        WebDriver driver = new ChromeDriver();

        // deschid site-ul
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        // login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // add to cart primul produs
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        // validare: apare badge-ul cu 1 pe cart
        String cartBadge = driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals(cartBadge, "1");

    }
}
