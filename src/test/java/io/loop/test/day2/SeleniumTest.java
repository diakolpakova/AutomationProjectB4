package io.loop.test.day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {


        // Setting up the web driver
        // WebDriverManager.chromedriver().setup();
        // if you use older version of selenium (4.21) you need webdrivermanager and boni garcia

        // create the instance of the driver
        WebDriver driver = new ChromeDriver();

        // Maximize the window
        driver.manage().window().maximize();
        //driver.manage().window().fullscreen();

        //navigate to web page
        driver.get("https://www.loopcamp.io");

        //wait
        Thread.sleep(3000);

        //navigate to the page
        driver.navigate().to("https://www.google.com");


        driver.navigate().back();

        driver.navigate().forward();

        driver.navigate().refresh();

        driver.quit();


    }
}
