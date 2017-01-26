package site.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;
import site.elements.SearchElement;

import static org.junit.Assert.assertTrue;

/**
 * Steps for Search Form
 */
public class SearchSteps extends Steps{

    private SearchElement searchFormElement;

    public SearchSteps(WebDriver driver) {
        super(driver);
        searchFormElement = PageFactory.initElements(driver, SearchElement.class);
    }

    /**
     * Check is form is present
     */
    @Step
    public void searchFormShouldBePresent() {
        logStepStart("Search Form should be present");
        assertTrue("Search Form should be present",
                searchFormElement.isFormPresent());
    }

    /**
     * Set search field
     * @param s value
     */
    @Step
    public void setSearch(String s) {
        logStepStart(String.format("Set search field to <%s>", s));
        searchFormElement.setSearchField(s);

    }

    /**
     * Click search button
     */
    @Step
    public void clickSearch() {
        logStepStart("Click Search");
        searchFormElement.clickSearch();
    }
}
