package sharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.LogUtility;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class SharedData {
    private WebDriver driver;

    @BeforeMethod
    public void prepareEnvironment(Method method){

        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);

        options.setExperimentalOption("prefs", prefs);

        // ✅ HEADLESS DOAR IN PIPELINE
        String ci = System.getenv("CI");

        if (ci != null) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
        }

        driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        LogUtility.startTest(method.getName());
    }

    @AfterMethod
    public void clearEnvironment(Method method){
        driver.quit();
        LogUtility.finishTest(method.getName());
    }

    public WebDriver getDriver() {
        return driver;
    }
}