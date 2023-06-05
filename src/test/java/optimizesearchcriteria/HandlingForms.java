package optimizesearchcriteria;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingForms {
public static void main(String[] args) {
	ChromeOptions chromeOptions = new ChromeOptions();
	chromeOptions.addArguments("--remote-allow-origins=*");
	WebDriver driver = new ChromeDriver(chromeOptions);
	  
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.get("https://demo.vtiger.com/vtigercrm/index.php");
	//Handling the forms
	WebElement parentFormEle = driver.findElement(By.xpath("//div[@id='loginFormDiv']/form[@class='form-horizontal']"));
	WebElement usernameTextField = parentFormEle.findElement(By.id("username"));
	usernameTextField.clear();
	usernameTextField.sendKeys("admin");
	WebElement passwordTextField = parentFormEle.findElement(By.id("password"));
	passwordTextField.clear();
	passwordTextField.sendKeys("Test@123");
	WebElement signInButton = parentFormEle.findElement(By.cssSelector("button[class='button buttonBlue']"));
	signInButton.submit();
	if (wait.until(ExpectedConditions.titleIs("Dashboard"))) {
		driver.findElement(By.xpath("//li[@class='dropdown']")).click();
		WebElement signOutOption = driver.findElement(By.cssSelector("a[id='menubar_item_right_LBL_SIGN_OUT']"));
		//wait.until(ExpectedConditions.visibilityOf(signOutOption));
		if(signOutOption.isDisplayed()){
			System.out.println("Pass: The Dashboard page Is displayed upon signIn");
			signOutOption.click();
		}else {
			System.out.println("Fail: The DashBoard Page is not displayed upon SignIn");
		}
	}else {
		System.out.println("Fail: The Dashboard page is not displayed henceforth it will not proceed further for signOut.");
	}
	driver.manage().window().minimize();
	driver.quit();	
}
}