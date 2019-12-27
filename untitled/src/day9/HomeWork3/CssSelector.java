package day9.HomeWork3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Open "https://ultimateqa.com/complicated-page/"
 * find "Skills Improved:" using css selectors and validate text
 * find "How to deal with a large page that has many elements and divisions?" using css selector and validate it
 * find "Properly structuring your page objects" using css selector and validate it
 * */
public class CssSelector {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Techno Study\\Selenium\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ultimateqa.com/complicated-page/");

        WebElement element = driver.findElement(By.cssSelector("#Skills_Improved"));
        System.out.println(element.getText());
       String test= "Skills Improved:";
if(test.equals(element.getText())){
    System.out.println("Success");
}else{
    System.out.println("Failure");
}


WebElement element1= driver.findElement(By.xpath("//*[@id=\"et-boc\"]/div/div/div/div[1]/div/div/div/ul/li[1]"));
        System.out.println(element1.getText());
        String test1= "How to deal with a large page that has many elements and divisions?";
        if(element1.getText().equals(test1)){
            System.out.println("Success");
        }else{
            System.out.println("Failure");
        }

        WebElement element2= driver.findElement(By.xpath("//*[@id=\"et-boc\"]/div/div/div/div[1]/div/div/div/ul/li[2]"));
        System.out.println(element2.getText());
        String test2= "Properly structuring your page objects";
        if(element2.getText().equals(test2)){
            System.out.println("Success");
        }else{
            System.out.println("Failure");
        }
//        WebDriverWait wait= new WebDriverWait(driver,30);
//        driver.switchTo().frame("generator");
//        WebElement webelement= driver.findElement(By.cssSelector(".tcb-icon"));
//        webelement.click();


        driver.quit();
    }
}
