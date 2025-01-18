package io.homework.day4;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Day4_t5 {
    public static void main(String[] args) throws InterruptedException {

        /*
task 3
=============
1. navigate to docuport application
2. validate placeholders for user name and password
3. without sending username and password click login button
4. validate username and password error messages
         */
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();

        driver.get(DocuportConstants.DOCUPORT_TEST);

        //WebElement userName = driver.findElement(By.xpath("//input[@id='input-14']"));
        //WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        WebElement userName = driver.findElement(By.xpath("//input[contains(@type,'text')]"));
        if (userName.isDisplayed())
        {System.out.println("passed");
        } else {System.out.println("failed"); }

        //WebElement password = driver.findElement(By.xpath("//input[@id='input-15']"));
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        if (password.isDisplayed())
        {System.out.println("passed");
        } else { System.out.println("failed");}

        //WebElement login = driver.findElement(By.xpath("//span[@class='v-btn__content']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        if (loginButton.isDisplayed()) {System.out.println("passed");
        } else {System.out.println("failed"); }

        //WebElement userNameErrorMessage = driver.findElement(By.cssSelector("div[class='v-messages__wrapper']>div"));
        //WebElement userNameErrorMessage = driver.findElement(By.xpath("//div[text()='Please enter your username or email address']"));
        WebElement userNameErrorMessage = driver.findElement(By.xpath("//div[contains(text(), 'password')]"));
        //WebElement passwordErrorMessage = driver.findElement(By.cssSelector("div[class='v-messages__wrapper']>div"));
        WebElement passwordErrorMessage = driver.findElement(By.xpath("//div[text()='Please enter your password']"));

        if (userNameErrorMessage.isDisplayed() && passwordErrorMessage.isDisplayed())
        {System.out.println("passed");
        }  else {System.out.println("failed");
        }

        Thread.sleep(4000);
        driver.quit();
    }
}
