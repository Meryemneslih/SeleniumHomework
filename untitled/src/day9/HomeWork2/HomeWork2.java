package day9.HomeWork2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HomeWork2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Techno Study\\Selenium\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Techno%20Study/Exercises/SeleniumHomework/untitled/src/day9/HomeWork1/HomeWork1.html");

        WebElement element= driver.findElement(By.cssSelector("input[type='username']"));
        element.sendKeys("Neslihan");

        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("nesli123");
        driver.findElement(By.name("password repeat")).sendKeys("nesli123");
        driver.findElement(By.cssSelector("textarea")).sendKeys("35th Ave. Bayside, NY");

        List<WebElement> button= driver.findElements(By.name("choose one"));
        button.get(1).click();

        List<WebElement> drop= driver.findElements(By.tagName("option"));
        drop.get(2).click();

        driver.findElement(By.cssSelector("input[type='checkbox']")).click();
        driver.findElement(By.cssSelector("input[type='image']")).click();



    }
}