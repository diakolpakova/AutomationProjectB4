package io.homework.day4.practice;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkbox {
    public static void main(String[] args) throws InterruptedException {

/*https://loopcamp.vercel.app/
Go to Autocomplete
Type in County - United States of America
Click button Submit
Verify that you selected United States of America

 */
         WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
         driver.manage().window().maximize();
         driver.get("https://loopcamp.vercel.app/");

         // inspect autocomplete
        WebElement autoCompleLink = driver.findElement(By.xpath("//a[@href='autocomplete.html']"));
        autoCompleLink.click();
 Thread.sleep(10000);
        // Type in County - United States of America
        WebElement input = driver.findElement(By.xpath("//input[@id='myCountry']"));
        input.sendKeys("United States of America");
Thread.sleep(10000);
        // Click button Submit
        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));
        submitButton.click();

        // Verify that you selected United States of America
        WebElement checkbox = driver.findElement(By.xpath("//p[@id='result']"));

        if (checkbox.isDisplayed()) {
            System.out.println("WebElement \"You selected: United States of America\" is displayed");
        } else {
            System.out.println("WebElement \"You selected: United States of America\" is DOES NOT displayed");
        }
    }
}
