package screenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementScreenshot {
public static void main(String[] args) throws IOException  {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.get("https://www.goldenchariot.org/");
	WebElement goldenChariotLogo = driver.findElement(By.cssSelector("img[src='assets/img/logo.png']"));
	//Since WebElement has got extended to
	File tempFile = goldenChariotLogo.getScreenshotAs(OutputType.FILE);
	File destFile = new File("./errorshots/goldenchariotLogo"+LocalDateTime.now().toString().replace(':', '-')+".png");
	FileUtils.copyFile(tempFile, destFile);
	driver.manage().window().minimize();
	driver.quit();
	
	
	
	
}
}