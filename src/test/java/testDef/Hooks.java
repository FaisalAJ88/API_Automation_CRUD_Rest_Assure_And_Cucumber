package testDef;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static helper.Utility.*;

public class Hooks {

    @BeforeAll
    public static void setUp() {
    }

    @AfterAll
    public static void tearDown() {

    }

    @Before
    public static void beforeTest() {
        startDriver();
    }

    @After
    public static void afterTest(Scenario scenario) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot");
        } else {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Screenshot");
            }
        quitDriver();
        }
    }