package DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    /**
     *  WebDriver instance to be used for testing. It is static to ensure
     *  only one instance of the driver is created and used across all tests.
     */
    public static WebDriver driverCreated;

    // Initializes and returns a WebDriver instance based on the provided browser name.
    public static WebDriver getDriver(String browser){
        try {
            if (driverCreated == null) { // Check if the driver is already initialized
                switch (browser.toUpperCase()) {
                    case "FIREFOX":
                        WebDriverManager.firefoxdriver().setup();
                        driverCreated = new FirefoxDriver();
                        driverCreated.manage().window().maximize();
                        break;
                    default: // Default to Chrome browser
                        WebDriverManager.chromedriver().setup();
                        driverCreated = new ChromeDriver();
                        driverCreated.manage().window().maximize();
                        break;
                }
            }
        }
        catch (Exception ex){
            System.out.println("Unable to initialize driver due to => "+ex.toString());
        }

        return driverCreated; // Return the initialized WebDriver instance
    }

    // Quits the WebDriver instance, closing the browser and ending the session.
    public static void quitDriver(){
        try {
            if (driverCreated != null) {
                driverCreated.quit();
                driverCreated = null;
            }
        }
        catch (Exception ex){
            System.out.println("Unable to close driver due to => "+ ex.toString());
        }
    }
}
