package day9.HomeWork2;
/**
 * open SignUpForm.html
 * store values that you will use inside some Strings
 * fill in your data inside the all input elements using Strings above
 * submit the form
 * get URL
 * parse values that was submitted
 * validate parsed values with stored values above
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SignUpFormSubmissionValidation {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Techno Study\\Selenium\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Techno%20Study/Exercises/SeleniumHomework/untitled/src/day9/HomeWork1/HomeWork1.html");

        WebElement element= driver.findElement(By.cssSelector("input[type='username']"));
        element.sendKeys("Neslihan");

        WebElement password= driver.findElement(By.cssSelector("input[type='password']"));
                password.sendKeys("nesli123");
        WebElement repeat= driver.findElement(By.name("password repeat"));
                repeat.sendKeys("nesli123");
        WebElement textarea = driver.findElement(By.cssSelector("textarea"));
                textarea.sendKeys("35th Ave. Bayside, NY");

        List<WebElement> button= driver.findElements(By.name("choose one"));
       WebElement female=  button.get(1);
               female.click();

        List<WebElement> drop= driver.findElements(By.tagName("option"));
        WebElement down= drop.get(2);
                down.click();

        WebElement checkbox= driver.findElement(By.cssSelector("input[type='checkbox']"));
                checkbox.click();


               String v1= element.getAttribute("value");
               String v2= password.getAttribute("value");
               String v3= repeat.getAttribute("value");
               String v4= textarea.getAttribute("value");
               String v5= female.getAttribute("value");
               String v6= down.getAttribute("value");
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
        System.out.println(v5);
        System.out.println(v6);


        WebElement submit= driver.findElement(By.cssSelector("input[type='image']"));
        submit.click();

        String url1= driver.getCurrentUrl();
        System.out.println(url1);

        String url= url1.replace("file:///C:/Techno%20Study/Exercises/SeleniumHomework/untitled/src/day9/HomeWork1/HomeWork1.html?","");
        System.out.println(url);
        String[] split= url.split("&");

        for(String s: split){
            System.out.println(s);
        }
        boolean validation= false;
        if(split[0].contains(v1) && split[1].contains(v2) && split[2].contains(v3) && split[4].contains(v5)){
            validation= true;
        }else{
            validation=false;
        }
        System.out.println(validation);
        if(validation){
            System.out.println("Success");
        }else{
            System.out.println("Failure");
        }
        driver.quit();

    }
}
