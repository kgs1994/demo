package handlingPopups;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingNotificationPopup {
public static void main(String[] args) {
	ChromeOptions chromeOptions = new ChromeOptions();
	 chromeOptions.addArguments("--remote-allow-origins=*");
	 WebDriver driver = new ChromeDriver(chromeOptions);
	//Browser will through the notification popup
//it can be handled by changing the browser level settings
	
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.get("https://www.justdial.com/");
	
}
}