package com.tlquick.pokie;

import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

public class FirstSeleniumAutoTest {
    @Test
    public void selenium_WebTitleTest() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\SeleniumDrivers\\Chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        //driver.manage().window().maximize();
        driver.get("http://127.0.0.1:8081/index");
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        assertEquals("Cherry Bomb", driver.getTitle(), "Title check failed!");
        driver.close();
        driver.quit();
    }
}
