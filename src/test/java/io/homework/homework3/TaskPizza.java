package io.homework.homework3;

import io.loop.test.utilities.Driver;
import io.loop.test.utilities.PizzaOrderWebTableUtil;
import org.testng.annotations.Test;

import java.util.TreeMap;

import static org.testng.Assert.assertEquals;

public class TaskPizza {
    @Test
    public void taskPizza() throws InterruptedException {
        Driver.getDriver().get("https://loopcamp.vercel.app/web-tables.html");

        String name = "Ned Stark";
        String expectedType = "Italian";
        String actualType = PizzaOrderWebTableUtil.returnFieldValue(Driver.getDriver(),name, "Pizza type");
        assertEquals(actualType,expectedType,"Actual does not match expected");

        String expectedAmount = "5";
        String actualAmount = PizzaOrderWebTableUtil.returnFieldValue(Driver.getDriver(),name, "Amount");
        assertEquals(actualAmount, expectedAmount,"Actual does not match expected amount");

        String expectedDate = "05/12/2021";
        String actualDate = PizzaOrderWebTableUtil.returnFieldValue(Driver.getDriver(),name, "Date");
        assertEquals(actualDate, expectedDate,"Actual does not match expected date");

        String expectedStreet = "17, Rose Street";
        String actualStreet = PizzaOrderWebTableUtil.returnFieldValue(Driver.getDriver(),name, "Street");
        assertEquals(actualStreet, expectedStreet,"Actual does not match expected street");

        String expectedCity = "Newcastle";
        String actualCity = PizzaOrderWebTableUtil.returnFieldValue(Driver.getDriver(),name, "City");
        assertEquals(actualCity, expectedCity,"Actual does not match expected city");

        String expectedState = "Italy";
        String actualState = PizzaOrderWebTableUtil.returnFieldValue(Driver.getDriver(),name, "State");
        assertEquals(actualState, expectedState,"Actual does not match expected state");

        String expectedZip = "21444";
        String actualZip = PizzaOrderWebTableUtil.returnFieldValue(Driver.getDriver(),name, "Zip");
        assertEquals(actualZip, expectedZip,"Actual does not match expected zip");

        String expectedCard = "MasterCard";
        String actualCard = PizzaOrderWebTableUtil.returnFieldValue(Driver.getDriver(),name, "Card");
        assertEquals(actualCard, expectedCard,"Actual does not match expected card");

        String expectedCardNumber = "777888777888";
        String actualCardNumber = PizzaOrderWebTableUtil.returnFieldValue(Driver.getDriver(),name, "Card Number");
        assertEquals(actualCardNumber, expectedCardNumber,"Actual does not match expected card number");

        String expectedExp = "04/25";
        String actualExp = PizzaOrderWebTableUtil.returnFieldValue(Driver.getDriver(),name, "Exp");
        assertEquals(actualExp, expectedExp,"Actual does not match expected exp");






    }
}
