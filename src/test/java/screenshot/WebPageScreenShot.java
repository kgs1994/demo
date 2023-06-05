package screenshot;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebPageScreenShot {
public static void main(String[] args) throws Throwable {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.get("https://www.goldenchariot.org/");
	//WebPageScreen Shot - driver
	//downcast driver WebDriver - TakesScreenShot
	TakesScreenshot ts = (TakesScreenshot)driver;
	//Call the getScreenShotAs() - No Return Type
	//OutType is a Selenium Interface - Static and Final Variables
	//FILE - Return Type File - Java Class
	//Base64 - Return Type String - Java Class 
	//BYTES - byte[] 
	  File tempFile = ts.getScreenshotAs(OutputType.FILE);
	  
	  System.out.println(tempFile.getAbsolutePath());
	  //Capturing the LOcal Date Time for the unique file Name
	  //Replace the Special Char which is compatible with Windows OS
	  //Convert to String and Replace the Character in the STring
	  String timeStamp = LocalDateTime.now().toString().replace(':', '-');
	  //Create a File Object - Input for copyFIle(File srcFile, File destFile) - void
	  //File(String Pathname ) - File Class Constructor
	  File destFile = new File("./errorshots/goldenchariot"+timeStamp+".png");
	  //Call the FileUtils CLass from commons-io Library
	  //Call the Static CopyFile() - it will copy the file to the target location
	  //public void copyFile(File srcFile, File destFile) 
	  FileUtils.copyFile(tempFile, destFile);
	  driver.manage().window().minimize();
	  driver.quit();
	}
}