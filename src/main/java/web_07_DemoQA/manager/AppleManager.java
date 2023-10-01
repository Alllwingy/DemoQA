package web_07_DemoQA.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public interface AppleManager {

    WebDriver driver = new ChromeDriver();

    default void initial() {

        driver.navigate().to("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    default void tearDown() {

        driver.quit();
    }
}
