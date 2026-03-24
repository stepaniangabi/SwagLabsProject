package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.LogUtility;

import java.util.List;

public class SortByPricePage extends BasePage {
    public SortByPricePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "product_sort_container")
    private WebElement sortDropdown;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> productNames;

    // Returnează dropdown-ul și loghează acțiunea
    public WebElement getSortDropdown() {
        LogUtility.infoLog("Accessed sort dropdown element");
        return sortDropdown;
    }

    // Returnează lista de nume de produse și loghează acțiunea
    public List<WebElement> getProductNames() {
        LogUtility.infoLog("Retrieved list of product names, total: " + productNames.size());
        return productNames;
    }
}