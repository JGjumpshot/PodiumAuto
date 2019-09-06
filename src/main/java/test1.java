import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class test1 {
    private WebDriver driver;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
        driver.get("https://www.podium.com/");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown() {
        driver.close();
    }

    @Test(priority = 1)
    public void watchDemo()
    {
        driver.findElement(By.cssSelector("#site-navigation > div.desktop-menu > div.right-menu > div.demo-header > div > a")).click();
        driver.findElement((By.id("FirstName"))).sendKeys("Tristan");
        driver.findElement(By.id("LastName")).sendKeys("Test");
        driver.findElement(By.id("Email")).sendKeys("t@test.com");
        driver.findElement(By.id("Company")).sendKeys("PODIUM");
        driver.findElement(By.id("MobilePhone")).sendKeys("333225467");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
