import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestYandex {

    static WebDriver driver;

    @BeforeAll
    static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    @DisplayName("Негативный тест")
    void testNotAvt() throws InterruptedException {
        driver.get("https://yandex.ru");
        WebElement clickLog = driver.findElement(By.xpath("//div[text()='Войти']"));
        clickLog.click();

        WebElement clickNotFill = driver.findElement(By.xpath("//button[@type='submit']"));
        clickNotFill.click();

        WebElement visibleText = driver.findElement(By.xpath("//div[@class='Textinput-Hint Textinput-Hint_state_error']"));
        Assertions.assertEquals(visibleText.getText(),"Логин не указан");
    }

    @AfterAll
    static void closeChrome() {
        driver.close();
    }
}
