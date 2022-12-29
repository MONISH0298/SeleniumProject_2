package MakeMyTrip;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeMyTrip_Project {


	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.navigate().to("https://www.makemytrip.com/flights");
		Thread.sleep(2000);
		
		
		//driver.findElement(By.xpath("/html/body/div/div[2]/div/div/a/i")).click();
		

		
		WebElement login = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[1]/ul/li[4]"));
		login.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div/div/nav/ul/li[1]/div/a/span[2]"))
				.click();
		driver.findElement(By.id("fromCity")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input")).sendKeys("chennai");
		Thread.sleep(3000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		
		r.keyRelease(KeyEvent.VK_ENTER);

		driver.findElement(By.id("toCity")).click();
		driver.findElement(
				By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div[1]/input"))
				.sendKeys("Mumbai");
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		driver.findElement(By.xpath("//span[contains(text(),'DEPARTURE')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='DayPicker-Day'][contains(@aria-label, 'Dec 27 2022')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[contains(text(),'RETURN')]")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='DayPicker-Day'][contains(@aria-label, 'Dec 29 2022')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[contains(text(),'Search')]")).click();

		Thread.sleep(5000);
		Actions builder = new Actions(driver);
		WebElement radiobtn = driver.findElement(By.xpath("//span[@class='customRadioBtn']"));
		builder.click(radiobtn).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/button[1]"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();

		Thread.sleep(3000);

		String parent = driver.getWindowHandle();

		Set<String> allWindows = driver.getWindowHandles();

		ArrayList<String> tabs = new ArrayList<>(allWindows);
		driver.switchTo().window(tabs.get(1));

		Thread.sleep(7000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,1000)");
		
		Thread.sleep(3000);
	
		
		WebElement adult = driver.findElement(By.xpath("//button[contains(text(),'+ ADD NEW ADULT')]"));
		builder.click(adult).build().perform();
		Thread.sleep(3000);
		WebElement yesButton = driver.findElement(By.xpath("//*[@id=\'INSURANCE\']/div/div[3]/div[1]/label/span[1]"));
		builder.click(yesButton).build().perform();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@placeholder='First & Middle Name']")).sendKeys("Monishkumar");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("R A");
		Thread.sleep(2000);
		WebElement male = driver.findElement(By.xpath("//*[@id=\'wrapper_ADULT\']/div[2]/div[2]/div/div[2]/div/div/div[3]/div/div/label[1]"));
		builder.click(male).build().perform();

		Thread.sleep(3000); 
		driver.findElement(By.xpath("//input[@placeholder='Mobile No']")).sendKeys("9789642501");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("monish.contact@gmail.com");
		Thread.sleep(2000);
		js.executeScript("window.scroll(0,3000)");
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement continueBtn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Continue')]")));
		continueBtn.click();
		
		
//		 WebElement confirmButton =driver.findElement(By.xpath("//button[contains(text(),'CONFIRM')]"));
//		 builder.click(confirmButton).build().perform();

	}

}