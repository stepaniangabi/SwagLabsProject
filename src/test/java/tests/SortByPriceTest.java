package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import models.CustomerModel;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SortByPricePage;
import sharedData.SharedData;
import utils.JsonReader;
import utils.LogUtility;

@Feature("Sort Products")
@Story("Sort products by price ascending")
public class SortByPriceTest extends SharedData {
    @Test(description = "TC-5: Sort products by price from low to high")
    public void sortProductsByPriceLowToHigh() {

        CustomerModel testData = JsonReader.getCustomerData();

        // start test log
        LogUtility.startTest("SortByPriceTest");

        // login
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginProcess(testData);
        LogUtility.infoLog("User logged in successfully");

        SortByPricePage sortPage = new SortByPricePage(getDriver());

        Select sortSelect = new Select(sortPage.getSortDropdown());

        String sortOption = "PRICE_LOW_HIGH";

        switch (sortOption) {
            case "PRICE_LOW_HIGH":
                sortSelect.selectByValue("lohi");
                LogUtility.infoLog("Products sorted by price: low to high");
                break;

            case "PRICE_HIGH_LOW":
                sortSelect.selectByValue("hilo");
                LogUtility.infoLog("Products sorted by price: high to low");
                break;

            case "NAME_A_Z":
                sortSelect.selectByValue("az");
                LogUtility.infoLog("Products sorted by name: A-Z");
                break;

            case "NAME_Z_A":
                sortSelect.selectByValue("za");
                LogUtility.infoLog("Products sorted by name: Z-A");
                break;
        }

        // finish test log
        LogUtility.finishTest("SortByPriceTest");
    }
}