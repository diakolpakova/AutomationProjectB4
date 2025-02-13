package io.loop.test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class BrowserUtils {

    /**
     * validate if driver switched to expected url or title
     * @param driver
     * @param expectedUrl
     * @param expectedTitle
     * @author dk
     * implements seertion
     */
    public static void switchWindowAndValidate(WebDriver driver, String expectedUrl, String expectedTitle) {
       // to lowercase the params on order to avoid miss type
        expectedTitle = expectedTitle.toLowerCase();
        expectedUrl = expectedUrl.toLowerCase();

        // get all Windows Handles , switch one by one and each time check if the url matches expected to spot
        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles) {
            driver.switchTo().window(each);
            if (driver.getCurrentUrl().toLowerCase().contains(expectedUrl)) {
                break;
            }
        }

        // after stopping on expected url, validate the title
        assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));
    }

    /**
     * @param driver
     * @param targetTitle
     * @author dk
     */

    public static void switchToWindow(WebDriver driver, String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
        }

    /**
     * click any link from loop practice
     * @param nameOfPage
     * @author dk
     */

    public static void loopLinkClick(String nameOfPage) {

        WebElement element = Driver.getDriver().findElement(By.xpath("//a[.='"+nameOfPage+"']"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    /**
     * waits for provided element to be clickable
     * @param element
     * @param timeout
     * @return
     * @author dk
     */

    public static WebElement waitForClickable(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * waits for the provided element to be invisible on the page
     * @param element
     * @param timeToWaitInSec
     * @author nsh
     */
    public static void waitForInvisibility(WebElement element, int timeToWaitInSec){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * waits for the provided element to be visible
     * @param element
     * @param timeToWaitSec
     * @return
     * @author dk
     */

    public static WebElement waitForVisibility (WebElement element, int timeToWaitSec){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitSec));
        return wait.until(ExpectedConditions.visibilityOf(element));

    }

    /**
     * returns each name of the links
     * @param allLinks
     */
    public static void eachLink (List<WebElement> allLinks){
        for (WebElement eachLink : allLinks) {
            System.out.println(eachLink.getText());
        }


    }
}
