package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day3 {
    public static void main(String[] args) {
        // https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        // Check the Single Checkbox and check the message bellow it
        System.setProperty("webdriver.chrome.driver", "C:\\Techno Study\\Selenium\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement element=driver.findElement(By.id("isAgeSelected"));
        element.click();
        if(element.isSelected()){
            System.out.println("Success");
        }else{
            System.out.println("Failure");
        }
        // https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        // Check the Multiple Checkbox and check the button message
        // When you check all the checkboxes, button message will change to 'Uncheck All'
        // When you uncheck at least one checkbox, button message will change to 'Check All'
        WebElement element1=driver.findElement(By.className("cb1-element"));
        element1.click();
        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label/input"));
        element2.click();
        WebElement element3=driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[3]/label/input"));
        element3.click();
        WebElement element4 =driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[4]/label/input"));
        element4.click();
        WebElement result=driver.findElement(By.xpath("//*[@id=\"check1\"]"));
        WebElement r=driver.findElement(By.xpath("//*[@id=\"check1\"]"));

        if(element1.isSelected()&& element2.isSelected() && element3.isSelected()&&element4.isSelected()){
            System.out.println("Success");
        }else{
            System.out.println("Failed");
        }


    }
}
