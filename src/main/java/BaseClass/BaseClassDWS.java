package BaseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class BaseClassDWS {
	
	public static WebDriver driver;
		
@BeforeClass
public void precondition() throws IOException {
	String browser = JavaUtility.logindata("browser");
	String url = JavaUtility.logindata("url");
	 if(browser.equals("chrome")) {
		 driver=new ChromeDriver();
	 }
	 else if (browser.equals("edge")) {
		driver=new EdgeDriver();
	}
	 else if(browser.equals("firefox")) {
		 driver=new FirefoxDriver();
	 }
	 else {
		 driver=new ChromeDriver();
	 }
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get(url);
}
@BeforeMethod
public void login() throws IOException {
	String username = JavaUtility.logindata("username");
	String password = JavaUtility.logindata("password");
	driver.findElement(By.className("ico-login")).click();
	driver.findElement(By.id("Email")).sendKeys(username);
	driver.findElement(By.id("Password")).sendKeys(password);
	driver.findElement(By.xpath("//input[@value='Log in']")).click();
}
@AfterMethod
public void logout() {
	driver.findElement(By.className("ico-logout")).click();
}
@AfterClass
public void postCondition() {
	driver.quit();
}
}












