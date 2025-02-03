package io.homework.homework2;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class practice1 extends TestBase {

   /* go to https://loopcamp.vercel.app/nested-frames.html
    validate "LEFT", "MIDDLE", "RIGHT", "BOTTOM"
    */

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement left = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        Assert.assertEquals(left.getText().trim(), "LEFT");

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement middle = driver.findElement(By.xpath("//*[@id='content']"));
        Assert.assertEquals(middle.getText().trim(), "MIDDLE");

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement right = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        Assert.assertEquals(right.getText().trim(), "RIGHT");

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        WebElement bottom = driver.findElement(By.xpath("//*[contains(text(),'BOTTOM')]"));
        Assert.assertEquals(bottom.getText().trim(), "BOTTOM");

    }
}
