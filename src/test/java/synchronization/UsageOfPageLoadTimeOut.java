package synchronization;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsageOfPageLoadTimeOut {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
	try {
		driver.get("https://www.ajio.com/");
		System.out.println("Pass: The WebPage has got loaded sucessfully.");
	} catch (TimeoutException e) {
		System.out.println("Fail: The WebPage has not loaded  sucessfully.");
	}
	//driver.manage().window().minimize();
	//driver.quit();
}
}