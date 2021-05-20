import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestYandex {

    static WebDriver driver;

    @BeforeAll
    static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);




    }

    @Test
    @DisplayName("Негативный тест")
    void testNotAvt() {
        driver.get("https://yandex.ru");
        WebElement clickLog = driver.findElement(By.xpath("//div[text()='Войти']"));
        clickLog.click();

        WebElement clickNotFill = driver.findElement(By.xpath("//button[@type='submit']"));
        clickNotFill.click();

        WebElement visibleText = driver.findElement(By.xpath("//div[@class='Textinput-Hint Textinput-Hint_state_error']"));
        Assertions.assertNotNull(visibleText.getText());

    }

    @AfterAll
    static void closeChrome() {
        driver.close();
    }
}
