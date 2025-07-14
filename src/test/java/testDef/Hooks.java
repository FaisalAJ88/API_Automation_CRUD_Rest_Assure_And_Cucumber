package testDef;

import io.cucumber.java.*;

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
    public static void afterTest() throws InterruptedException {
       // takeScreenshot();
        Thread.sleep(2000);
        quitDriver();

    }
}