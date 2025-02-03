package io.homework.homework2;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertEquals;

public class practice2 extends TestBase {
    /*task2
=============
go to https://loopcamp.vercel.app/
click "Multiple Windows" link
Validate "Powered by Loopcamp" is displayed
Validate title is "Windows"
Click - click here
Switch to new window and validate title
*/

    @Test
    public void practiceTask2() {
        driver.get("https://loopcamp.vercel.app/");

        WebElement multipleWindowsLink = driver.findElement(By.xpath("//a[@href='windows.html']"));
        multipleWindowsLink.click();

        WebElement poweredByLoopcamp = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        if (poweredByLoopcamp.isDisplayed()) {
            System.out.println(poweredByLoopcamp.getText() + " is displayed");
        } else {
            System.out.println(poweredByLoopcamp.getText() + " is not displayed");
        }

        System.out.println("driver.getTitle() = " + driver.getTitle());
        assertEquals(driver.getTitle(), "Windows", "Windows title is not displayed");

        WebElement clickHere = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
        clickHere.click();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String window : windowHandles) {
            driver.switchTo().window(window).getTitle(); {
                if (driver.getTitle().equals("Windows")) {
                    continue;
                } else {
                    System.out.println("driver.getTitle() = " + driver.getTitle());
                }


            }
        }
    }
}