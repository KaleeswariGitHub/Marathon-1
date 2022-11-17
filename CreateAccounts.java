package Morning;

import java.time.Duration;
import org.bson.BsonJavaScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.internal.invokers.AbstractParallelWorker.Arguments;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Explicit;

public class CreateAccounts {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver oppChromeDriver = new ChromeDriver(option);
		
		oppChromeDriver.get("http://login.salesforce.com");
		oppChromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		oppChromeDriver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		oppChromeDriver.findElement(By.id("password")).sendKeys("Testleaf$321");
		oppChromeDriver.findElement(By.id("Login")).click();
		
		oppChromeDriver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		oppChromeDriver.findElement(By.xpath("//button[text()='View All']")).click();
		
		WebElement jsclickElement= oppChromeDriver.findElement(By.xpath("//p[text()='Accounts']"));
	    oppChromeDriver.executeScript("arguments[0].click();", jsclickElement);
	    oppChromeDriver.findElement(By.xpath("//a[@class='forceActionLink']/div")).click();
 
	   WebElement getInputNamElement = oppChromeDriver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow']/input[@name='Name']"));
	   getInputNamElement.sendKeys("Kaleeswari");
	   String getInNameString = getInputNamElement.getAttribute("value");
	    WebElement findElement4 = oppChromeDriver.findElement(By.xpath("//button[@type='button'][@data-value='--None--'][@aria-label='Ownership, --None--']"));
        oppChromeDriver.executeScript("arguments[0].click();", findElement4);
        Thread.sleep(3000);
         WebElement findElement5 = oppChromeDriver.findElement(By.xpath("//span[@title='Public']"));
        oppChromeDriver.executeScript("arguments[0].click();", findElement5);
         oppChromeDriver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
       String getAccountNameTitleString = oppChromeDriver.findElement(By.xpath("//lightning-formatted-text[@class='custom-truncate']")).getText();
       System.out.println(getAccountNameTitleString);
       
       if(getInNameString.equals(getAccountNameTitleString))
    	   System.out.println("The given title is matched. " +getAccountNameTitleString);
       else
    	   System.out.println("the given title is not matched with input");
	    
	
	}
	

}
