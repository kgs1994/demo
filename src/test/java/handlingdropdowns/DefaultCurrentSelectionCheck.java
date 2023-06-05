package handlingdropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DefaultCurrentSelectionCheck {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.get("https://www.facebook.com/signup");
	WebElement dayDropDown = driver.findElement(By.id("day"));
	Select daySelect =  new Select(dayDropDown);
	String defaultDaySelected = daySelect.getFirstSelectedOption().getText();
	System.out.println("defaultDaySelected = " + defaultDaySelected);
	WebElement monthDropDown = driver.findElement(By.id("month"));
	Select monthSelect = new Select(monthDropDown);
	String defaultMonthSelected = monthSelect.getFirstSelectedOption().getText();
	System.out.println("defaultMonthSelected = " + defaultMonthSelected);
	WebElement yearDropDown = driver.findElement(By.id("year"));
	Select yearSelect = new Select(yearDropDown);
	String defaultYearSelected = yearSelect.getFirstSelectedOption().getText();
	System.out.println("defaultYearSelected = " + defaultYearSelected);
	driver.manage().window().minimize();
	driver.quit();
}
}