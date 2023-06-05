package classaction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDropProgramme {
public static void main(String[] args) {
	ChromeOptions chromeOptions = new ChromeOptions();
	 chromeOptions.addArguments("--remote-allow-origins=*");
	 WebDriver driver = new ChromeDriver(chromeOptions);
	Actions actions = new Actions(driver);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.get("https://trello.com/");
	WebElement loginOption = driver.findElement(By.linkText("Log in"));
	loginOption.click();
	wait.until(ExpectedConditions.visibilityOf(driver.switchTo().activeElement()));
	driver.switchTo().activeElement().sendKeys("peoplefortiptur@gmail.com");
	WebElement loginContinueButton = driver.findElement(By.id("login"));
	loginContinueButton.click();
	wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
	driver.switchTo().activeElement().sendKeys("9886947924");
	WebElement loginButton = driver.findElement(By.id("login-submit"));
	loginButton.submit();
	WebElement dragAndDropStarredBoard = driver.findElement(By.xpath("//h3[text()='Starred boards']/../..//div[text()='DragAndDrop']"));
	wait.until(ExpectedConditions.elementToBeClickable(dragAndDropStarredBoard));
	dragAndDropStarredBoard.click();
	
	 WebElement listSrc = driver.findElement(By.xpath("//h2[text()='TO DO']/ancestor::div[@class='js-list list-wrapper']"));
	WebElement listDest = driver.findElement(By.xpath("//h2[text()='Completed']/ancestor::div[@class='js-list list-wrapper']")); 
	WebElement cardtoDrag = driver.findElement(By.xpath("//span[text()='WebElements']/ancestor::div[@class='list-card-details js-card-details']"));
	  actions.clickAndHold(cardtoDrag).pause(Duration.ofSeconds(3)).dragAndDrop(listSrc, listDest).release().perform();
	 
	}
}