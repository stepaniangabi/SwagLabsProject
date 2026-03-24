package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import utils.LogUtility;

import java.util.List;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "inventory_item_price")
    private List<WebElement> productPrices;

    public List<WebElement> getProductPrices() {
        LogUtility.infoLog("Get product prices");
        return productPrices;
    }

    public void addProductToCartByIndex(int index) {

        LogUtility.infoLog("Add product to cart with index: " + index);

        List<WebElement> buttons = driver.findElements(By.cssSelector("button[id^='add-to-cart']"));
        buttons.get(index).click();
    }

    public void clickCart() {

        LogUtility.infoLog("Click on cart");
        driver.findElement(By.className("shopping_cart_link")).click();
    }
}