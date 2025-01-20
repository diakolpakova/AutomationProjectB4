package io.loop.test.day5;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TO_radioButton {

    public static void main(String[] args) {

        /*
        https://loopcamp.vercel.app/radio-buttons.html
        wait implicitly 10 seconds
        is selected
        is enable
         */

        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();
        driver.get("https://loopcamp.vercel.app/radio-buttons.html");

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);   --------> selenium 3

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //--------> selenium 4

        WebElement red = driver.findElement(By.xpath("//input[@id='red']"));
        WebElement green = driver.findElement(By.xpath("//input[@id='green']"));

         // is selected()
        System.out.println("red.isSelected() = " + red.isSelected());

        red.click();

        System.out.println("red.isSelected() = " + red.isSelected());

        green.click();

        System.out.println("green.isSelected() = " + green.isSelected());


        System.out.println("red.isEnabled() = " + red.isEnabled());
        System.out.println("green.isEnabled() = " + green.isEnabled());


    }

}
