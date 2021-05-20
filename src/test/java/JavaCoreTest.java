import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import java.util.*;

public class JavaCoreTest {
    static WebDriver driver;
    static final String url = "https://howtodoinjava.com/";

    @BeforeAll
    static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

    }

    @Test
    @DisplayName("Тест меню сайта")
    void testSiteJavaCore() throws InterruptedException {
        driver.get(url);

        List<String> list = Arrays.asList("Java 10 Tutorial", "Java 12 Tutorial", "Java 14 Tutorial", "Java 11 Tutorial");

        checkingHeaders(list);
    }

    private void checkingHeaders(List<String> list) {
        for (String s : list) {
            WebElement clickGuide = driver.findElement(By.xpath(String.format("//ol//a[text()='%s']", s)));
            clickGuide.click();
            Assertions.assertNotNull(clickGuide);
            WebElement leftBlock = driver.findElement(By.xpath("//aside[@aria-label='Secondary Sidebar']"));

            List<String> listText = new ArrayList<>(Collections.singleton(leftBlock.getText()));
            Assertions.assertTrue(listText.contains(leftBlock.getText()));

            WebElement upBlock = driver.findElement(By.xpath("//div[@class='breadcrumb']"));
            Assertions.assertNotNull(upBlock);

            WebElement onTum = driver.findElement(By.xpath("//div[@class='wpnm-button style-2']"));
            onTum.click();

            WebElement offTum = driver.findElement(By.xpath("//div[@class='wpnm-button style-2 active']"));
            offTum.click();

            driver.navigate().back();
        }
    }

    @AfterAll
    static void exitChrome() {
        driver.close();
    }

}
