package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/web.feature",
        glue = "testDef",
        plugin = {"pretty", "html:target/testing-reports.html"},
        tags = "@test",
        monochrome = true
)

public class CucumberTestRunner {
}
