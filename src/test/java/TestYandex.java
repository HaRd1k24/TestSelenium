import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;


public class TestYandex {
    static final String url = "https://yandex.ru";
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeAll
    static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,10,200);


    }

    @Test
    @DisplayName("Негативный тест")
    void testNotAvt() {
        driver.get(url);
        WebElement clickLog = driver.findElement(By.xpath("//div[text()='Войти']"));
        clickLog.click();

        WebElement clickNotFill = driver.findElement(By.xpath("//button[@type='submit']"));
        clickNotFill.click();

        //Ждем пока появится предупреждение что "Логин не указан"
        WebElement visibleText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Textinput-Hint Textinput-Hint_state_error']")));
        Assertions.assertNotNull(visibleText.getText());

    }

    @AfterAll
    static void closeChrome() {
        driver.close();
    }
}
