package day9.Homework4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleForm {
    public static void main(String[] args) {
        /**
         * open "https://ultimateqa.com/filling-out-forms/"
         * fill in et_pb_contact_form_0 with some random data
         * click on submit button of this form
         * check that text "Form filled out successfully" is displayed
         **/
        System.setProperty("webdriver.chrome.driver", "C:\\Techno Study\\Selenium\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ultimateqa.com/filling-out-forms/");

       driver.findElement(By.id("et_pb_contact_name_0")).sendKeys("Neslihan");
       driver.findElement(By.id("et_pb_contact_message_0")).sendKeys("Hello");
       driver.findElement(By.xpath("//*[@id=\"et_pb_contact_form_0\"]/div[2]/form/div/button")).click();

       driver.findElement(By.id("et_pb_contact_name_1")).sendKeys("Neslihan");
       driver.findElement(By.id("et_pb_contact_message_1")).sendKeys("Hello");
      WebElement element=  driver.findElement(By.xpath("//span[@class='et_pb_contact_captcha_question']"));
        String text= element.getText();
        System.out.println(text);
        String replace= text.replace("+","");
        System.out.println(replace);
        String[] split=replace.split(" ");
        String a="";
        String b="";
        for(String i:split){
             a=split[0];
             b=split[1];
        }

        System.out.println(a);
        System.out.println(b);
//        int sum = 0;
//        for (String num : number.split("")) {
//            Integer digit = Integer.valueOf(num);
//            if (digit % 2 == 0) {
//                sum += digit * 2;
//            } else {
//                sum += digit * -1;
//            }
//        }

    }
}
