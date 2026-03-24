package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LogUtility;

import java.time.Duration;

public class LogoutPage extends BasePage {

    private WebDriverWait wait;

    public LogoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Butonul burger menu
    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    // Link-ul de logout
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    // Deschide meniul lateral
    public void openMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(menuButton));
        menuButton.click();
        LogUtility.infoLog("Burger menu opened");
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
    }

    // Click pe logout
    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        logoutLink.click();
        LogUtility.infoLog("Burger menu opened");
    }

    // Proces complet de logout
    public void logoutProcess() {
        LogUtility.infoLog("Starting logout process");
        openMenu();
        clickLogout();
        // așteaptă pagina de login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
        LogUtility.infoLog("Starting logout process");
    }

    // Verificare dacă suntem pe pagina de login după logout
    public boolean isLoginPageDisplayed() {
        boolean displayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))).isDisplayed();
        LogUtility.infoLog("Checked if login page is displayed: " + displayed);
        return displayed;
    }
}