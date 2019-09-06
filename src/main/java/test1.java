import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

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
    public void closeTest() {
        driver.close();
    }
//    @AfterClass
//    public void teardown() {
//
//    }

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
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().to("https://www.podium.com");
    }

    @Test(priority = 2)
    public void login() throws InterruptedException {
        driver.findElement(By.cssSelector("#menu-item-1317 > a")).click();
        driver.findElement(By.cssSelector("#login > form > div:nth-child(1) > input[type=text]")).sendKeys("2824443567");
        driver.findElement(By.cssSelector("#login > form > div:nth-child(2) > input[type=password]")).sendKeys("T3st!ng");
        driver.findElement(By.cssSelector("#login > form > div:nth-child(2) > a")).click();
        driver.findElement(By.cssSelector("#login > form > button")).click();
        Thread.sleep(10000);
    }
}
