package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        plugin = {
                "pretty",
                "json:build/reports/cucumber/cucumber.json", // Ensures JSON output
                "html:build/reports/cucumber/cucumber-html-reports",
                "message:build/reports/cucumber/cucumber.ndjson"
        },
        monochrome = true
)
public class TestRunner {
}



