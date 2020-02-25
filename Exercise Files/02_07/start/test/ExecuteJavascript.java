import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import java.lang.InterruptedException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class ExecuteJavascript {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/davepatel/Desktop/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/modal");

        WebElement modalButton = driver.findElement(By.id("modal-button"));
        WebElement closeButton = driver.findElement(By.id("close-button"));

        WebElement modalDialogue = driver.findElement(By.id("exampleModal"));

        JavascriptExecutor js = (JavascriptExecutor)driver;

        //Binding to CSS event property ready class added to modal dialog box after transform is complete
        js.executeScript(
                "var modal = document.getElementById('exampleModal');" +
                "modal.addEventListener('transitionend', function (evt) {" +
                "       if (evt.propertyName === 'transform') modal.classList.add('ready');" +
                "   }, true);" +
                "modal.addEventListener('transitionrun', function (evt) {" +
                "       if (evt.propertyName === 'transform') modal.classList.remove('ready');" +
                "   }, true);"
        );


        modalButton.click();

        //This is useful to make WebDriver wait 2 seconds and check every 50 ms to see if modal dialogue contains "ready"
        new WebDriverWait(driver, 2, 50).until(
                ExpectedConditions.attributeContains(modalDialogue, "class", "ready")
        );

        js.executeScript("arguments[0].click();", closeButton);
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        driver.quit();
    }
}
