package pages;

import models.CustomerModel;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LogUtility;

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

        LogUtility.infoLog("Enter username");
        usernameField.sendKeys(customer.getUsername());

        LogUtility.infoLog("Enter password");
        passwordField.sendKeys(customer.getPassword());

        LogUtility.infoLog("Click login button");
        loginButton.click();

        // tratează alerta dacă apare
        acceptAlertIfPresent();
    }

    // Metodă pentru alerta care poate apărea uneori
    public void acceptAlertIfPresent() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            LogUtility.infoLog("Alert accepted");
        } catch (NoAlertPresentException e) {
            LogUtility.infoLog("No alert present");
        }
    }

    // Metodă pentru a obține mesajul de eroare
    public String getErrorMessage() {

        LogUtility.infoLog("Waiting for error message");
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        LogUtility.infoLog("Error message displayed");
        return errorMessage.getText();
    }
}