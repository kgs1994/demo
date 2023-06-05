package methodsofwebelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GetTagName {
public static void main(String[] args) throws Throwable {
	//Set The driver execuatble path

	//Instantiate The browser specific class 
	 ChromeOptions chromeOptions = new ChromeOptions();
	 chromeOptions.addArguments("--remote-allow-origins=*");
	 WebDriver driver = new ChromeDriver(chromeOptions);
	//maximize the browser
	driver.manage().window().maximize();
	//pass the main URL 
	driver.get("https://demo.actitime.com/");
	Thread.sleep(5000);
	WebElement usernameTextField = driver.findElement(By.id("username"));
	if (usernameTextField.getTagName().equals("input")) {
		System.out.println("Boolean True");
		System.out.println("Pass: The USername text field element tagname is correct and verified.");
		usernameTextField.clear();
		usernameTextField.sendKeys("admin");
	}else {
		System.out.println("boolean false");
		System.out.println("Fail: The username text field element tagname Is incorrect and verified.");
	}
	Thread.sleep(5000);
	WebElement keepMeLoggedInCheckbox = driver.findElement(By.id("keepLoggedInCheckBox"));
	if (keepMeLoggedInCheckbox.getTagName().equals("input")) {
		System.out.println("Boolean True");
		System.out.println("Pass: The Check Box tagname Is correct and verified.");
		keepMeLoggedInCheckbox.click();
	}else {
		System.out.println("Boolean False");
		System.out.println("Fail: The checkbox tagname is incorrect and verified");
	}
	Thread.sleep(5000);
	WebElement loginButton = driver.findElement(By.id("loginButton"));
	if (loginButton.getTagName().equals("button")) {
		System.out.println("Boolean true");
		System.out.println("Pass: Button TagName is correct and it is verified");
		loginButton.click();
	}else {
		System.out.println("boolean false");
		System.out.println("Fail: Button tagname Is incorrect and it is verified and action will not Be performed on the element.");
	}
	Thread.sleep(5000);
	driver.manage().window().minimize();
	driver.quit();
}
}