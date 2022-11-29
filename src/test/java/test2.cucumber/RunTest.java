package test2.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"pretty"},
features = {"src/test/resources/features"},
glue = {"test2.cucumber.steps"})
public class RunTest extends AbstractTestNGCucumberTests {
}
