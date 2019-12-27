import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class day4 {
    public static void main(String[] args) throws InterruptedException {
        // go to URL: https://www.seleniumeasy.com/test/
        // click on each link of class="board-inner"
        // and validate that class="tab-content" has
        // correct text for "h3" tag and adjacent "p" tag in active div
        // after you click associated link above

        // there should be at least 5 test of "h3" tag and adjacent "p" tag
        System.setProperty("webdriver.chrome.driver", "C:\\Techno Study\\Selenium\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/");

        List<WebElement> element2= driver.findElements(By.cssSelector(".board-inner"));
        for(WebElement i: element2){
            i.click();
        }
        WebElement elements = driver.findElement(By.cssSelector("tab-content"));


        Thread.sleep(5000);
        driver.quit();
    }
}
