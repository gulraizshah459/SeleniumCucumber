package com.mercari.atuomation.Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import static DriverManager.DriverFactory.getDriver;
import static DriverManager.DriverFactory.quitDriver;

public class cucumberHooks {

    /**
     *  Executes before each scenario/test.
     *  Initializes the WebDriver with the Chrome browser.
     */
    @Before
    public static void before_scenario(){
         getDriver("chrome");
    }
    /**
     *  Executes after each scenario/test.
     *  Quits the WebDriver, closing the browser and ending the session.
     */
    @After
    public static void after_scenario(){
        quitDriver(); // Quit the driver
    }
}
