package week4Activity;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;


public class FlightSearch {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions Options=new ChromeOptions();
	      Options.addArguments("--disable-notifications");
		    ChromeDriver driver=new ChromeDriver(Options);	
		    driver.get("https://www.irctc.co.in/nget/train-search");
		    driver.manage().window().maximize();
            driver.findElement(By.xpath("//button[text()='OK']")).click();
            driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
            Set<String> Windows1=driver.getWindowHandles();
       
            List<String> windows=new ArrayList<String>(Windows1);
            driver.switchTo().window(windows.get(1));
            System.out.println(driver.getTitle());
            driver.close();
		
	}

}
