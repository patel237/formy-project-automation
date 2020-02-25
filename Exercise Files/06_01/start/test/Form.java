import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.SubmitElement;

import java.util.concurrent.TimeUnit;

public class Form {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/davepatel/Desktop/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/form");

        driver.findElement(By.id("first-name")).sendKeys("Dave");
        driver.findElement(By.id("last-name")).sendKeys("Patel");
        driver.findElement(By.id("job-title")).sendKeys("QA Analyst");

        driver.findElement(By.id("radio-button-2")).click();
        driver.findElement(By.id("checkbox-3")).click();

        driver.findElement(By.id("select-menu")).click();
        driver.findElement(By.cssSelector("option[value='1']")).click();

        driver.findElement(By.id("datepicker")).sendKeys("02/21/2020");
        driver.findElement(By.id("datepicker")).click();

        driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();
    //driver.quit();
    }
}
