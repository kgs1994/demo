package Tek.tek;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class task {

	public static void main(String[] args) throws IOException, Throwable {
		String filepath = "";
		FileInputStream fis = new FileInputStream(filepath);
		Workbook workbook = WorkbookFactory.create(fis);
		
		String url = workbook.getSheet("").getRow(1).getCell(0).getStringCellValue();
		String username = workbook.getSheet("").getRow(1).getCell(1).getStringCellValue();
		String password = workbook.getSheet("").getRow(1).getCell(2).getStringCellValue();
		
		//to check whether am im getting proper input from the file
		System.out.println("url of app is "+url);
		System.out.println("username textfield data is "+username);
		System.out.println("password textfield data is "+password);
		
		// write the test script then use above data
		
		 ChromeOptions chromeOptions = new ChromeOptions();
		 chromeOptions.addArguments("--remote-allow-origins=*");
		 WebDriver driver = new ChromeDriver(chromeOptions);
		 driver.manage().window().maximize();
		 //send the url from above data fetched from excel
		 driver.get(url);
		 
		 driver.findElement(By.id("username")).sendKeys(username);
		 driver.findElement(By.name("pwd")).sendKeys(password);
		 
		 Thread.sleep(5000);
		 
		 driver.quit();
		 
		 
		 
		 
		 
		 
		 
		 
		

	}

}
