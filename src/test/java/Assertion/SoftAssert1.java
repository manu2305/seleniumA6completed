package Assertion;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class SoftAssert1 {
@Test
public void dwspage() {
	String expected_url="https://demowebshop.tricentis.com/";
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.navigate().to("https://demowebshop.tricentis.com/");
	String actual_url = driver.getCurrentUrl();
	//assertEquals(expected_url, actual_url);
	SoftAssert soft=new SoftAssert();
	soft.assertNotEquals(expected_url, actual_url,"url is not matching");
	WebElement search_field = driver.findElement(By.id("small-searchterms"));
	search_field.sendKeys("mobile",Keys.ENTER);
	WebElement advance_search = driver.findElement(By.id("As"));
	//advance_search.click();
	soft.assertTrue(advance_search.isSelected(),"element is not selected");
	soft.assertAll();
	driver.findElement(By.id("Isc")).click();
	
	
}
}
