package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        menuButton.click();
        wait.until(ExpectedConditions.visibilityOf(logoutLink));
    }

    // Click pe logout
    public void clickLogout() {
        logoutLink.click();
    }

    // Proces complet de logout
    public void logoutProcess() {
        openMenu();
        clickLogout();
    }

    // Verificare dacă suntem pe pagina de login după logout
    public void isLoginPageDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
    }
}