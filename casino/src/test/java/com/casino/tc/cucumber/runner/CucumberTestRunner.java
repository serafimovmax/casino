package com.casino.tc.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    plugin = "pretty",
    monochrome = true,
    tags = "",
    glue = "com/casino/tc/cucumber/steps", //!!!!!
    features = "src/test/resources/feature" //!!!!!
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
