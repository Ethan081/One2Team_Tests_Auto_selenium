package org.one2Team;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {"pretty", "html:target/html/results.html"},
        features = {"src/test/java/org/one2Team/"},
        glue = {""},
        tags = "@home"
)

public class AppTest 
{

}
