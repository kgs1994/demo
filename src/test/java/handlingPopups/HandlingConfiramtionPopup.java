package handlingPopups;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingConfiramtionPopup {
public static void main(String[] args) {
	ChromeOptions chromeOptions = new ChromeOptions();
	 chromeOptions.addArguments("--remote-allow-origins=*");
	 WebDriver driver = new ChromeDriver(chromeOptions);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.get("https://licindia.in/");
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,500);");
	WebElement agentsPortal = driver.findElement(By.xpath("//div[@class='tab-left']//a[text()='Agents Portal']"));
	new Actions(driver).moveToElement(agentsPortal).click(agentsPortal).perform();
	wait.until(ExpectedConditions.alertIsPresent());
	System.out.println(driver.switchTo().alert().getText());
	driver.switchTo().alert().dismiss();
	//driver.switchTo().alert().accept();
	//System.out.println(driver.getTitle());
}
}
