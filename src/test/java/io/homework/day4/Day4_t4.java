package io.homework.day4;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Day4_t4 {
    public static void main(String[] args) throws InterruptedException {
        /*
task 2
=============
1. login to docuport application
2. logout from docuport application
3. Validate successful login
4. Validate successful logout
         */


        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();

        driver.get(DocuportConstants.DOCUPORT_TEST);

        WebElement userName = driver.findElement(By.id("input-14"));
        userName.sendKeys((DocuportConstants.USERNAME_CLIENT));

        Thread.sleep(5000);

        WebElement password = driver.findElement(By.id("input-15"));
        password.sendKeys("Group1");

        Thread.sleep(5000);


        WebElement login = driver.findElement(By.className("v-btn__content"));
        login.click();

        Thread.sleep(5000);

        WebElement continueButton = driver.findElement(By.cssSelector("button[type=submit]"));
        Thread.sleep(5000);
        continueButton.click();

        WebElement b1g1 = driver.findElement(By.cssSelector("div[class='v-avatar primary']"));
        b1g1.click();

        WebElement logoutButton = driver.findElement(By.xpath("//span[.='Log out']"));
        logoutButton.click();

        Thread.sleep(10000);

        //WebElement docuportLogin = driver.findElement(By.cssSelector("h1[class='text-h5 font-weight-medium mb-6']"));
        WebElement docuportLogin = driver.findElement(By.xpath("//h1[@class='text-h5 font-weight-medium mb-6']"));

        if (docuportLogin.isDisplayed()) {
            System.out.println("Test passed. You successful log in");
        }else {
            System.out.println("Test failed. You failed to log in");
        }

        Thread.sleep(3000);

       // driver.quit();


    }
}
