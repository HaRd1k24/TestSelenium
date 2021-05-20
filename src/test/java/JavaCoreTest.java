import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.Collections;

public class JavaCoreTest {
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
    @DisplayName("Тест меню сайта")
    void testSiteJavaCore() throws InterruptedException {
        driver.get("https://howtodoinjava.com/");
        String[] str = {"Java 10 Tutorial","Java 12 Tutorial"};


        for (String s : str) {


        }
    }


    void checkingHeaders(String str) throws InterruptedException {

        WebElement clickGuide = driver.findElement(By.xpath(String.format("//ol//a[text()='%s']", str)));
        clickGuide.click();
        Assertions.assertNotNull(clickGuide);
        WebElement leftBlock = driver.findElement(By.xpath("//aside[@aria-label='Secondary Sidebar']"));

        ArrayList<String> list = new ArrayList<>(Collections.singleton(leftBlock.getText()));
        Assertions.assertTrue(list.contains(leftBlock.getText()));

        WebElement upBlock = driver.findElement(By.xpath("//div[@class='breadcrumb']"));
        Assertions.assertNotNull(upBlock);

        WebElement onTum = driver.findElement(By.xpath("//div[@class='wpnm-button style-2']"));
        onTum.click();
        driver.close();
        Thread.sleep(1000);



    }

}
