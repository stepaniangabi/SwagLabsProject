package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class InventoryPage extends BasePage {

    private WebDriverWait wait;

    public InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "inventory_sidebar_link")
    private WebElement allItemsLink;

    public void openMenu() {
        menuButton.click();
    }

    public void clickAllItems() {
        // Așteaptă până elementul e clickabil
        wait.until(ExpectedConditions.elementToBeClickable(allItemsLink));
        allItemsLink.click();
    }

    public void goToAllItems() {
        openMenu();
        clickAllItems();
    }

    public boolean isAllItemsPage() {
        return driver.getCurrentUrl().contains("inventory");
    }
}