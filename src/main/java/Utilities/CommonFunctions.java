package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import static DriverManager.DriverFactory.driverCreated;


public class CommonFunctions {
    //Waits for an element to be displayed (present and visible) on the page.
    public static Boolean waitUntilElementDisplayed(By element, int timeOut) {
        Boolean flag = false;
        try {
            // Configure a FluentWait instance
            Wait<WebDriver> wait = new FluentWait<>(driverCreated).withTimeout(Duration.ofSeconds(timeOut))
                    .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
            boolean aboutMe = wait.until(new Function<WebDriver, Boolean>() {

                public Boolean apply(WebDriver driver) {
                    System.out.println("Loading Element of "+element);
                    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                    // Check if the element is present and displayed
                    if(driver.findElement(element)!=null && driver.findElement(element).isDisplayed()){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
            });
            if (aboutMe == false) {
                flag = false;
            } else {
                flag = true;
            }
        }
        catch(Exception e) {
            flag=false;

        }
        return flag;
    }

    // Waits for an element to be selected (for checkboxes or radio buttons).
    public static Boolean waitUntilElementSelected(By element, int timeOut) {
        Boolean flag = false;
        try {
            // Configure a FluentWait instance
            Wait<WebDriver> wait = new FluentWait<>(driverCreated).withTimeout(Duration.ofSeconds(timeOut))
                    .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
            boolean aboutMe = wait.until(new Function<WebDriver, Boolean>() {

                public Boolean apply(WebDriver driver) {
                    System.out.println("Loading Element of "+element);
                    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                    // Check if the element is present and selected
                    if(driver.findElement(element)!=null && driver.findElement(element).isSelected()){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
            });
            if (aboutMe == false) {
                flag = false;
            } else {
                flag = true;
            }
        }
        catch(Exception e) {
            flag=false;

        }
        return flag;
    }
    //Waits for an element to be present in the DOM.
    public static void waitForElementRendering(By element){
        WebDriverWait wait = new WebDriverWait(driverCreated, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }
}
