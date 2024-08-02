package Basic;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShopperShack {
public static void main(String[] args) {
	String[]s= {"mani","balan","7358001010","mani@gmail.com","mani2305","mani2305"};
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://www.shoppersstack.com/signup");
	 List<WebElement> text_field = driver.findElements(By.xpath("//form[@class='signup_signupForm__zYAG9']/div/div/div/input"));
	int i=0;
	for (WebElement web : text_field) {
		web.sendKeys(s[i++]);
	}
}
}
