package io.loop.test.day9;

import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class T3_JSExecutor_scroll {
    /*
/*
Go to https://www.nordstromrack.com/
Scroll down
Generate random email and enter into sign up box
Click on sign up
Verify "you are in" is displayed
*/

    @Test
    public void nordstrom_scroll() {
        Driver.getDriver().get("https://www.nordstromrack.com/");

        WebElement box = Driver.getDriver().findElement(By.xpath("//input[@name='email-module-input']"));
        WebElement signUpButton = Driver.getDriver().findElement(By.xpath("//button[contains(text(),'Sign up')]"));

        // how to scroll
        // #1 use actions class move to element

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(box).perform();



    }

}
