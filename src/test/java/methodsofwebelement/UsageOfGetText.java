package methodsofwebelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsageOfGetText {
public static void main(String[] args) throws Throwable {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	Thread.sleep(2000);
	String expectedFacebookTagLineText = "facebook helps you connect and share with the people in your life.";
	System.out.println("expectedFacebookTagLineText = " + expectedFacebookTagLineText);
	WebElement facebookTagLine = driver.findElement(By.className("_8eso"));
	String actualFacebookTagLineText = facebookTagLine.getText();
	System.out.println("actualFacebookTagLineText = " + actualFacebookTagLineText );
	if (expectedFacebookTagLineText.equals(actualFacebookTagLineText)) {
		System.out.println("Pass: The TagLine text is found correct upon verification.");
	}else {
		System.out.println("Fail: The TagLine text is found incorrect upon verification.");
	}
	driver.manage().window().minimize();
	driver.quit();
}
}