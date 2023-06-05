package methodsofwebelement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TopAlignment {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.myntra.com/");
	List<WebElement> menuOptions = driver.findElements(By.className("desktop-navLink"));
	
		System.out.println("menuOptions Count = " + menuOptions.size());
	for (WebElement option : menuOptions) {
		String eleName = option.findElement(By.tagName("a")).getText();
		int optionStartY = option.getRect().getY();
		System.out.println("optionStartY = " + optionStartY );
		if (optionStartY==30) {
			System.out.println("Pass: The Top Alignment "+eleName+" is found correct and verified.");	
		}else {
			System.out.println("Fail: The Top Alignment  "+ eleName+" is found incorrect and verified.");
		}
}
	driver.manage().window().minimize();
	driver.quit();
}
}