package com.deepak.automation.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().pageLoadTimeout(java.time.Duration.ofSeconds(6));

    }

    @Test
    @Order (1)
    void Homepagetest() throws InterruptedException {
      
        String url = driver.getCurrentUrl();
        String title = driver.getTitle();
        System.out.println(url);
        System.out.println(title);
        Thread.sleep(4000);
        System.out.println(driver.findElement(By.cssSelector("h1.heading")).getText());
    }

    @Test
    @Order (2)
    void ModulesLinkTestOpen_all_at_single_testcase() {
        
        driver.findElement(By.linkText("A/B Testing")).click();
        String title = driver.findElement(By.cssSelector("h3")).getText();
        System.out.println(title);
        String contextInABTesting = driver.findElement(By.cssSelector("p")).getText();
        System.out.println(contextInABTesting);
        
    }

    @Test
    @Order (3)
    void ModulesLinkTestOpen_all_at_single_testcase_2() throws InterruptedException {
       
        driver.findElement(By.linkText("Add/Remove Elements")).click();
        String title = driver.findElement(By.cssSelector("h3")).getText();
        System.out.println(title);
        driver.findElement(By.cssSelector("button[onclick='addElement()']")).click();
        driver.findElement(By.cssSelector("button[onclick='deleteElement()']")).click();
       

    }




     

    

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}