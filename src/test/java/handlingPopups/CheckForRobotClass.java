package handlingPopups;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckForRobotClass {
public static void main(String[] args) throws AWTException, Throwable  {
	 ChromeOptions chromeOptions = new ChromeOptions();
	 chromeOptions.addArguments("--remote-allow-origins=*");
	 WebDriver driver = new ChromeDriver(chromeOptions);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//JavascriptExecutor jse = (JavascriptExecutor)driver;
	driver.get("https://www.monsterindia.com/seeker/registration");
	
	WebElement uploadFiles=driver.findElement(By.className("contentTitle"));
	
	String fileName = "C:\\Users\\HP\\Desktop\\acticommondata1.txt";
	//It is selecting the target file address in the form of String reference file address
	//for further file upload
	//StringSelection Will convert the given String FileName into the format which can be
	//uploaded. 
	StringSelection content = new StringSelection(fileName);
	//ToolKit is an Abstarct Super class of Java which provides an Interface to
	// speak with the host computer OS i.e. at this level we can interact to 
	//handle the Fileupload popup window
	Toolkit toolKit = Toolkit.getDefaultToolkit();
	//A clipboard is a temporary storage area for data that the user wants to 
	//copy from one place to another
	//My Computer Clipboard which will have the current instance of current 
	//popup window(temp) clipboard
	//call the getSystemClipBoard() which will return the ClipBoard class object
	Clipboard clipBoard = toolKit.getSystemClipboard();
	//set the fileAddress copy ready for further use done by Java
	clipBoard.setContents(content, null);
	System.out.println("File Selection =  "+ content);
	uploadFiles.click();
	Robot robot=new Robot();
	//robot.keyPress(KeyEvent.VK_ENTER);
  //robot.keyRelease(KeyEvent.VK_ENTER);
  	Thread.sleep(1000);
  	//virtual Key VK
  	robot.keyPress(KeyEvent.VK_CONTROL);
  	robot.keyPress(KeyEvent.VK_V);
  	Thread.sleep(1000);
  	robot.keyRelease(KeyEvent.VK_CONTROL);
  	robot.keyRelease(KeyEvent.VK_V);
  	Thread.sleep(1000);
  	robot.keyPress(KeyEvent.VK_ENTER);
  	robot.keyRelease(KeyEvent.VK_ENTER);
	}
}