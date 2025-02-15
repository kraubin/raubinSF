package runners;

import io.cucumber.junit.Cucumber;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        plugin = {
                "pretty",
                "json:build/reports/cucumber/cucumber.json",
                "message:build/reports/cucumber/cucumber.ndjson",
                "html:build/reports/cucumber/cucumber-html-reports"
        }
)
public class TestRunner {
}

