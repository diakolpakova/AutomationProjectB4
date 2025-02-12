package io.homework.homework3;

import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TaskPizza2 {
    @Test
    public void taskPizza() {

        List <WebElement> names = Driver.getDriver().findElements(By.xpath(" //td[1]/following-sibling::td[1]"));
        System.out.println(names);

        for (WebElement name : names) {
            if (name.getText().contains("Bob K")) {
                System.out.println();
            }
        }

    }
}
