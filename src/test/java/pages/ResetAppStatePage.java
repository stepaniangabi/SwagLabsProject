package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LogUtility;

import java.time.Duration;

public class ResetAppStatePage extends BasePage {

    private By burgerMenu = By.id("react-burger-menu-btn");
    private By resetAppStateLink = By.id("reset_sidebar_link");

    private WebDriverWait wait;

    public ResetAppStatePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        LogUtility.infoLog("ResetAppStatePage initialized");
    }

    public void clickResetAppState() {
        LogUtility.infoLog("Attempting to open burger menu");
        // deschide burger menu
        wait.until(ExpectedConditions.elementToBeClickable(burgerMenu)).click();
        LogUtility.infoLog("Burger menu opened");

        LogUtility.infoLog("Clicking on 'Reset App State'");
        // click pe reset app state
        WebElement reset = wait.until(ExpectedConditions.elementToBeClickable(resetAppStateLink));
        reset.click();
        LogUtility.infoLog("'Reset App State' clicked successfully");
    }
}