package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LogUtility;

import java.time.Duration;

public class InventoryPage extends BasePage {

    private WebDriverWait wait;

    public InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        LogUtility.infoLog("InventoryPage initialized");
    }

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "inventory_sidebar_link")
    private WebElement allItemsLink;

    public void openMenu() {
        LogUtility.infoLog("Opening burger menu");
        menuButton.click();
        LogUtility.infoLog("Burger menu opened");
    }

    public void clickAllItems() {
        LogUtility.infoLog("Clicking 'All Items' link");
        wait.until(ExpectedConditions.elementToBeClickable(allItemsLink));
        allItemsLink.click();
        LogUtility.infoLog("'All Items' link clicked successfully");
    }

    public void goToAllItems() {
        LogUtility.infoLog("Navigating to All Items page");
        openMenu();
        clickAllItems();
        LogUtility.infoLog("Navigation to All Items page completed");
    }

    public boolean isAllItemsPage() {
        boolean isAllItems = driver.getCurrentUrl().contains("inventory");
        LogUtility.infoLog("Is All Items page displayed? " + isAllItems);
        return isAllItems;
    }
}