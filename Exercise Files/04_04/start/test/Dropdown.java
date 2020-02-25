import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class Dropdown {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/davepatel/desktop/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/dropdown");

        WebElement dropDownMenu= driver.findElement(By.id("dropdownMenuButton"));
        dropDownMenu.click();
        WebElement autocompleteListItem= driver.findElement(By.id("autocomplete"));
        autocompleteListItem.click();

        //driver.quit();
    }
}
