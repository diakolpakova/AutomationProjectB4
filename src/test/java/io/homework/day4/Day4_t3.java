package io.homework.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day4_t3 {
    public static void main(String[] args) {

        /*Practice tasks
==============

task 1
=============
1. go to https://loopcamp.vercel.app/forgot-password.html
2. locate 5 elements, forgot password, email, email input, retrieve password, powered by LOOPCAMP
3. use css
4. Validate those elements are displayed
*/

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://loopcamp.vercel.app/forgot-password.html");

        WebElement forgotPassword = driver.findElement(By.cssSelector("div[class='example']>h2"));
        System.out.println("forgotPassword.getText() = " + forgotPassword.isDisplayed());
        if (forgotPassword.isDisplayed()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        WebElement email = driver.findElement(By.cssSelector("label[for='email']"));
        System.out.println("email.getText() = " + email.isDisplayed());
        if (email.isDisplayed()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }


        WebElement emailInput = driver.findElement(By.cssSelector("input[id='email']"));
        System.out.println("emailInput.getText() = " + emailInput.isDisplayed());
        if (emailInput.isDisplayed()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }


        WebElement retrievePassword = driver.findElement(By.cssSelector("button#form_submit"));
        System.out.println("retrievePassword.getText() = " + retrievePassword.isDisplayed());
        if (retrievePassword.isDisplayed()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }


        WebElement poweredByLoopcamp = driver.findElement(By.cssSelector("div[style='text-align: center;']"));
        System.out.println("poweredByLoopcamp.getText() = " + poweredByLoopcamp.isDisplayed());
        if (poweredByLoopcamp.isDisplayed()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }



    }
}

