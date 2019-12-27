package day9.HomeWork2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * open SignUpForm.html
 * fill in your data inside the all input elements
 * submit the form
 * get URL
 * parse values that was submitted and print them out
 * hint: https://examples.javacodegeeks.com/core-java/net/url/parse-url-example/
 * like nameOfTheInput = valueOfTheInput
 */
public class SignUpFormSubmissionParsing {
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


        String url1= driver.getCurrentUrl();
        System.out.println(url1);

        String url= url1.replace("file:///C:/Techno%20Study/Exercises/SeleniumHomework/untitled/src/day9/HomeWork1/HomeWork1.html?","");
        System.out.println(url);
        String[] split= url.split("&");

        for(String s: split){
            System.out.println(s);
        }

        driver.quit();
//        try {
//            URL url = new URL(driver.getCurrentUrl());
//            String protocol = url.getProtocol();
//            String host = url.getHost();
//        int port = url.getPort();
//        String path = url.getPath();
//            System.out.println(url);
//            System.out.println(protocol);
//            System.out.println(host);
//            System.out.println(port);
//            System.out.println(path);
//        }
//         catch (MalformedURLException e){
//            System.out.println("Malformed URL: " + e.getMessage());
//        }
    }
}
