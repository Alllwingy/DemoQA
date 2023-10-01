package web_07_DemoQA.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public interface HelperBase extends AppleManager {

    default void pause(int seconds) {

        try {

            Thread.sleep(seconds * 1_000L);

        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }
    }

    default void hideAds() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#adplus-anchor').style.display='none'");
    }

    default void hideFooter() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('footer').style.display='none'");
    }

    default void hideDiv() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#close-fixedban').style.display='none'");
    }

    default boolean isElementPresent(By locator) {

//        return driver.findElements(locator).size() > 0;
        return !driver.findElements(locator).isEmpty(); // return true if element present
    }

    default void click(By locator) {

        driver.findElement(locator).click();
    }

    default void type(By locator, String text) {

        WebElement element = driver.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }
}
