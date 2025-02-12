package io.homework.homework3;

import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task2 {
    /*
    task1
Open a chrome browser
Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
Click and hold small circle
Move it on top of the big circle
validate “Now drop…” text appears on big circ
     */
    @Test
    public void test1() throws InterruptedException {
        Driver.getDriver().get("https://loopcamp.vercel.app/drag-and-drop-circles.html");
        WebElement smallCircle = Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));

        WebElement bigCircle = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));

        Actions actions = new Actions(Driver.getDriver());

        actions.clickAndHold(smallCircle).perform();

        actions.moveToElement(bigCircle).perform();

        Thread.sleep(3000);
        String actual = bigCircle.getText();
        String expected = "Now drop...";
        assertEquals(actual, expected, "does not match");

        // WebElement a = Driver.getDriver().findElement(By.xpath("//div[text()='You did great!']"));
    }

        @Test
    public void test2() throws InterruptedException {
        /*
        task2
1. Open a chrome browser
2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
3. Click and hold small circle
4. Dropped anywhere outside of big circle
5. validate “Try again!” text appears on big circle
         */
            Driver.getDriver().get("https://loopcamp.vercel.app/drag-and-drop-circles.html");
            WebElement smallCircle = Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));
            WebElement dropTarget = Driver.getDriver().findElement(By.xpath("//div[@id='flash-messages']"));

            Actions actions = new Actions(Driver.getDriver());
            actions.dragAndDrop(smallCircle, dropTarget).perform();

            Thread.sleep(3000);
            String actual = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']")).getText();
            String expected = "Try again!";
            assertEquals(actual, expected, "does not match");




    }
}
