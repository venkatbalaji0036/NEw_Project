package seleniumpackage;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium_Operations extends Globals{
	
	WebDriver driver = new FirefoxDriver();
	//WebDriver driver = new ChromeDriver();
	//WebDriver driver = new InternetExplorerDriver();
	
	By StudentName = By.id("input_9_1");
	By StudentEmailId =By.cssSelector("#input_9_2");
	By StudentPhoneNumber = By.xpath("//input[@id='input_9_3']");
	By StudentModeOfTraining = By.name("input_5");
	By StudentState = By.xpath("//input[@id='input_9_16']");
	By SubmitButton = By.id("gform_submit_button_9");
	By HeaderError = By.xpath("//div[@class='validation_error']");
	By FieldError = By.xpath("//div[@class='gfield_description validation_message']");
	
	@Test
	public void Student_Enrollment() throws InterruptedException {
		driver.findElement(StudentName).sendKeys(Data.get("Student_Name"));
		Thread.sleep(3000);
		driver.findElement(StudentEmailId).sendKeys(Data.get("Student_Email_Id"));
		Thread.sleep(3000);
		driver.findElement(StudentPhoneNumber).sendKeys(Data.get("Student_Phone_Number"));
		
		WebElement Mode_Of_Training = driver.findElement(StudentModeOfTraining);
		Select MOT = new Select(Mode_Of_Training);
		MOT.selectByVisibleText(Data.get("Student_Mode_Of_Training"));
		
		driver.findElement(StudentState).sendKeys(Data.get("Student_State"));
		//driver.findElement(By.id("gform_submit_button_9")).click();
		driver.findElement(SubmitButton).sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
		
		String Header_Error = driver.findElement(HeaderError).getText();
		System.out.println(Header_Error);
		if(Header_Error.equals("There was a problem with your submission. Errors have been highlighted below.")) {
			System.out.println("Header error is as per the requirment");
		}else {
			System.out.println("Header error is not as per the requirement");
		}
		
		String Field_Error = driver.findElement(FieldError).getText();
		System.out.println(Field_Error);
		
		if(Field_Error.contains("required")) {
			System.out.println("Error at field is as per the requiremnt");
		}else {
			System.out.println("Error at field is not as per the requriment");
		}
		
	}
	
	@AfterTest
	public void Driver_Close() {
		driver.quit();
	}
	
	
/*	public static void MethodMain() throws InterruptedException, IOException {
		Selenium_Operations obj = new Selenium_Operations();
		obj.Navigate();
		obj.Popup();
		//obj.Radio_Button();
		//obj.Checkbox();
		//obj.Drag_Drop();
		//obj.Mouse_Hover();
		obj.Student_Enrollment();
		//obj.WebTables();
		//obj.ScreenShot();
	}*/
	
	@BeforeTest
	public void Navigate() throws InterruptedException {
		driver.get("https://nareshit.in/course-schedule/");
		//driver.navigate().to("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
		//driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
		//driver.navigate().to("http://www.dhtmlgoodies.com/submitted-scripts/i-google-like-drag-drop/");
		//driver.get("https://nareshit.in");
		Thread.sleep(6000);
	}
	
	public void ScreenShot() throws IOException {
		TakesScreenshot TSS = ((TakesScreenshot)driver);
		File Screens_Shot = TSS.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Screens_Shot, new File("C:\\Users\\Satish\\eclipse-workspace\\7am_to_8am_Batch\\Screenshots\\NareshIt.png"));
	}
	
	public void Popup() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='snp-close snp_nothanks']")).click();
		Thread.sleep(3000);
		
	}
	
	@Test
	public void WebTables() throws InterruptedException {
		
		WebElement Search_Field = driver.findElement(By.xpath("//label[contains(text(),'Search:')]//input"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", Search_Field);
		Thread.sleep(4000);
		LinkedList<WebElement> Courses_Ele = new LinkedList<WebElement>();
		LinkedList<String>  Courses = new LinkedList<String>();
		
		Courses_Ele.addAll(driver.findElements(By.xpath("//table[@id='tablepress37']/tbody/tr/td[1]/b/a")));
		
		for(int i=0;i<Courses_Ele.size();i++) {
			String value = Courses_Ele.get(i).getText();
			Courses.add(value);
		}
		System.out.println(Courses);
		Collections.sort(Courses);
		
		driver.findElement(By.xpath("//th[@class='column-1 sorting']")).click();
		
		LinkedList<WebElement> After_Sort_Ele = new LinkedList<WebElement>();
		LinkedList<String> After_Sort = new LinkedList<String>();
		
		After_Sort_Ele.addAll(driver.findElements(By.xpath("//table[@id='tablepress-37']/tbody/tr/td[1]/b/a")));
		for(int i=0;i<After_Sort_Ele.size();i++) {
			After_Sort.add(After_Sort_Ele.get(i).getText());
		}
		System.out.println(After_Sort);
		//Courses
		boolean flag = true;
		for(int i=0;i<Courses.size();i++) {
			if(Courses.get(i).equals(After_Sort.get(i))) {
				continue;
			}else {
				flag=false;
				break;
			}
		}
		if(flag==true) {
			System.out.println("Sort is working as per the requirment");
		}else {
			System.out.println("Sort is not working as per the requirment");
		}
		
		driver.findElement(By.xpath("//label[contains(text(),'Search:')]//input")).sendKeys("CORE JAVA");
		Thread.sleep(2000);
		
		List<WebElement> Faculty_Element = driver.findElements(By.xpath("//table[@id='tablepress-37']/tbody/tr/td[2]"));
		LinkedList<String> Faculty = new LinkedList<String>();
		
		for(int i=0;i<Faculty_Element.size();i++) {
			Faculty.add(Faculty_Element.get(i).getText());
		}
		System.out.println(Faculty);
		
		driver.findElement(By.xpath("//td[contains(text(),'Mr. Kishan')]/../td[1]/b/a")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//td[contains(text(),'Mr. Kishan')]/../td[1]/b/a")).click();
		Thread.sleep(6000);
		
		String Current_Window = driver.getWindowHandle();
		
		LinkedList<String> Windows = new LinkedList<String>();
		Windows.addAll(driver.getWindowHandles());
		
		System.out.println(Windows);
		
		driver.switchTo().window(Windows.get(1));
		
		String Title = driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
		System.out.println(Title);
		
		driver.close();
		
		driver.switchTo().window(Current_Window);
		Thread.sleep(4000);
		driver.quit();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public void Mouse_Hover() throws InterruptedException {
		WebElement New_Batches = driver.findElement(By.xpath("//span[text()='New Batches']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(New_Batches);
		act.perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//li[@id='menu-item-2306']//span[contains(text(),'New Batches')]")).click();
		
		
	}
	
	public void Drag_Drop() {
		WebElement From = driver.findElement(By.xpath("//h1[contains(text(),'Block 3')]"));
		WebElement To = driver.findElement(By.xpath("//h1[contains(text(),'Block 2')]"));
	
		Actions act = new Actions(driver);
		act.dragAndDrop(From, To);
		act.perform();
		
	}
	
	
	public void Checkbox() {
		driver.findElement(By.xpath("//label[text()='Option 2']")).click();
		driver.findElement(By.xpath("//label[text()='Option 3']")).click();
		
		String Before_Click = driver.findElement(By.id("check1")).getAttribute("value");
		driver.findElement(By.id("check1")).click();
		
		String After_Click = driver.findElement(By.id("check1")).getAttribute("value");
		
		
		if(Before_Click.equals("Check All")&&After_Click.equals("Uncheck All")) {
			System.out.println("Button is working as per the requirement.");
		}else {
			System.out.println("Button is not working as per the requirement");
		}
		
	}
	
	public void Radio_Button() {
		driver.findElement(By.xpath("//div[@class='panel-body']//div//label[@class='radio-inline'][contains(text(),'Male')]")).click();
		String Gender = driver.findElement(By.xpath("//div[@class='panel-body']//div//label[@class='radio-inline'][contains(text(),'Male')]")).getText();
		
		driver.findElement(By.xpath("//label[contains(text(),'0 to 5')]")).click();
		String Age = driver.findElement(By.xpath("//label[contains(text(),'0 to 5')]/input")).getAttribute("value");
		
		driver.findElement(By.xpath("//button[contains(text(),'Get values')]")).click();
		
		String Output = driver.findElement(By.xpath("//p[@class='groupradiobutton']")).getText();
		
		if(Output.contains(Gender)&&Output.contains(Age)) {
			System.out.println("The output is as per the requriement");
		}else {
			System.out.println("Output is not as per the requiremnt");
		}
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
