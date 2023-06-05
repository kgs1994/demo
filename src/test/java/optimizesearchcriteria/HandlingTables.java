package optimizesearchcriteria;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingTables {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.get("https://irctc.com/contact.html");
	driver.findElement(By.xpath("//div[@id='heading-9']//a[contains(.,'IRCTC')]")).click();
	WebElement parentTableEle = driver.findElement(By.tagName("table"));
	List<WebElement> tableFirstColoumn = parentTableEle.findElements(By.xpath("//tr/td[@data-title='Name'] | //thead//th[1]"));
	for (WebElement tableCell : tableFirstColoumn) {
		String tableCellData = tableCell.getText();
		System.out.println(tableCellData);
	}
	System.out.println(ExpectedConditions.visibilityOf(parentTableEle));
	wait.until(ExpectedConditions.visibilityOf(parentTableEle));
	driver.manage().window().minimize();
	driver.quit();
	
	
}
}