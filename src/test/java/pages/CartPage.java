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

    // metoda originala pentru a adauga produs in cos dupa id
    public void addProductToCart(String productId) {
        WebElement addButton = driver.findElement(By.id(productId));
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        addButton.click();
    }

    // returneaza textul badge-ului din cos
    public String getCartBadgeText() {
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        wait.until(ExpectedConditions.visibilityOf(cartBadge));
        return cartBadge.getText();
    }

    // verifica daca exista produse in cos
    public boolean isProductInCart() {
        try {
            WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
            return cartBadge.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // returneaza numarul de produse din cos
    public int getNumberOfProductsInCart() {
        try {
            WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
            return Integer.parseInt(cartBadge.getText());
        } catch (Exception e) {
            return 0;
        }
    }
}