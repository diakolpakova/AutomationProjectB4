package io.loop.test.day6;

import io.loop.test.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class T1_alerts extends TestBase {
    private static final Logger log = LoggerFactory.getLogger(T1_alerts.class);

        /*
    Information alert practice
    1. Open browser
    2. Go to website: https://loopcamp.vercel.app/javascript-alerts.html
    3. Click to “Click for JS Alert” button
    4. Click to OK button from the alert
    5. Validate “You successfully clicked an alert” text is displayed

    Confirmation alert practice
    1. Click to “Click for JS Confirm” button
    2. Click to OK button from the alert
    3. Verify “You clicked: Ok” text is displayed.
    4. Click to “Click for JS Confirm” button
    5. Click to Cancel button from the alert
    6. Validate “You clicked: Cancel” text is displayed.

    Prompt alert practice
    1. Click to “Click for JS Prompt” button
    2. Send "Loop Academy"
    3. Click Ok
    4. Validate "You entered: Loop Academy" text is displayed
     */

    @Test
    public void informationAlert() throws InterruptedException {

    driver.get("https://loopcamp.vercel.app/javascript-alerts.html");

    WebElement clickForJSAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
    clickForJSAlert.click();
    Thread.sleep(5000);
    Alert alert = driver.switchTo().alert();
    alert.accept();

    WebElement successfulMessageForInformationAlert = driver.findElement(By.xpath("//p[@id='result']"));
    String expected = "You successfully clicked an alert";
    String actual = successfulMessageForInformationAlert.getText();
    assertEquals(actual, expected, "Actual does not match the expected");
    }

    @Test
    public void confirmationAlert () throws InterruptedException {

        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickForJSConfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        clickForJSConfirm.click();

        driver.switchTo().alert().accept(); // will click on and accept the alert
        WebElement successfulMessageForConfirmationAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String expected = "You clicked: Ok";
        String actual = successfulMessageForConfirmationAlert.getText();
        assertEquals(actual, expected, "Actual does not match the expected");

        clickForJSConfirm.click();
        driver.switchTo().alert().dismiss(); // will click cancel - will dismiss the alert
        expected = "You clicked: Cancel";
        actual = successfulMessageForConfirmationAlert.getText();
        assertEquals(actual, expected, "Actual does not match the expected");
    }

    @Test
    public void promptAlert () throws InterruptedException {
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickForJSPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        clickForJSPrompt.click();

        String text = "Loopcamp";

        /*
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();
        */

        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();

        WebElement successfulMessageForPrompt = driver.findElement(By.xpath("//p[@id='result']"));
        String actual = successfulMessageForPrompt.getText();
        String expected = "You entered: " + text;
        assertEquals(actual,expected, "Actual does not match expected");

        clickForJSPrompt.click();
        alert.sendKeys(text);
        alert.dismiss();
        actual = successfulMessageForPrompt.getText();
        expected = "You entered: " + null;
        assertEquals(actual,expected, "Actual does not match expected");


    }

}

