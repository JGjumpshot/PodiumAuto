import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class test1 {
    private WebDriver driver;

    @BeforeClass //Happens before the test
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe"); //initializing properties for chromedriver
        driver = new ChromeDriver(); //instantiating new chromedriver
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //setting waits for elements to be found on the dom.
        driver.get("https://www.podium.com/"); //getting the podium url
        driver.manage().window().maximize(); //maximizing the window
    }

    @AfterClass //happens after the test
    public void closeTest() {
        driver.quit();
    }

    @Test(priority = 1) //Test to watch the demo
    public void watchDemo() {
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

    @Test(priority = 2) //Assert that incorrect phone number and password throws an error
    public void login() throws InterruptedException {
        driver.findElement(By.cssSelector("#menu-item-1317 > a")).click();
        driver.findElement(By.cssSelector("#login > form > div:nth-child(1) > input[type=text]")).sendKeys("2824443567");
        driver.findElement(By.cssSelector("#login > form > div:nth-child(2) > input[type=password]")).sendKeys("T3st!ng");
        driver.findElement(By.cssSelector("#login > form > div:nth-child(2) > a")).click();
        driver.findElement(By.cssSelector("#login > form > button")).click();
        Thread.sleep(2000);
        String data = driver.findElement(By.className("form-submit-error")).getText();
        System.out.println(data);
        String actualString = "Invalid phone or password";
        Assert.assertEquals(data, actualString);
        Thread.sleep(4000);
        driver.navigate().to("https://www.podium.com");
    }

    @Test(priority = 3) //Assert that leads url is correct
    public void leads() {
        Actions actions = new Actions(driver);
        WebElement leads = driver.findElement(By.cssSelector("#menu-item-1309 > a"));
        actions.moveToElement(leads).perform();
        leads.click();
        String leadsUrl = driver.getCurrentUrl();
        Assert.assertEquals(leadsUrl, "https://www.podium.com/solutions/leads/");
    }

    @Test(priority = 4) //Test to verify that all tabs and urls are working.
    public void loopElements() {
        Actions actions = new Actions(driver);
        List<WebElement> leads = driver.findElements(By.cssSelector("#menu-item-1309 > ul > li"));
        int size = leads.size();
        System.out.println(leads);
        WebElement hover = driver.findElement(By.cssSelector("#menu-item-1309"));
        for (int i = 1; i <= size; i++) {
            try {
                actions.moveToElement(hover).perform();
                WebElement getIndex = driver.findElement(By.cssSelector(String.format("#menu-item-1309 > ul > li:nth-child(%s)", i)));
                getIndex.click();
            } catch (StaleElementReferenceException e) {
                hover = driver.findElement(By.cssSelector("#menu-item-1309"));
                actions.moveToElement(hover).perform();
                WebElement getIndex = driver.findElement(By.cssSelector(String.format("#menu-item-1309 > ul > li:nth-child(%s)", i)));
                getIndex.click();
            }
        }
        driver.navigate().to("https://www.podium.com");
    }

    @Test(priority = 5) //Verifying customers url is correct
    public void customers() {
        Actions actions = new Actions(driver);
        WebElement customers = driver.findElement(By.cssSelector("#menu-item-1314 > a"));
        actions.moveToElement(customers).perform();
        customers.click();
        String customersUrl = driver.getCurrentUrl();
        Assert.assertEquals(customersUrl, "https://www.podium.com/solutions/customers/");
    }

    @Test(priority = 6) //Verifying teams url is correct
    public void teams() {
        Actions actions = new Actions(driver);
        WebElement teams = driver.findElement(By.cssSelector("#menu-item-1357 > a"));
        actions.moveToElement(teams).perform();
        teams.click();
        String teamsUrl = driver.getCurrentUrl();
        Assert.assertEquals(teamsUrl, "https://www.podium.com/solutions/teams/");
        driver.navigate().to("https://www.podium.com");
    }

    @Test(priority = 7) //Entering iframe and opening text box
    public void clickPodiumButton() throws InterruptedException {
        Thread.sleep(2500);
        driver.switchTo().frame(driver.findElement(By.id("podium-bubble")));
        WebElement podiumButton = driver.findElement(By.cssSelector("#main > div > div > div > div > button"));
        podiumButton.click();
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
    }
}

