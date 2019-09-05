import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jgunther\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.podium.com/");
        WebDriverWait wait = new WebDriverWait(driver, 11);
//        try {
//            driver.wait(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //        WebElement watchDemo = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#site-navigation > div.desktop-menu > div.right-menu > div.demo-header > div > a")));
        driver.findElement(By.cssSelector("#site-navigation > div.desktop-menu > div.right-menu > div.demo-header > div > a")).click();

        WebElement firstName = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("FirstName")));
        firstName.sendKeys("Tristan");
        driver.findElement(By.id("LastName")).sendKeys("Test");
        driver.findElement(By.id("Email")).sendKeys("t@test.com");
        driver.findElement(By.id("Company")).sendKeys("PODIUM");
        driver.findElement(By.id("MobilePhone")).sendKeys("333225467");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driver.quit();
        driver.close();
    }
}
