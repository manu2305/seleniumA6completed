package BaseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DwsBase {
	public static WebDriver driver;
public static void preCondition() throws IOException {
	String browser = JavaUtility.logindata("browser");
	String url = JavaUtility.logindata("url");
	if(browser.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	}
	else if (browser.equalsIgnoreCase("edge")) {
		driver=new EdgeDriver();
	}
	else {
		driver=new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get(url);
	}
public static void login() throws InterruptedException, IOException {
	String username = JavaUtility.logindata("username");
	String password = JavaUtility.logindata("password");
	driver.findElement(By.className("ico-login")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("Email")).sendKeys(username );
	driver.findElement(By.id("Password")).sendKeys(password);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@value='Log in']")).click();
}
public static void postCondition() {
	driver.findElement(By.className("ico-logout")).click();
	driver.quit();
}
}
