package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "inventory_item_price")
    private List<WebElement> productPrices;

    @FindBy(xpath = "//button[contains(text(),'Add to cart')]")
    private List<WebElement> addToCartButtons;

    public List<WebElement> getProductPrices() {
        return productPrices;
    }

    public void addProductToCartByIndex(int index) {
        addToCartButtons.get(index).click();
    }
}


