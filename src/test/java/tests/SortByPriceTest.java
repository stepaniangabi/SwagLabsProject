package tests;

import models.CustomerModel;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SortByPricePage;
import sharedData.SharedData;
import utils.JsonReader;

public class SortByPriceTest extends SharedData {
    @Test
    public void sortProductsByPriceLowToHigh(){

        CustomerModel testData = JsonReader.getCustomerData();

        // login
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginProcess(testData);

        SortByPricePage sortPage = new SortByPricePage(getDriver());

        Select sortSelect = new Select(sortPage.getSortDropdown());

        String sortOption = "PRICE_LOW_HIGH";

        switch (sortOption){

            case "PRICE_LOW_HIGH":
                sortSelect.selectByValue("lohi");
                System.out.println("Sortare dupa pret crescator");
                break;

            case "PRICE_HIGH_LOW":
                sortSelect.selectByValue("hilo");
                System.out.println("Sortare dupa pret descrescator");
                break;

            case "NAME_A_Z":
                sortSelect.selectByValue("az");
                System.out.println("Sortare dupa nume A-Z");
                break;

            case "NAME_Z_A":
                sortSelect.selectByValue("za");
                System.out.println("Sortare dupa nume Z-A");
                break;
        }
    }
}
