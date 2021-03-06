package com.mindtree.SeleniumCertificationCourse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Runner {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		Runner runner = new Runner();
		runner.setUp();
		runner.testScenario1();
		runner.testScenario2();

		driver.quit();
	}

	public void setUp() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.lambdatest.com/selenium-playground/");
		Thread.sleep(1000);
		driver.manage().window().maximize();

	}

	@SuppressWarnings("deprecation")
	public void testScenario1() {

		driver.findElement(By.xpath("//a[@class='text-black text-size-14 hover:text-lambda-900 leading-relaxed']"))
				.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String variable = "Welcome to Lambda Test";
		driver.findElement(By.id("user-message")).sendKeys(variable);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@type='button']")).click();
		String validateText = driver.findElement(By.id("message")).getText();
		if (variable.contains(validateText)) {
			System.out.println("Test case is pass");
		} else {
			System.out.println("Test case is fail");
		}
	}

	@SuppressWarnings("deprecation")
	public void testScenario2() {
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@class='text-black text-size-14 hover:text-lambda-900 leading-relaxed']"))
				.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		WebElement source = driver.findElement(By.xpath("(//input[@class='sp__range'])[3]"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		action.dragAndDropBy(source, 15, 90).build().perform();

	}

}
