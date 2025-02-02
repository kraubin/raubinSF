package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",  // Path to the feature files
        glue = "steps",   // Path to step definitions
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"},  // Reporting
        monochrome = true,
        tags = "@regression"  // Optional: You can use tags to filter which tests to run
)
public class TestRunner {
}