package site;

import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Attachment;

/**
 * Base Test
 */
public class BaseTest {

    protected WebDriver driver;

    @Rule
    public TestWatcher screenshotOnFailure = new TestWatcher() {

        @Override
        protected void failed(Throwable e, Description description) {
            makeScreenshotOnFailure();
        }

        @Override
        protected void finished(Description description) {
            tearDown();
        }

        @Attachment("Screenshot on failure")
        protected byte[] makeScreenshotOnFailure() {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
    };

    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
