package sharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.Map;

public class SharedData {
    private WebDriver driver;

    @BeforeMethod
    public void prepareEnvironment(){
        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);                 // disable Save passwords
        prefs.put("profile.password_manager_enabled", false);           // disable password manager
        prefs.put("profile.password_manager_leak_detection", false);    // disable breach warning

        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

    }


    @AfterMethod
    public void clearEnvironment(){
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
