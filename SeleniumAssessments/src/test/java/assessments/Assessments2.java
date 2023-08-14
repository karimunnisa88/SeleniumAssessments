package assessments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assessments2 {

	WebDriver driver;
	@BeforeTest
	public void launchApp() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium-apps.doselect.in/age-calculator/");	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}	
	
	@Test
	public void operation() throws InterruptedException
	{
		Thread.sleep(3);
		driver.findElement(By.id("birth_date")).sendKeys("12/01/1998");
		driver.findElement(By.id("calculate")).click();
		Thread.sleep(3);
		driver.findElement(By.xpath("//div[@id='main_container']/child::div//input")).sendKeys("26/02/2000");
		driver.findElement(By.xpath("//div[@id='main_container']/child::div[text()='Calculate your age']")).click();
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3);
		driver.close();
	}
}
