package io.loop.test.day9;

import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class T1_actions_hoverOver {

    @Test
    public void google_action_hover() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperties("google.url"));
        WebElement googleSearch = Driver.getDriver().findElement(By.xpath("//input[@id='gbqfbb']/preceding-sibling::input"));
        WebElement feelingLucky = Driver.getDriver().findElement(By.xpath("//input[@id='gbqfbb']"));

        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(googleSearch).perform();

        Thread.sleep(2000);

        actions.moveToElement(feelingLucky).perform();

        actions.sendKeys(Keys.F12).perform();
        actions.sendKeys(Keys.F5).perform();

    }

}
