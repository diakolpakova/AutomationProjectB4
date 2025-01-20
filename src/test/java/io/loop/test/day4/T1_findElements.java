package io.loop.test.day4;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T1_findElements {

    /*
    1. Open Chrome
    2. go to www.nba.com
    3. locate all the links in the page
     */
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();
        driver.get("https://www.nba.com");


       //Thread.sleep(5000);   it will wait all 5 seconds

      //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // old selenium before selenium 4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // new selenium

        List<WebElement> nbaLinks = driver.findElements(By.tagName("a"));
        System.out.println("nbaLinks.size() = " + nbaLinks.size());

        List<WebElement> nbaLinksWithXpath = driver.findElements(By.xpath("//a"));
        System.out.println("nbaLinksWithXpath.size() = " + nbaLinksWithXpath.size());

        for (WebElement nbaLink : nbaLinks) {
            if (!nbaLink.getText().equals("")) {
                System.out.println("nbaLink.getText() = " + nbaLink.getText());
                System.out.println("nbaLink.getDomAttribute(\"href\") = " + nbaLink.getDomAttribute("href"));
            }
        }

        for (int i = 0; i < nbaLinks.size(); i++) {
            if (!nbaLinks.get(i).getText().equals("")) {
                System.out.println("nbaLinks.get(i).getText() = " + nbaLinks.get(i).getText());
                System.out.println("nbaLinks.get(i).getDomAttribute(\"href\") = " + nbaLinks.get(i).getDomAttribute("href"));
            }
        }
    }
}
