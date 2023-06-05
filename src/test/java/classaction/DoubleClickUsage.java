package classaction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DoubleClickUsage {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.get("https://live.skillrary.com/testing-app/product.php?product=selenium-training");
	Actions actions = new Actions(driver);
	WebElement addButton = driver.findElement(By.id("add"));
	//actions.doubleClick(addButton).perform();
	actions.moveToElement(addButton).doubleClick().pause(Duration.ofSeconds(1)).doubleClick().build().perform();
	
}
}
