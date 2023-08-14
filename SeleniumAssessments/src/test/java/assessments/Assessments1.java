package assessments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assessments1 {
	WebDriver driver;
	@BeforeTest
	public void launchApp() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium-apps.doselect.in/change-text/");	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}	
	
	@Test
	public void operation() throws InterruptedException
	{
		driver.findElement(By.id("bigger")).click();
		Thread.sleep(2);
		driver.findElement(By.id("smaller")).click();
		Thread.sleep(2);
		driver.findElement(By.id("reset")).click();
		Thread.sleep(2);
		driver.findElement(By.xpath("//*[text()='Bigger']")).click();
		Thread.sleep(2);
		driver.findElement(By.xpath("//*[text()='Smaller']")).click();
		Thread.sleep(2);
		driver.findElement(By.xpath("//*[text()='Reset']")).click();
		Thread.sleep(3);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
