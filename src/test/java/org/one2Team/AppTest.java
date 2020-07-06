package org.one2Team;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {"pretty", "html:target/html/results.html"},
        features = {"src/test/java/org/one2Team/"},
        glue = {"org.one2Team"},
<<<<<<< HEAD
        tags = "@board"
=======
        tags = "@home "
>>>>>>> 75aa3dd85fad6f6da6ddaef98336025a09f4c7f3
)

public class AppTest 
{

}
