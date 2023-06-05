package handlingframes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingNestedFrames {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.get("https://demo.automationtesting.in/Frames.html");
	driver.findElement(By.linkText("Iframe with in an Iframe")).click();
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']")));
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']")));
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Selenium");
	driver.switchTo().defaultContent();
	driver.findElement(By.partialLinkText("Single Iframe")).click();
}
}
