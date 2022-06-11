package Week4;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class WindowHandling {

	public static void main(String[] args)  {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
	    driver.findElement(By.className("decorativeSubmit")).click();
	    driver.findElement(By.linkText("CRM/SFA")).click();
	    driver.findElement(By.linkText("Contacts")).click();
	    driver.findElement(By.xpath("//li/a[text()='Merge Contacts']")).click();
	    driver.findElement(By.xpath("//a/img[@alt='Lookup']")).click();
		
	   Set<String> windowHandles = driver.getWindowHandles();
	   List<String> newWindow=new ArrayList<String>(windowHandles);
	   driver.switchTo().window(newWindow.get(1));
	   driver.findElement(By.xpath("//a[@class='linktext'][1]")).click();
	   driver.switchTo().window(newWindow.get(0));  
		
	   driver.findElement(By.xpath("//table[@name='ComboBox_partyIdTo']/following-sibling::a")).click();
	   Set<String> windowHandles1 = driver.getWindowHandles();
    	List<String> newWindow1=new ArrayList<String>(windowHandles1);
	    driver.switchTo().window(newWindow1.get(1));	
		driver.findElement(By.xpath("//td//a[@class='linktext']")).click();
		driver.switchTo().window(newWindow1.get(0));
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String title = driver.getTitle();
		System.out.println(title);
	   
	   
	}

	}


