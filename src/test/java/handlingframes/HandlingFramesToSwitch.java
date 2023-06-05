package handlingframes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingFramesToSwitch {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
	driver.switchTo().frame("iframeResult").switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Iframe Example']")));
	String innerFrameText = driver.findElement(By.tagName("h1")).getText();
	System.out.println("innerFrameText = " + innerFrameText);
	driver.switchTo().parentFrame();
	String outerFrametext = driver.findElement(By.xpath("//body/p")).getText();
	System.out.println("outerFrametext = " + outerFrametext);
	
}
}
