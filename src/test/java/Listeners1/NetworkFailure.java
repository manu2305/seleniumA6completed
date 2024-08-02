package Listeners1;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NetworkFailure {
@Test(retryAnalyzer = com.crm.Listeners1.RetryNetwork.class)
public void executeOneMoreTime() {
	String expected_outPut="https://demowebshop.tricentis.com/";
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://demowebshop.tricentis.com/");
	String actual_outPut = driver.getCurrentUrl();
	assertEquals(expected_outPut, actual_outPut);	
}
}
