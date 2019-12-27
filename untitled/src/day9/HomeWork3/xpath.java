package day9.HomeWork3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Open "http://the-internet.herokuapp.com/login"
 *
 * using XPath:
 *      grab username from first <em> tag and store inside a String
 *      grab password from second <em> tag and store inside a String
 *      fill in username and password inputs with above username and password
 *      find <button> with type="submit" and click it
 *      find and verify text "Welcome to the Secure Area. When you are done click logout below."
 *      find "Log out" button and click it
 *      find and verify text "You logged out of the secure area!"
 * */
public class xpath {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Techno Study\\Selenium\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/login");

        List <WebElement> elements= driver.findElements(By.xpath("//em"));
        String a=elements.get(0).getText();
        String b= elements.get(1).getText();
        System.out.println(a + "  " +b);

        WebElement element= driver.findElement(By.xpath("//input[@name='username']"));
        element.sendKeys(a);
        WebElement element1= driver.findElement(By.xpath("//input[@name='password']"));
        element1.sendKeys(b);

        WebElement button= driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();

        WebElement text= driver.findElement(By.xpath("//*[@class='subheader']"));
        String test="Welcome to the Secure Area. When you are done click logout below.";
        if(text.getText().equals(test)){
            System.out.println("Success");
        }else{
            System.out.println("Failure");
        }
        WebElement log= driver.findElement(By.xpath("//a[@class='button secondary radius']"));
        log.click();

        WebElement alert= driver.findElement(By.xpath("//*[@id=\"flash\"]"));
        String test2= "You logged out of the secure area!";
        if(alert.getText().equals(test2)){
            System.out.println("Success");
        }else{
            System.out.println("Failure");
        }
        driver.quit();
    }
}


