package Morning;
/*
 * WebDriverManager.chromedriver().setup();
ChromeOptions option = new ChromeOptions();
option.addArguments("--disable-notifications");
ChromeDriver driver = new ChromeDriver(option);

WebElement clk = driver.findElement(By.xpath("//a[@title='Individuals']//span[1]"));
driver.executeScript("arguments[0].click();", clk);
*/
		
import java.time.Duration;

import org.bson.BsonJavaScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOpportunity {

	public static void main(String[] args) {
		//Freeze the dom: setTimeout(function(){debugger;}, 5000)
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver oppChromeDriver = new ChromeDriver(option);
		oppChromeDriver.get("http://login.salesforce.com");
		oppChromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		oppChromeDriver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		oppChromeDriver.findElement(By.id("password")).sendKeys("Testleaf$321");
		oppChromeDriver.findElement(By.id("Login")).click();
		
		oppChromeDriver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		oppChromeDriver.findElement(By.xpath("//button[text()='View All']")).click();
		
	    WebElement jsclickElement= oppChromeDriver.findElement(By.xpath("//p[text()='Opportunities']"));
	    oppChromeDriver.executeScript("arguments[0].click();", jsclickElement);
	    
	    oppChromeDriver.findElement(By.xpath("//a[@title='New']")).click();
	    WebElement nameOwner =  oppChromeDriver.findElement(By.xpath("//input[@name='Name']"));
	    nameOwner.sendKeys("Salesforce Automation by Kaleeswari");
	    String nameOwnerString = nameOwner.getAttribute("value");
	    System.out.println(nameOwnerString);
	    //setTimeout(function(){debugger;}, 5000)
	    oppChromeDriver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("11/2/2022");
	    oppChromeDriver.findElement(By.xpath("//button/span[text()='--None--']")).click();
	    oppChromeDriver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
	    oppChromeDriver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	    String gettit = oppChromeDriver.findElement(By.xpath("//slot[@name='primaryField']/lightning-formatted-text")).getText();
	    System.out.println("Title:" + gettit);
	    if (gettit.equals(nameOwnerString))
	    	System.out.println("Name of the owner is " +gettit);
	    else 
			System.out.println("Owner not matched");
			
		 
		
	}

}
