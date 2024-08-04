package uitestlab.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = {"uitestlab.Steps"}, tags = "@regression", dryRun = false,
        plugin = {"pretty", "html:target/cucumber-reports.html"})
public class TestRunner {
}

