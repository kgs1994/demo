package handlingdropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllMonthOptionSelectableState {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.get("https://www.facebook.com/signup");
	Select daySelect = new Select(driver.findElement(By.id("day")));
	List<WebElement> allDayOptions = daySelect.getOptions();
	System.out.println("No of Day Options = " + allDayOptions.size());
	for (WebElement dayOptionEle : allDayOptions) {
		String dayVisisbleText = dayOptionEle.getText();
		daySelect.selectByVisibleText(dayVisisbleText);
		if (dayOptionEle.isSelected()) {
			System.out.println("Pass: The Day "+dayVisisbleText+" Selected");
		}else {
			System.out.println("Fail: The Day " +dayVisisbleText + " not Selected");
		}
	}
	
	Select monthSelect = new Select(driver.findElement(By.id("month")));
	List<WebElement> allMonthOptions = monthSelect.getOptions();
	System.out.println("No of Month Options = " + allMonthOptions.size());
	for (WebElement monthOptionEle : allMonthOptions) {
		String monthVisibleText = monthOptionEle.getText();
		monthSelect.selectByVisibleText(monthVisibleText);
		if(monthOptionEle.isSelected()) {
			System.out.println("Pass: The Month "+monthVisibleText+ " has got selected.");
		}else {
			System.out.println("Fail: The Month "+monthVisibleText+ " has not got selected.");
		}
	}
	
	Select yearSelect = new Select(driver.findElement(By.id("year")));
	List<WebElement> allYearOptions = yearSelect.getOptions();
	System.out.println("No Of year Options =  " + allYearOptions.size());
	for (WebElement yearOptionEle : allYearOptions) {
		yearSelect.selectByVisibleText(yearOptionEle.getText());
		if (yearOptionEle.isSelected()) {
			
		}else {
			System.out.println(yearOptionEle.getText()+ " Option Not Selected");
		}
	}
	driver.manage().window().minimize();
	driver.quit();
}
}