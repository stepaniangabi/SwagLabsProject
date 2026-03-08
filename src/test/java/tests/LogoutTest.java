package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.time.Duration;

public class LogoutTest extends SharedData {

    @Test
    public void logoutSuccessfully() {
        WebDriver driver = new ChromeDriver();

        //deschid pagina
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        // login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // deschid meniul burger
        driver.findElement(By.id("react-burger-menu-btn")).click();

        // click pe logout
        driver.findElement(By.id("logout_sidebar_link")).click();

        // validare: aștept până se afișează butonul de login
        WebElement loginButton = driver.findElement(By.id("login-button"));
        Assert.assertTrue(loginButton.isDisplayed());

        driver.quit();
    }
}