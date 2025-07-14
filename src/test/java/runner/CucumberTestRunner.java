package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "testDef",
        plugin = {"pretty", "html:target/cucumber-api-reports.html"},
        tags = "@api",
        monochrome = true
)

public class CucumberTestRunner {
}
