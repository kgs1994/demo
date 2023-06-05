package javascript;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScrollHeightAndWidth {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.get("https://www.facebook.com/");
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	  long scrollWidth = (long)jse.executeScript("return document.body.scrollWidth");
	  System.out.println("scrollWidth = " + scrollWidth);
	  long scrollHeight = (long)jse.executeScript("return document.body.scrollHeight;");
	  System.out.println("scrollHeight = " + scrollHeight);
	  driver.manage().window().minimize();
	  driver.quit();
}
}