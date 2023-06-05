package methodsofwebelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
//Chrome
public class UsageOfGetCssValue {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	WebElement loginButton = driver.findElement(By.name("login"));
	String loginButtonBackgroundColorrgb = loginButton.getCssValue("background-color");
	System.out.println("loginButtonBackgroundColorrgb = " + loginButtonBackgroundColorrgb);
	String loginButtonBackgroundColorHexedecimal = Color.fromString(loginButtonBackgroundColorrgb).asHex();
	System.out.println("loginButtonBackgroundColorHexedecimal = " + loginButtonBackgroundColorHexedecimal);
	String loginButtonFontFamily = loginButton.getCssValue("font-family");
	System.out.println("loginButtonFontFamily = " + loginButtonFontFamily);
	String loginButtontextFontSize = loginButton.getCssValue("font-size");
	System.out.println("loginButtontextFontSize = " + loginButtontextFontSize );
	String createPageFontBoldNess = driver.findElement(By.linkText("Create a Page")).getCssValue("font-weight");
	System.out.println("createPageFontBoldNess = " + createPageFontBoldNess);
	driver.manage().window().minimize();
	driver.quit();
}
}