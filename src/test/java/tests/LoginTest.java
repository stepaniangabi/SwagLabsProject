package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class LoginTest extends SharedData {
    WebDriver driver = new ChromeDriver();

    @Test
    public void validLogin(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        //completam campurile de la login
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        //click pe butonul de login
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

    }
}
