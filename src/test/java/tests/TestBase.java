package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import web_07_DemoQA.manager.AppleManager;

public class TestBase implements AppleManager {

    @BeforeSuite
    public void setup() {

//        initial();
        initialAddOptions();
    }

    @AfterSuite
    public void stop() {

        tearDown();
    }
}
