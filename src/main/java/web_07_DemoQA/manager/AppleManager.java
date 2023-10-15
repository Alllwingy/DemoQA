package web_07_DemoQA.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public interface AppleManager {

    ChromeOptions options = new ChromeOptions().addArguments("Load-extension=C://Tools/5.10.1_0");
    WebDriver driver = new ChromeDriver(options);

    default void initial() {

        driver.navigate().to("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    default void initialAddOptions() {

        driver.navigate().to("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        try {

            Thread.sleep(5000);

        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());

        for (String element : tabs) {

            System.out.println(element);
        }

        driver.switchTo().window(tabs.get(1)).close();
        driver.switchTo().window(tabs.get(0));

        driver.navigate().refresh(); // back / forward
    }

    default void tearDown() {

        driver.quit();
    }
}
