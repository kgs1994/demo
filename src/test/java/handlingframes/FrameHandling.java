package handlingframes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameHandling {
public static void main(String[] args) throws Throwable {
	System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.get("https://jqueryui.com/draggable/");
	driver.switchTo().frame(0);
	WebElement draggableElement = driver.findElement(By.id("draggable"));
	Actions action = new Actions(driver);
	action.clickAndHold(draggableElement).pause(Duration.ofSeconds(1)).moveByOffset(20, 87).release().build().perform();
	driver.switchTo().defaultContent();
	driver.findElement(By.linkText("Demos")).click();
	Thread.sleep(5000);
	driver.manage().window().minimize();
	driver.quit();
}
}