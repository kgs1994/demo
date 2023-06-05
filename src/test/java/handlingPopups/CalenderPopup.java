package handlingPopups;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalenderPopup {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.get("https://www.cleartrip.com/");
	//Hidden Division Popup
	driver.findElement(By.cssSelector("svg[class=' c-pointer c-neutral-900']")).click();
	WebElement calenderButton = driver.findElement(By.xpath("//div[text()='Return']/../..//div[contains(@class,'c-inherit flex')]"));
	calenderButton.click();
	//WebElement selectedDate = driver.findElement(By.xpath("//div[@aria-label='Sun Oct 30 2022']"));
	//selectedDate.click();
	WebElement rightArrow = driver.findElement(By.xpath("//*[@data-testid='rightArrow']"));
	new Actions(driver).click(rightArrow).pause(Duration.ofSeconds(1)).click(rightArrow).pause(Duration.ofSeconds(1)).click(rightArrow).pause(Duration.ofSeconds(1)).build().perform();
	driver.findElement(By.xpath("//div[@aria-label='Tue Feb 14 2023']")).click();
	
}
}