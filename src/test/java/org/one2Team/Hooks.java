package org.one2Team;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver;
    String os = System.getProperty("os.name").toLowerCase();

    @Before
    public void setUp(){
        if (os.contains("windows")) {
            System.setProperty("webdriver.chrome.driver", "src/test/java/org/one2Team/chromedriver.exe");
        } else if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", "src/test/java/org/one2Team/chromedriver");
        }
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}

