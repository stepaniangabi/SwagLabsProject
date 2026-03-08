package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import sharedData.SharedData;

public class LoginTest extends SharedData {

    @Test
    public void validLogin(){

        //completam campurile de la login
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginProcess("standard_user", "secret_sauce");

    }
}
