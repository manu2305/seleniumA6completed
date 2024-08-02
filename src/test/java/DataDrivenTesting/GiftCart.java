package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BaseClass.DwsBase;
public class GiftCart extends DwsBase {
	public static ArrayList<String> readExcel() throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("D:\\TestData\\GiftCartTestCase.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		int row = sheet.getPhysicalNumberOfRows();
		int colom = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(row);
		System.out.println(colom);
		ArrayList<String> arr=new ArrayList<String>();
		for (int i = 0; i <row; i++) {
			arr.add(sheet.getRow(i).getCell(0).toString());	
		}
		return arr;
	}
public static void main(String[] args) throws InterruptedException, IOException {
	int i=0;
	preCondition();
	Thread.sleep(1000);
    login();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
    Thread.sleep(1000);
    ArrayList<String> data = readExcel();
    System.out.println(data);
    driver.findElement(By.id("giftcard_2_RecipientName")).sendKeys(data.get(i++));
    Thread.sleep(1000);
    driver.findElement(By.id("giftcard_2_RecipientEmail")).sendKeys(data.get(i++));
    Thread.sleep(1000);
    WebElement senderName = driver.findElement(By.id("giftcard_2_SenderName"));
    senderName.clear();
    senderName.sendKeys(data.get(i++));
    Thread.sleep(1000);
    WebElement senderEmail = driver.findElement(By.id("giftcard_2_SenderEmail"));
    senderEmail.clear();
    senderEmail.sendKeys(data.get(i++));
    Thread.sleep(1000);
    driver.findElement(By.id("giftcard_2_Message")).sendKeys(data.get(i++));
    Thread.sleep(1000);
    WebElement quantity = driver.findElement(By.id("addtocart_2_EnteredQuantity"));
    quantity.clear();
    double value = Double.parseDouble(data.get(i++));
    int d=(int)value;
    String s=""+d;
    System.out.println(s);
    quantity.sendKeys(s); 
    driver.findElement(By.id("add-to-cart-button-2")).click();
    driver.findElement(By.className("cart-label")).click();
    WebElement giftCart = driver.findElement(By.xpath("(//a[text()='$25 Virtual Gift Card'])[2]"));
    if(giftCart.isDisplayed()) {
    	System.out.println("product is added successfully....");
    }
    else {
    	System.out.println("product is not addedd....");
    }
    Thread.sleep(2000);
    postCondition();
}
}
