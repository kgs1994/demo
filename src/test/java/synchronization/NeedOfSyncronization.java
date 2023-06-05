package synchronization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NeedOfSyncronization {
public static void main(String[] args) throws Exception {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.get("https://demo.actitime.com/");
	WebElement usernametextField = driver.findElement(By.id("username"));
	usernametextField.clear();
	usernametextField.sendKeys("admin");
	WebElement passwordtextField = driver.findElement(By.name("pwd"));
	passwordtextField.clear();
	passwordtextField.sendKeys("manager");
	WebElement loginButton = driver.findElement(By.id("loginButton"));
	loginButton.click();

	String expectedHomePageTitle = "actiTIME - Enter Time-Track";
	System.out.println("expectedHomePageTitle = " + expectedHomePageTitle);
	//Thread.sleep(5000);
	wait.until(ExpectedConditions.titleIs(expectedHomePageTitle));
	String actualHomePageTitle = driver.getTitle();
	System.out.println("actualHomePageTitle = " + actualHomePageTitle );
	String expectedHomePageUrl = "https://demo.actitime.com/user/submit_tt.do";
	System.out.println("expectedHomePageUrl = " + expectedHomePageUrl);
	String actualHomePageUrl = driver.getCurrentUrl();
	System.out.println("actualHomePageUrl = " + actualHomePageUrl );
	//Thread.sleep(5000);
	WebElement logoutOption = driver.findElement(By.id("logoutLink"));
	if (wait.until(ExpectedConditions.titleIs(expectedHomePageTitle))) {
		System.out.println("Pass: HomePage Upon Title");
		if (wait.until(ExpectedConditions.urlToBe(expectedHomePageUrl))) {
			System.out.println("Pass: HomePage Upon URL");
			if (logoutOption.isDisplayed()) {
				System.out.println("Pass: Home Page is displayed upon clicking on the login Button.");
			}else {
				System.out.println("Fail: Home Page is not displayed upon verifying logout option visibility.");
			}
		}else {
			System.out.println("Fail: The Home page is not displayed upon verifying it's URL.");
		}
	}else {
		System.out.println("Fail: The Homepage Is not displayed upon verifying it's title.");
	}
	logoutOption.click();
	driver.manage().window().minimize();
	driver.quit();
}
}