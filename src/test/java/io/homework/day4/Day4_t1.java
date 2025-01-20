package io.homework.day4;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Day4_t1 {
    public static void main(String[] args) {
/*
Task 1
================
1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Validate title contains:
Expected: Gmail
5- Go back to Google by using the .back();
6- Validate title equals:
Expected: Google
 */

        // 1- Open a Chrome browser
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();

        // 2- Go to: https://google.com
        driver.get("https://www.google.com");

        // 3- Click to Gmail from top right.
        WebElement gMailButton = driver.findElement(By.xpath("//a[contains(.,'Gmail')]"));
        gMailButton.click();

        // 5- Go back to Google by using the .back();
        driver.navigate().back();

        //6- Validate title equals: (Expected: Google)
        String title = driver.getTitle();
        //System.out.println(title);

        if (title.equals("Google")) {
            System.out.println("title = test passed. " + title + " is correct title");
        } else {
            System.out.println("title = test failed. " + title + " is NOT correct title");
        }

        //driver.quit();
    }
}

