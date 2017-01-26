package qa.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Web Driver Fabric
 */
public class WebDriverFactory {

    public static WebDriver getDriverInstance() {
        String browser = System.getProperty("webdriver.driver", "firefox");
        WebDriver driver;
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            default:
                driver = new FirefoxDriver();
                break;
        }
        int implicitlyWait = Integer.parseInt(System.getProperty("webdriver.timeouts.implicitlywait"));
        driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
        return driver;
    }

}
