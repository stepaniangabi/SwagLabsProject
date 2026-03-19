package pages;

import models.CustomerModel;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    private WebDriverWait wait;

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "h3[data-test='error']")
    private WebElement errorMessage;

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Metodă de login
    public void loginProcess(CustomerModel customer) {
        usernameField.sendKeys(customer.getUsername());
        passwordField.sendKeys(customer.getPassword());
        loginButton.click();

        // tratează alerta dacă apare
        acceptAlertIfPresent();
    }

    // Metodă pentru alerta care poate apărea uneori
    public void acceptAlertIfPresent() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            // alerta nu a apărut,  continuăm testul
        }
    }

    // Metodă pentru a obține mesajul de eroare
    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }
}