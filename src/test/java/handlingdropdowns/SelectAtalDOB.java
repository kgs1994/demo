package handlingdropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class SelectAtalDOB {
public static void main(String[] args) throws Throwable {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.get("https://www.facebook.com/signup");
	//Index Value starts from Zero and that value will be the input 
	new Select(driver.findElement(By.id("day"))).selectByIndex(24);
	//<option> value attribute value will be the input for the selectByValue()
	new Select(driver.findElement(By.id("month"))).selectByValue("12");
	//Dropdown option will be the direct input for selectByVisibleText()
	new Select(driver.findElement(By.id("year"))).selectByVisibleText("1924");
	Thread.sleep(5000);
	driver.manage().window().minimize();
	driver.quit();
}
}