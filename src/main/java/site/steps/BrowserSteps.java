package site.steps;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Steps for browser
 */
public class BrowserSteps extends Steps {

    public BrowserSteps(WebDriver driver) {
        super(driver);
    }

    /**
     * Maximize browser
     */
    @Step
    public void maximize() {
        logStepStart("Maximize browser");
        getDriver().manage().window().maximize();
    }
}
