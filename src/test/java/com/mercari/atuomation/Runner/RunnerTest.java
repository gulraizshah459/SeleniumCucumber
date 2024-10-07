package com.mercari.atuomation.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


//This is the Cucumber test runner class. It is responsible for execution
@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.mercari.atuomation"},
        plugin = {"json:target/cucumber.json"},
        features = {"src/test/resources/Features"}
)
public class RunnerTest {
}
