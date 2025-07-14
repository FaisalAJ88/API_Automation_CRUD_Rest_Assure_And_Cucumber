import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.time.Duration;

public class testSelenium {

    public static WebDriver driver;

    public static void main(String[] args) {
        ChromeOptions options1 = new ChromeOptions();
        //FirefoxOptions options2 = new FirefoxOptions();
        //options.addArguments("--headless");
        options1.addArguments("--disable-dev-shm-usage");
        options1.addArguments("--remote-allow-origins=*");

        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.chromedriver().setup();
        //driver = new FirefoxDriver(options2);
        driver = new ChromeDriver(options1);
        driver.manage().window().maximize();
        driver.manage().timeouts().getImplicitWaitTimeout();

        driver.get("https://pintu.co.id/");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
