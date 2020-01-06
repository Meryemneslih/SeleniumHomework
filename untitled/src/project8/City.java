package project8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class City {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Techno Study\\Selenium\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://test-basqar.mersys.io");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("[formcontrolname=\"username\"]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[formcontrolname=\"password\"]")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector("fuse-navigation .group-items > .nav-item:nth-child(1)")).click();
        driver.findElement(By.cssSelector("fuse-navigation .group-items > .nav-item:nth-child(1) > .children > .nav-item:nth-child(1)")).click();
        driver.findElement(By.cssSelector("fuse-navigation .group-items > .nav-item:nth-child(1) > .children > .nav-item:nth-child(1) > .children > .nav-item:nth-child(2)")).click();

        driver.findElement(By.cssSelector("[class=\"svg-inline--fa fa-plus fa-w-12\"]")).click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        // WebElement element= driver.findElement(By.cssSelector("ms-text-field > .mat-input-element"));
        WebElement nameOfCity = driver.findElement(By.cssSelector("[id='ms-text-field-1'][aria-invalid='false']"));
        //driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait( driver, 3 );
//        wait.until( ExpectedConditions.visibilityOfElementLocated( By.cssSelector( "[id='ms-text-field-0'][aria-invalid='false']" ) ) );
        // element.click();
        // element.sendKeys("Istanbul");
        // WebElement nameOfCity=driver.findElement(By.xpath("//input[@id='ms-text-field-1']"));
        nameOfCity.click();
        String city = "Istanbul";
        nameOfCity.sendKeys(city);

        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("[aria-label='Country']")).click();
        driver.findElement(By.cssSelector("[aria-label='dismiss cookie message']")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[aria-label='dismiss cookie message']")));
        driver.findElement((By.xpath("//span[contains(text(),'Turkey')]"))).click();
        driver.findElement(By.cssSelector("fa-icon[class='ng-fa-icon ng-star-inserted']")).click();
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[aria-label='City successfully created']")));
            System.out.println(" => Creation Success!");
        } catch (Exception e) {
            System.out.println(" => Creation Failure!");
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(@class,'name') and text()='" + city + "']")));

        driver.findElement(By.cssSelector("tbody>tr:nth-child(1)>td:nth-child(4)>div>ms-edit-button")).click();
        WebElement element = driver.findElement(By.cssSelector("div>ms-text-field>input[id='ms-text-field-2']"));
        //ms-text-field[placeholder='GENERAL.FIELD.NAME']+ms-translation+span
        element.clear();
        String update= city+"2";
        element.sendKeys(update);
        driver.findElement(By.cssSelector("span[class='mat-button-wrapper']>fa-icon[class='ng-fa-icon ng-star-inserted']")).click();
        //[fxlayoutalign='start stretch'][fxlayoutgap='10px'] also working

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[aria-label='City successfully updated']")));
            System.out.println(" => Creation Success!");
        } catch (Exception e) {
            System.out.println(" => Creation Failure!");
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(@class,'name') and text()='" + update+"']")));
        driver.findElement(By.cssSelector("tbody>tr:nth-child(1)>td:nth-child(4)>div>ms-delete-button")).click();
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[aria-label='City successfully deleted']")));
            System.out.println(" => Creation Success!");
        } catch (Exception e) {
            System.out.println(" => Creation Failure!");
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[aria-label='City successfully deleted']")));

        driver.findElement(By.cssSelector("ms-text-field>input")).sendKeys(update);
        driver.findElement(By.cssSelector("div[class='control-full']>button>span[class='mat-button-wrapper']")).click();
        try {
            wait.until( ExpectedConditions.numberOfElementsToBe( By.xpath( "//tbody//tr" ), 0)  );
            System.out.println("Delete verified!");
        } catch (Exception e){
            System.out.println("Failure!");
        }

        //MR.DAKE HOCAM IF YOU SEE THIS PROJECT I KNOW CODES ARE CRAZY
        // BECAUSE I STUDIED FOR "CHILD PARENT SIBLING RELATIONSHIP" AND "TBODY>TR TD" ON THIS PROJECT :))

        }
}
