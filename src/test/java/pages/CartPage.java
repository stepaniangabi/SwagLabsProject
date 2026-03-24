package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LogUtility;

import java.time.Duration;
import java.util.List;

public class CartPage extends BasePage {

    private WebDriverWait wait;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void addProductToCart(String productId) {
        LogUtility.infoLog("Add product to cart with productId: " + productId);

        WebElement addButton = driver.findElement(By.id(productId));
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        addButton.click();
    }

    public String getCartBadgeText() {
        String text = driver.findElement(By.className("shopping_cart_badge")).getText();
        LogUtility.infoLog("Cart badge text: " + text);
        return text;
    }

    public boolean isProductInCart() {
        try {
            boolean displayed = driver.findElement(By.className("shopping_cart_badge")).isDisplayed();
            LogUtility.infoLog("Product in cart? " + displayed);
            return displayed;
        } catch (Exception e) {
            LogUtility.infoLog("No products in cart");
            return false;
        }
    }

    public int getNumberOfProductsInCart() {
        try {
            int number = Integer.parseInt(driver.findElement(By.className("shopping_cart_badge")).getText());
            LogUtility.infoLog("Number of products in cart: " + number);
            return number;
        } catch (Exception e) {
            LogUtility.infoLog("Cart is empty");
            return 0;
        }
    }

    public void waitForCartToBeEmptyAfterReset() {
        LogUtility.infoLog("Waiting for cart to be empty after reset");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> {
            try {
                WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
                return !cartBadge.isDisplayed();
            } catch (org.openqa.selenium.NoSuchElementException e) {
                return true;
            }
        });
        LogUtility.infoLog("Cart is empty now");
    }

    public void waitForCartToBeEmpty() {
        LogUtility.infoLog("Waiting for cart to be empty");
        wait.until(driver ->
                driver.findElements(By.className("shopping_cart_badge")).isEmpty()
        );
        LogUtility.infoLog("Cart is empty now");
    }

    public void removeProductFromCartByIndex(int index) {
        LogUtility.infoLog("Removing product from cart at index: " + index);

        List<WebElement> removeButtons =
                driver.findElements(By.cssSelector(".cart_item button[id^='remove-']"));

        wait.until(ExpectedConditions.elementToBeClickable(removeButtons.get(index)));
        removeButtons.get(index).click();

        LogUtility.infoLog("Product removed from cart at index: " + index);
    }
}