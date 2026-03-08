package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class ProductsTest extends SharedData {
    @Test
    public void productsPageDisplayed(){
        driver = new ChromeDriver();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // deschidem site-ul
        driver.get("https://www.saucedemo.com/");

        // login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // verificam titlul "Products"
        WebElement productsTitle = driver.findElement(By.className("title"));

        Assert.assertEquals(
                productsTitle.getText(),
                "Products"
        );

        // verificam ca exista produse pe pagina
        int numberOfProducts = driver.findElements(By.className("inventory_item")).size();

        Assert.assertTrue(
                numberOfProducts > 0,
                "Nu exista produse pe pagina"
        );


    }

}
