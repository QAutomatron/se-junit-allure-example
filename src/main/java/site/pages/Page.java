package site.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa.wait.InvisibilityOfElement;
import qa.wait.VisibilityOfElement;
import qa.wait.VisibilityOfElementLocated;

import java.util.concurrent.TimeUnit;

/*
 * Abstract Page. Page object pattern
 */
public class Page {

    private WebDriver driver;
    private final String baseUrl = System.getProperty("webdriver.base.url");
    private final int implicitWait = Integer.parseInt(System.getProperty("webdriver.timeouts.implicitlywait"));

    public Page(WebDriver driver) {
        this.driver = driver;
    }

	public WebDriver getDriver() {
		return driver;
	}

    /**
     * Open inner path of site
     * @param s inner path
     */
    protected void openAt(String s) {
        driver.get(baseUrl + s);
    }

    /**
     * Set implicitly wait in second
     * @param second time in seconds
     */
    private void setImplicitTimeout(int second) {
        driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
    }

    /**
     * Reset implicitly wait to default
     */
    private void resetImplicitTimeout() {
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
    }

    /**
     * Wait until element is present
     * @param element element
     * @return boolean
     */
    protected boolean waitForElementPresent(WebElement element) {
        setImplicitTimeout(0);
        Boolean result = true;
        WebDriverWait wait = new WebDriverWait(driver, implicitWait, 500);
        try {
            wait.until(new VisibilityOfElement(element));
        } catch (TimeoutException e) {
            result = false;
        } catch (Throwable t) {
            throw new Error(t);
        } finally {
            resetImplicitTimeout();
        }
        return result;
    }

    /**
     * Wait until element not present
     * @param element element
     * @return boolean
     */
    protected boolean waitForElementNotPresent(WebElement element) {
        setImplicitTimeout(0);
        Boolean result = true;
        WebDriverWait wait = new WebDriverWait(driver, implicitWait, 500);
        try {
            wait.until(new InvisibilityOfElement(element));
        } catch (TimeoutException e) {
            result = false;
        } catch (Throwable t) {
            throw new Error(t);
        } finally {
            resetImplicitTimeout();
        }
        return result;
    }

    /**
     * Wait for element invisibility
     * @param by element locator
     * @return boolean
     */
    protected boolean waitForElementNotPresent(By by) {
        setImplicitTimeout(0);
        Boolean result = true;
        WebDriverWait wait = new WebDriverWait(driver, implicitWait, 500);
        try {
            wait.until(new VisibilityOfElementLocated(by));
        } catch (TimeoutException e) {
            result = false;
        } catch (Throwable t) {
            throw new Error(t);
        } finally {
            resetImplicitTimeout();
        }
        return result;
    }

    /**
     * Wait until element present by locator
     * @param locator locator
     * @return boolean
     */
    protected boolean waitForElementPresent(By locator) {
        setImplicitTimeout(0);
        Boolean result = true;
        WebDriverWait wait = new WebDriverWait(driver, implicitWait, 500);
        try {
            wait.until(new VisibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            result = false;
        } catch (Throwable t) {
            throw new Error(t);
        } finally {
            resetImplicitTimeout();
        }
        return result;
    }

    /**
     * Type string into element
     * @param element element
     * @param s string
     */
    protected void typeInto(WebElement element, String s) {
        element.clear();
        element.sendKeys(s);
    }

    /**
     * Get attribute "value" of the element
     * @param element element
     * @return value
     */
    protected String getValue(WebElement element) {
        return element.getAttribute("value");
    }

    /**
     * Get WebElement
     */
    protected WebElement $ (By by) {
        return getDriver().findElement(by);
    }

    /**
     * Wait some time
     * @param timeout time
     */
    protected void waitABit(Integer timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            throw new Error(e);
        }
    }
}
