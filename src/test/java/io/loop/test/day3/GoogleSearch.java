package io.loop.test.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    public static void main(String[] args) {


        //create driver object
        WebDriver driver = new ChromeDriver();

        // navigate to google
        driver.navigate().to("https://www.google.com/");

        // lets maximize
        driver.manage().window().maximize();

        String expectedTitle = "Google";

        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Actual title: " + actualTitle + ", matches expected title: " + expectedTitle + ". => TEST PASS");
        } else {
            System.out.println("Actual title: " + actualTitle + ",  DOES NOT match expected title: " + expectedTitle + ". => TEST FAIL");

        }

        String expectedUrl = "https://www.google.com/";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)) {
            System.out.println("Actual url: " + actualUrl + ", matches expected url: " + expectedUrl + ". => TEST PASS");
        } else {
            System.out.println("Actual url: " + actualUrl + ",  DOES NOT match expected url: " + expectedUrl + ". => TEST FAIL");
        }
        driver.quit();
    }
}

