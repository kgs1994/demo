package handlingdropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TypeOfDropDown {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.get("https://www.facebook.com/signup");
	WebElement monthDropDown = driver.findElement(By.id("month"));
	Select select = new Select(monthDropDown);
	if(select.isMultiple()) {
		System.out.println("Boolean True");
		System.out.println("Fail: The Month DropDown is MultiSelect and it is verified.");
	}else {
		System.out.println("Boolean Flase ");
		System.out.println("Pass: The Month DropDown is Single Select and it is verified.");
	}
	Select daySelect = new Select(driver.findElement(By.id("day")));
	if (daySelect.isMultiple()) {
		System.out.println("Booelan True");
		System.out.println("Fail: Day dropdown is multi Select and verified.");
	}else {
		System.out.println("Booelan False");
		System.out.println("Pass: The Day dropdown is Single Select and verified.");
	}
	if(new Select(driver.findElement(By.id("year"))).isMultiple()) {
		System.out.println("Boolean True");
		System.out.println("Fail: The Year DropDown is Multi-select and verified.");
	}else {
		System.out.println("Boolean False");
		System.out.println("Pass: The Year DropDown is Single Select and verified.");
	}
	
	driver.manage().window().minimize();
	driver.quit();
	
	
	
	
	
	
	
	
	
}
}