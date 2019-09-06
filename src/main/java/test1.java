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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
        driver.get("https://www.podium.com/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 11);
        WebElement watchDemo = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#site-navigation > div.desktop-menu > div.right-menu > div.demo-header > div > a")));
        watchDemo.click();

        WebElement firstName = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("FirstName")));
        firstName.sendKeys("Tristan");
        WebElement lastName = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("LastName")));
        lastName.sendKeys("Test");
        WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Email")));
        email.sendKeys("t@test.com");
        WebElement company = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Company")));
        company.sendKeys("PODIUM");
        WebElement mobilePhone = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("MobilePhone")));
        mobilePhone.sendKeys("333225467");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
        driver.close();
    }
}
