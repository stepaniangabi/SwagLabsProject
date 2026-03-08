package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllItemsTest {
    @Test
    public void clickAllItemsPage() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        // login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // deschide burger menu
        driver.findElement(By.id("react-burger-menu-btn")).click();

        // click All Items
        driver.findElement(By.id("inventory_sidebar_link")).click();

        // validare
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));

    }
}

