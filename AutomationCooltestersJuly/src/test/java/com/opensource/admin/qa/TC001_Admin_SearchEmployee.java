package com.opensource.admin.qa;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC001_Admin_SearchEmployee {

	@BeforeTest
	public void beforeTest() {
	}

	@Test
	public void TC001_Admin_SearchEmployee_Script() {

		SoftAssert soft = new SoftAssert();

		int random2 = (int) (Math.random() * 1000);
		String rndName = generatedStringRandom(5) + random2;

		//

		// A4RT6

		// Step 1
		Reporter.log("Open Browser \"OrangeHRM\" web page");
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Step 2
		Reporter.log("Enter Username and Password");
		driver.findElement(By.xpath("//input[@id='txtUsername'] ")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Step 3
		Reporter.log("Validate that you have logged in successfully");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='OrangeHRM']")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='OrangeHRM']")));
//		wait.until(ExpectedConditions.textToBe(By.xpath("//img[@alt='OrangeHRM']"), rndName));

		// Step 4
		Reporter.log("Click Admin - Go to the admin page");
		boolean isAdminDisplayed = driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).isDisplayed();
		soft.assertEquals(isAdminDisplayed, false);
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Step 5
		Reporter.log("Search username in field Username");
		driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']")).sendKeys("Admin");

		// Step 6
		Reporter.log("Click Search");
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();

		// Step 7
		Reporter.log("Verify username exist in table");
		String actualValue = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
//	  Assert.assertEquals(actualValue, "Admin");

		soft.assertEquals(actualValue, "Admon");

		// Step 8
		Reporter.log("Log out");
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'Logout')]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Step 9
		Reporter.log("Close Browser");
		driver.close();

	}

	public static String generatedStringRandom(int StringLenght) {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(StringLenght)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		return generatedString;
	}

	@AfterTest
	public void afterTest() {
	}

}
