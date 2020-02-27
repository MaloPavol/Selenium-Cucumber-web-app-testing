package test_runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src//test//resources//tested_features"},
        glue = {"step_definition"}
)
public class TestRunner {
    public TestRunner() {
    }
}