package browserUtility;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserUtility {

    private WebDriver driver;

    public WebDriver launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://lkmdemoaut.accenture.com/AccenSportz/#/");
        return driver;
    }

    public void closeBrowser() {
        if(driver != null)
            driver.quit();
    }
}