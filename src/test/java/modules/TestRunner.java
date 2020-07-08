package modules;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {"pretty", "html:target/html/results.html"},
        features = {"src/test/resources/features"},
        glue = {"step_definition", "modules"},
        tags = "@home"
)
public class TestRunner {
    //Todo: create test run configuration
}
