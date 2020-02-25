import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/davepatel/Desktop/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/dragdrop");

        WebElement image = driver.findElement(By.id("image"));
        WebElement box = driver.findElement(By.id("box"));


        Actions actions = new Actions(driver);
        //public Actions clickAndHold(WebElement image);
        //actions.moveToElement(WebElement box, int -250, int 0);
        //actions.build().perform();
        actions.dragAndDrop(image, box).build().perform();
        actions.dragAndDropBy(image, -250, 0);

        Thread.sleep(4000);


        driver.quit();
    }
}

