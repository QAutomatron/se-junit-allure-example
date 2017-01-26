package site;

import org.junit.Before;
import org.junit.Test;
import qa.driver.WebDriverFactory;
import site.steps.BrowserSteps;
import site.steps.MainPageSteps;
import site.steps.SearchResultPageSteps;
import site.steps.SearchSteps;

public class SearchForSomething_Test extends BaseTest {

    private BrowserSteps browserSteps;
    private MainPageSteps mainPageSteps;
    private SearchSteps searchSteps;
    private SearchResultPageSteps searchResultPageSteps;

    @Before
    public void setUp() {
        driver = WebDriverFactory.getDriverInstance();
        browserSteps = new BrowserSteps(driver);
        mainPageSteps = new MainPageSteps(driver);
        searchSteps = new SearchSteps(driver);
        searchResultPageSteps = new SearchResultPageSteps(driver);
    }

    @Test
    public void search_for_something() {

        // Open main page and maximize
        mainPageSteps.open();
        mainPageSteps.pageShouldBeOpened();
        browserSteps.maximize();

        // Set search field
        searchSteps.setSearch("Something");
        searchSteps.clickSearch();

        // Check result
        searchResultPageSteps.pageShouldBePresent();
    }
}