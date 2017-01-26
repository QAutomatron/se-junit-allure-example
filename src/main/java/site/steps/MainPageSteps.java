package site.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;
import site.pages.MainPage;

import static org.junit.Assert.assertTrue;

/**
 * Steps for Main Page
 */
public class MainPageSteps extends Steps{

    private MainPage mainPage;

    public MainPageSteps(WebDriver driver) {
        super(driver);
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    /**
     * Open Main Page
     */
    @Step
    public void open() {
        logStepStart("Open Main Page");
        mainPage.open();
    }

    /**
     * Main Page Should Be Opened
     */
    @Step
    public void pageShouldBeOpened() {
        logStepStart("Main Page Should Be Opened");
        assertTrue("Main Page should be opened",
                mainPage.isPageOpened());
    }
}
