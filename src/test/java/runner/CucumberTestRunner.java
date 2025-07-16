package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/web.feature",
        glue = "testDef",
        plugin = {"pretty", "html:reports/testing-reports.html"},
        tags = "@api",
        monochrome = true
)

public class CucumberTestRunner {
}
