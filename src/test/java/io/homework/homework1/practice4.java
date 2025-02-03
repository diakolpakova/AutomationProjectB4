package io.homework.homework1;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class practice4 {
    /*
go to https://demoqa.com/nestedframes
Validate "Child Iframe" text
Validate "Parent Iframe" text
Validate the "Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame."
     */
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void afterMethod() {
        //driver.close();
    }

    @Test
    public void iframe1() throws InterruptedException {

        driver.get("https://demoqa.com/nestedframes");

        driver.switchTo().frame(driver.findElement(By.id("frame1")));
        driver.switchTo().frame(0);

        WebElement childIframeText = driver.findElement(By.xpath("//*[contains(text(),'Child Iframe')]"));
        Assert.assertEquals(childIframeText.getText(), "Child Iframe", "Actual does not match expected");

        driver.switchTo().parentFrame();
        Thread.sleep(5000);
        WebElement parentFrame = driver.findElement(By.xpath("//body[.='Parent frame']"));
        Thread.sleep(5000);
        Assert.assertEquals(parentFrame.getText(), "Parent frame", "Actual does not match expected");

        driver.switchTo().defaultContent();
        WebElement nextedText = driver.findElement(By.xpath("//div[contains(text(),'Sample Nested Iframe page.')]"));

        driver.switchTo().defaultContent();
        WebElement nestedText = driver.findElement(By.xpath("//div[contains(text(), 'Sample Nested Iframe page.')]"));

        Assert.assertEquals(nestedText.getText(), "Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame.","Our actual text nested does not match our expected" );

    }
}
