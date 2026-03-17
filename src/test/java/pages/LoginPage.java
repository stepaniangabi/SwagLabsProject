package pages;

import models.CustomerModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    private WebDriverWait wait; // ✅ trebuie să fie declarat aici

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
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ✅ inițializare aici
    }

    // Metodă de login
    public void loginProcess(CustomerModel customer) {
        usernameField.sendKeys(customer.getUsername());
        passwordField.sendKeys(customer.getPassword());
        loginButton.click();
    }

    // Metodă pentru a obține mesajul de eroare
    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage)); // ✅ folosește wait
        return errorMessage.getText();
    }
}