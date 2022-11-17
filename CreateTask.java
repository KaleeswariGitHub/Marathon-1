package Morning;

import java.time.Duration;

import org.bson.BsonJavaScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.internal.invokers.AbstractParallelWorker.Arguments;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateTask {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions taskOption = new ChromeOptions();
		taskOption.addArguments("--disable-notifications");
		ChromeDriver taskChromeDriver = new ChromeDriver(taskOption);
		taskChromeDriver.get("http://login.salesforce.com");
        taskChromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		taskChromeDriver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		taskChromeDriver.findElement(By.id("password")).sendKeys("Testleaf$321");
		taskChromeDriver.findElement(By.id("Login")).click();
	
		WebElement globalActionElement = taskChromeDriver.findElement(By.xpath("//a[contains(@class,'globalCreateTrigger')]"));
		Thread.sleep(3000);
		taskChromeDriver.executeScript("arguments[0].click();", globalActionElement);
		taskChromeDriver.findElement(By.xpath("//a[@title='New Task']//span[text()='New Task']")).click();
	    WebElement giveNameEle =	taskChromeDriver.findElement(By.xpath("//input[@id='combobox-input-105']"));
	    giveNameEle.sendKeys("BootCamp");
	    String giveNameString = giveNameEle.getAttribute("value");
		taskChromeDriver.findElement(By.xpath("//a[text()='Not Started']")).click();
		taskChromeDriver.findElement(By.xpath("//a[@title='Waiting on someone else']")).click();
		WebElement taskClick = taskChromeDriver.findElement(By.xpath("//span[text()='Save']"));
		taskChromeDriver.executeScript("arguments[0].click();",taskClick);
		String dispTitleString = taskChromeDriver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']/a")).getText();
	    System.out.println("The title: " + dispTitleString);
	    
	    if (giveNameString.equals(dispTitleString))
	    	System.out.println("Name is: " + dispTitleString);
	    else
	    	System.out.println("Given name is mismatched");
		
	}

}
