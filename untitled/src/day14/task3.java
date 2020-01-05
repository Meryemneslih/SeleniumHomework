package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class task3 {

    private WebDriver driver;
    @BeforeClass
    public void set() {
        System.setProperty("webdriver.chrome.driver", "C:\\Techno Study\\Selenium\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html");
    }

    @Test
    public void test() {
        driver.findElement(By.id("normal-btn-success")).click();
        WebElement message = driver.findElement(By.cssSelector(".alert-normal-success"));
        WebElement button = driver.findElement(By.cssSelector(".alert-normal-success > button"));
        String text = message.getText().replace(button.getText(), "").trim();
        String test = "I'm a normal success message. To close use the appropriate button.";
        // ternary expression!
        Assert.assertEquals(text,test);
        button.click();
        Assert.assertTrue(!message.isDisplayed());
    }
    @AfterClass
    public void quit(){
        driver.quit();
    }
}