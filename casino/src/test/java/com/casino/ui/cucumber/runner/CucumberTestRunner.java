package com.casino.ui.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    plugin = "pretty",
    monochrome = true,
    tags = "",
    glue = "com/casino/ui/cucumber/steps",
    features = "src/test/resources/ui/feature"
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
