package com.deepak.automation.tests;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// Basic auth handled via credentials in URL

public class HomePageTest {

    WebDriver driver;
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://the-internet.herokuapp.com/");
         driver.manage().timeouts().implicitlyWait(java.util.Objects.requireNonNull(java.time.Duration.ofSeconds(5)));

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
    void ModulesTest_AB_Testing() {
          driver.findElement(By.linkText("A/B Testing")).click();
        String title = driver.findElement(By.cssSelector("h3")).getText();
        System.out.println(title);
        String contextInABTesting = driver.findElement(By.cssSelector("p")).getText();
        System.out.println(contextInABTesting);
           }

    @Test
    @Order (3)
    void ModulesTest_Add_Remove_Elements() throws InterruptedException {
        driver.findElement(By.linkText("Add/Remove Elements")).click();
        String title = driver.findElement(By.cssSelector("h3")).getText();
        System.out.println(title);
        driver.findElement(By.cssSelector("button[onclick='addElement()']")).click();
        driver.findElement(By.cssSelector("button[onclick='deleteElement()']")).click();
         }
        
    @Test
    @Order (4)
    void ModulesTest_Basic_Auth() {
        // navigate directly with credentials to avoid Alert/UserAndPassword usage
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        String title = driver.findElement(By.cssSelector("h3")).getText();
        System.out.println(title);
        String contextInBasicAuth = driver.findElement(By.cssSelector("p")).getText();
        System.out.println(contextInBasicAuth);
    }

    @Test
    @Order (5)
    void ModulesTest_Broken_image()
    {
        driver.get("https://the-internet.herokuapp.com/broken_images");
        String title = driver.findElement(By.cssSelector("h3")).getText();
        System.out.println(title);
        Assertions.assertEquals("Broken Images", title);

    }

    @Test
    @Order (6)
    void ModulesTest_Challenging_Dom() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/challenging_dom");
        String title = driver.findElement(By.cssSelector("h3")).getText();
        System.out.println(title);
        Assertions.assertEquals("Challenging DOM", title);
        System.out.println(driver.findElement(By.id("canvas")).getScreenshotAs(org.openqa.selenium.OutputType.FILE));

    }
        
    




     

    

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}