package io.homework.day4.practice;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    public void iframe1() {

        driver.get("https://demoqa.com/nestedframes");

        driver.switchTo().parentFrame();
        driver.switchTo().frame("<p>Child Iframe</p>");

        WebElement childIframeText = driver.findElement(By.xpath("//*[contains(text(),'Child Iframe')]"));
        String actualChildFrame = childIframeText.getText();
        assertEquals(actualChildFrame.trim(), "Child Iframe");
    }
}
