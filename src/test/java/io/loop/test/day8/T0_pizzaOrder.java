package io.loop.test.day8;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.Driver;
import io.loop.test.utilities.PizzaOrderWebTableUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;
public class T0_pizzaOrder  {

    /*go to https://loopcamp.vercel.app/web-tables.html
create a method to test given field for a given name
test type
test amount
test date
test street
test city
test state
test zip
test card
test card number
test exp
*/
    WebDriver driver;
    @Test
    public void test_pizza_type(){

        Driver.getDriver().get("https://loopcamp.vercel.app/web-tables.html");
        String name = "Samuel Jackson";
        String expectedPizzaType = "Italian";
        String actualPizzaType = PizzaOrderWebTableUtil.returnFieldValue(Driver.getDriver(), name, "pizza type");

        System.out.println("actualPizzaType = " + actualPizzaType);

        assertEquals(actualPizzaType, expectedPizzaType, "Actual does not match expected");
    }

}
