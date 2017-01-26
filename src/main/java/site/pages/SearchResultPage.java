package site.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Search Result Page
 */
public class SearchResultPage extends Page{

    @FindBy(css = ".main__content")
    private WebElement resultBlock;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Check that page is opened
     * @return boolean
     */
    public boolean isPageOpened() {
        return waitForElementPresent(resultBlock);
    }
}

