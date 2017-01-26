package site.steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Common Steps
 */
public class Steps {

    private static final Logger LOGGER = Logger.getLogger(SearchSteps.class.getName());

    private WebDriver driver;

    public Steps(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Log info Step start message
     * @param stepName step name
     */
    public void logStepStart(String stepName) {
        LOGGER.info("Step started: " + stepName);
    }
}
