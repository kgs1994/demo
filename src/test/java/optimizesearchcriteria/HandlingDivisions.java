package optimizesearchcriteria;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingDivisions {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.get("https://www.amazon.in/");
	WebElement menuContainer = driver.findElement(By.xpath("//div[@id='nav-xshop-container']"));
	List<WebElement> menuOptions = menuContainer.findElements(By.tagName("a"));
	//System.out.println(menuOptions.size());
	for (WebElement opt : menuOptions) {
		String optText = opt.getText();
		if (optText.isEmpty()) {
			//System.out.println("Not Loaded and it is empty");
		}else if(opt.isDisplayed()) {
			System.out.println(optText);
		}

	}
	driver.manage().window().minimize();
	driver.quit();
}
}