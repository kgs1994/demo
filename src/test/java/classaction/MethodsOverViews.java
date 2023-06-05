package classaction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
//moveToElement(WebElement targetElement)
//moveToElement(WebElement targetElement, int xOffset, int yOffset)
//moveByOffset(int xOffset, int yOffset)
//pause(Duration duration)
//perform()
public class MethodsOverViews {
public static void main(String[] args) throws Throwable {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.get("https://www.landrover.in/index.html");
	WebElement vehicleSection = driver.findElement(By.xpath("//a/span[text()='VEHICLES']"));
	vehicleSection.click();
	Thread.sleep(5000);
	Actions actions = new Actions(driver);
	WebElement rangeRoverEvoque = driver.findElement(By.xpath("//div[@class='dxnav-vehicle-nav_details-container']/ancestor::div[@class='dxnav-vehicle-menu_categories']//p[text()='RANGE ROVER EVOQUE']"));
	//actions.moveToElement(rangeRoverEvoque).pause(Duration.ofSeconds(5)).moveToElement(rangeRoverEvoque, 0, 56).pause(Duration.ofSeconds(5)).moveToElement(rangeRoverEvoque, 0, 112).pause(Duration.ofSeconds(5)).moveToElement(rangeRoverEvoque, 0, 168).pause(Duration.ofSeconds(5)).moveToElement(rangeRoverEvoque, 0, 224).perform();
	actions.moveToElement(rangeRoverEvoque).pause(Duration.ofSeconds(3)).moveByOffset(0, 56).pause(Duration.ofSeconds(3)).moveByOffset(0, 56).pause(Duration.ofSeconds(3)).moveByOffset(0, 56).pause(Duration.ofSeconds(3)).moveByOffset(0, 56).perform();
}
}
