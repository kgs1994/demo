package classaction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionSendKeys {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.get("https://www.facebook.com/");
	Actions actions = new  Actions(driver);
	WebElement emailAddress = driver.switchTo().activeElement();
	//actions.sendKeys(emailAddress, "peoplefortitptur@gmail.com").perform();
	
	actions.scrollToElement(driver.findElement(By.xpath("//a[text()='Contact uploading and non-users']"))).perform();
	
	
	
	
	
	
}
}