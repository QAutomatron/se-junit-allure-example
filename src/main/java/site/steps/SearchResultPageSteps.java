package site.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;
import site.pages.SearchResultPage;

import static org.junit.Assert.assertTrue;

/**
 * Steps for Search Result Page
 */
public class SearchResultPageSteps extends Steps {

    private SearchResultPage searchResultPage;

    public SearchResultPageSteps(WebDriver driver) {
        super(driver);
        searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
    }

    /**
     * Check that page opened
     */
    @Step
    public void pageShouldBePresent() {
        logStepStart("Search Result page should be opened");
        assertTrue("Search Result page should be opened",
                searchResultPage.isPageOpened());
    }
}
