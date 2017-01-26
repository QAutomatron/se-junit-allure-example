package site.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Main Page
 */
public class MainPage extends Page {

    @FindBy(css = "a.layout__footer-logo")
    private WebElement mainLogo;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Open Main Page
     */
    public void open(){
        openAt("/");
    }

    /**
     * Check if Main Page is opened
     * @return boolean
     */
    public boolean isPageOpened() {
        return waitForElementPresent(mainLogo);
    }
}

