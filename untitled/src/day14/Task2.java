package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.Provider;
import java.util.List;

public class Task2 {
    private WebDriver driver;

    @BeforeClass
    public void set() {


        System.setProperty("webdriver.chrome.driver", "C:\\Techno Study\\Selenium\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }
    @DataProvider
    public Object[][] valuesProvider() {
        return new Object[][]{{driver, 10},
                {driver, 15}};
    }
    //    createButtons(driver, 70);
//    deleteButtonsAndValidate(driver, 50);
    @AfterClass
    public void quit() {
        driver.quit();
    }

    @Test(dataProvider ="valuesProvider")
    private static void createButtons(WebDriver driver, int numberOfButtonsToAdd) {
        WebElement btn = driver.findElement(By.xpath("//*[@onclick='addElement()']"));
        for (int i = 0; i < numberOfButtonsToAdd; i++) {
            btn.click();
        }
    }
    @DataProvider
    public Object[][] valuesProvider2() {
        return new Object[][]{{driver, 10},
                {driver, 15}};
    }
@Test(dataProvider = "valuesProvider2")
    private static void deleteButtonsAndValidate(WebDriver driver, int number) {
        List<WebElement> elements = driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
        int sizeBeforeDeleting = elements.size();

        List<WebElement> buttonsToDelete = driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
        int counter = 0;
        for (WebElement webElement : buttonsToDelete) {
            counter++;
            if (counter > number) {
                break;
            }
            webElement.click();
        }

        List<WebElement> elementsAfter = driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
        int sizeAfterDeleting = elementsAfter.size();
    Assert.assertEquals((sizeBeforeDeleting-number),sizeAfterDeleting);

    }
}