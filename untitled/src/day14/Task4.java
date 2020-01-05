package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task4 {
    private WebDriver driver;

    @BeforeClass
    public void set() {
        System.setProperty("webdriver.chrome.driver", "C:\\Techno Study\\Selenium\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html");
    }

    @Test
    private void Test() {
        driver.findElement(By.id("autoclosable-btn-success")).click();
        WebDriverWait wait = new WebDriverWait(driver, 3);

        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("alert-autocloseable-success")));
            System.out.println("Success!");
        } catch (Exception e) {
            System.out.println("Failure!");
        }
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }
}
