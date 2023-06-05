package handlingPopups;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingPromptPopup {
public static void main(String[] args) throws Throwable {
	ChromeOptions chromeOptions = new ChromeOptions();
	 chromeOptions.addArguments("--remote-allow-origins=*");
	 WebDriver driver = new ChromeDriver(chromeOptions);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.get("file:///C:/Users/HP/Desktop/DesktopOffice/Sample%20WebPages/popups/prompt.html");
	System.out.println(driver.switchTo().alert().getText());
	Thread.sleep(4000);
	driver.switchTo().alert().sendKeys("21");
	driver.switchTo().alert().accept();
}
}