package com.deepak.automation.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void titleTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/");
        String url = driver.getCurrentUrl();
        String title = driver.getTitle();
        Thread.sleep(2000);
        System.out.println(url);
        Thread.sleep(2000);
        System.out.println(title);
        Assertions.assertEquals("The Internet", title);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}