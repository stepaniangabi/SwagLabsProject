package pages;

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
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    // Metodă pentru a deschide meniul
    public void openMenu() {
        menuButton.click();
    }

    // Metodă pentru logout
    public void clickLogout() {
        // Așteaptă până link-ul e clickabil
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        logoutLink.click();
    }

    public void logoutProcess() {
        openMenu();
        clickLogout();
    }

    // Verificare dacă suntem pe pagina de login
    public boolean isLoginPageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return loginButton.isDisplayed();
    }
}