package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage {

    private WebDriverWait wait;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Adaugă produs în coș după ID-ul butonului
    public void addProductToCart(String productId) {
        WebElement addButton = driver.findElement(By.id(productId));
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        addButton.click();
    }

    // Obține numărul de produse din coș
    public String getCartBadgeText() {
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        wait.until(ExpectedConditions.visibilityOf(cartBadge));
        return cartBadge.getText();
    }
}