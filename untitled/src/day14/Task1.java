package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class Task1 {
    private WebDriver driver;
    @BeforeClass
            public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Techno Study\\Selenium\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }
    @AfterClass
            public void after() {
        driver.quit();
    }
//    @DataProvider
//    public Object[] data(){
//        return new object[]{
//
//        }
@AfterMethod // Mr.Bayrams Idia
public void clear(){
       driver.get(driver.getCurrentUrl());
        // driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

}

    @DataProvider
    public Object[][] valuesProvider() {
        return new Object[][]{{driver,10},
                {driver,20}};

    }
@Test(dataProvider ="valuesProvider")

    private static void clickAndValidateButtons(WebDriver driver, int num){
        WebElement btn = driver.findElement(By.xpath("//*[@onclick='addElement()']"));
        for (int i = 0; i < num; i++) {
            btn.click();
        }
        List<WebElement> list = driver.findElements(By.className("added-manually"));
        Assert.assertEquals(list.size(), num);

    }
   // clickAndValidateButtons(driver, 100);
}
