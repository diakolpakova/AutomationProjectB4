package io.homework.day4;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Day4_t2 {
    public static void main(String[] args) {

        /*Task 2
        ================
        1. Open Chrome browser
        2. Go to https://www.etsy.com
        3. Search for “wooden spoon”
        4. Validate title:
        Expected: “Wooden spoon | Etsy”

         */
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        // 1. Open Chrome browser
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // 2. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");

        // 3. Search for “wooden spoon”
        WebElement search = driver.findElement(By.id("global-enhancements-search-query"));
        search.click();

        WebElement searchClick = driver.findElement(By.name("search_query"));
        search.sendKeys("wooden spoon");

        WebElement searchButton = driver.findElement(By.id("gnav-search-submit-button"));
        searchButton.click();


        String title = driver.getTitle();
        //System.out.println(title);

        if (title.equals("Wooden spoon | Etsy")) {
            System.out.println("title = test passed. " + title + " is correct title");
        } else {
            System.out.println("title = test failed. " + title + " is NOT correct title");
        }


    }
}
