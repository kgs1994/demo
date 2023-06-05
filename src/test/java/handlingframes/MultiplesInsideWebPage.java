package handlingframes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultiplesInsideWebPage {
	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
	
	driver.switchTo().frame("packageListFrame");
	WebElement packageName = driver.findElement(By.xpath("//li/a[text()='org.openqa.selenium']"));
	wait.until(ExpectedConditions.elementToBeClickable(packageName));
	packageName.click();
	driver.switchTo().defaultContent();
	driver.switchTo().frame("packageFrame");
	WebElement alertEle = driver.findElement(By.xpath("//span[text()='Alert']"));
	wait.until(ExpectedConditions.elementToBeClickable(alertEle));
	alertEle.click();
	//since the control is present inside the frame it will throw NOSuchFrameException
	driver.switchTo().defaultContent();
	driver.switchTo().frame("classFrame");
	
	WebElement instanceOption = driver.findElement(By.linkText("Instance Methods"));
	wait.until(ExpectedConditions.elementToBeClickable(instanceOption));
	instanceOption.click();
	//quit() will close the session even when the control is present Inside the frame
	driver.quit();
	}
}