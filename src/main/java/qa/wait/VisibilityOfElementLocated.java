package qa.wait;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

public class VisibilityOfElementLocated implements ExpectedCondition<Boolean> {

    private final By locator;

    public VisibilityOfElementLocated(By locator) {
        this.locator = locator;
    }

    @Override
    public Boolean apply(WebDriver driver) {
        try {
            List<WebElement> elements = driver.findElements(locator);
            return !elements.isEmpty() && elements.get(0).isDisplayed();
        } catch (StaleElementReferenceException | NoSuchElementException | ElementNotVisibleException | NullPointerException e) {
            return false;
        } catch (Throwable t) {
            throw new Error(t);
        }
    }
}
