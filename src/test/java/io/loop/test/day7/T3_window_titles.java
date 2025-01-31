package io.loop.test.day7;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.BrowserUtils;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.Set;

public class T3_window_titles extends TestBase {

    @Test
    public void windowHandleTitle() {

    driver.get("http://www.google.com");

    driver.switchTo().newWindow(WindowType.TAB);
    driver.get("https://www.loopcamp.io");

    driver.switchTo().newWindow(WindowType.TAB);
    driver.get("http://www.amazon.com");

    driver.switchTo().newWindow(WindowType.TAB);
    driver.get("https://www.facebook.com");

    System.out.println(driver.getTitle());
//
//    Set<String> windowHandles = driver.getWindowHandles();
//    for (String window : windowHandles) {
//        driver.switchTo().window(window);
//        if (driver.getTitle().contains("Google")) {
//            break;
//        }
//    }
        //BrowserUtils.switchWindowAndValidate(driver, "loopcamp.io", "loopcamp");

        BrowserUtils.switchToWindow(driver, "Google");
        }
    }
