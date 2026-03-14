package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResetAppStatePage extends BasePage {

    private By burgerMenu = By.id("react-burger-menu-btn");
    private By resetAppStateLink = By.id("reset_sidebar_link");

    public ResetAppStatePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickResetAppState() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // deschide burger menu
        wait.until(ExpectedConditions.elementToBeClickable(burgerMenu)).click();

        // click pe reset app state
        WebElement reset = wait.until(ExpectedConditions.elementToBeClickable(resetAppStateLink));
        reset.click();
    }
}