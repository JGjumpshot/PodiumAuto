import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class test1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //install TestNG tomorrow
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
        driver.get("https://www.podium.com/");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("#site-navigation > div.desktop-menu > div.right-menu > div.demo-header > div > a")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Tristan");
        driver.findElement(By.id("LastName")).sendKeys("Test");
        driver.findElement(By.id("Email")).sendKeys("t@test.com");
        driver.findElement(By.id("Company")).sendKeys("PODIUM");
        driver.findElement(By.id("MobilePhone")).sendKeys("333225467");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
