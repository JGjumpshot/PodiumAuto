import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.podium.com/");
//        try {
//            driver.wait(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        try {
            driver.findElement(By.cssSelector("#site-navigation > div.desktop-menu > div.right-menu > div.demo-header > div > a")).click();
            Thread.sleep(5000);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        //driver.quit();
        driver.close();
    }
}
