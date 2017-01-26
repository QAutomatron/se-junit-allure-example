package site.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import site.pages.Page;

/**
 * Search Form Element
 */
public class SearchElement extends Page {

    @FindBy(id = "text")
    private WebElement searchField;
    @FindBy(css = "button[type='Submit']")
    private WebElement searchButton;

    public SearchElement(WebDriver driver) {
        super(driver);
    }

    /**
     * Check if form present
     * @return boolean
     */
    public boolean isFormPresent() {
        return waitForElementPresent(searchField);
    }

    /**
     * Set search field
     * @param s value
     */
    public void setSearchField(String s) {
        typeInto(searchField, s);
    }

    /**
     * Click search button
     */
    public void clickSearch() {
        searchButton.click();
    }
}

