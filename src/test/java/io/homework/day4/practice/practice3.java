package io.homework.day4.practice;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class practice3  {
    /*
    go to https://demoqa.com/alerts
click - click button to see alert
handle alert
click - On button click, alert will appear after 5 seconds
handle alert
click - On button click, confirm box will appear
click ok and validate - You selected Ok
after that do it again this time cancel and validate - You selected Cancel
click - On button click, prompt box will appear
enter "Loop Academy" and validate You entered Loop Academy
     */
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://demoqa.com/alerts");
        WebElement ClickButtonToSeeAlert = driver.findElement(By.xpath("//button[@id='alertButton']"));
        ClickButtonToSeeAlert.click();
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        WebElement onButtonClick = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
        onButtonClick.click();
        Thread.sleep(6000);
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
    }

    @Test
    public void test3() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        WebElement confirmBoxButton = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        confirmBoxButton.click();
        driver.switchTo().alert().accept();

        WebElement textResultOk = driver.findElement(By.xpath("//span[@id='confirmResult']"));
        Assert.assertEquals(textResultOk.getText(), "You selected Ok", "The result is incorrect");
    }

    @Test
    public void test4() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        WebElement confirmBoxButton = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        confirmBoxButton.click();
        driver.switchTo().alert().dismiss();

        WebElement textResultCancel = driver.findElement(By.xpath("//span[@id='confirmResult']"));
        Assert.assertEquals(textResultCancel.getText(), "You selected Cancel", "The result is incorrect");
    }
    @Test
    public void test5() throws InterruptedException {

        driver.get("https://demoqa.com/alerts");
        Thread.sleep(5000);
        WebElement promptBoxButton = driver.findElement(By.xpath("//button[@id='promtButton']"));
        Thread.sleep(5000);
        promptBoxButton.click();

        String text ="Loop Academy";

        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();

        Thread.sleep(5000);

        WebElement successfulMessageForLoopAcademy = driver.findElement(By.xpath("//span[@id='promptResult']"));
        Assert.assertEquals(successfulMessageForLoopAcademy.getText(), "You entered Loop Academy", "The result is incorrect");

    }
}
