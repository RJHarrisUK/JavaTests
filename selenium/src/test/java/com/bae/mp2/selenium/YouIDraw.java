package com.bae.mp2.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class YouIDraw {

	public static WebDriver driver;

	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public static void teardown() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}

	@Test
	public void mthodTest() {
		Actions action = new Actions(driver);
		driver.manage().window().maximize();
		driver.get("https://www.youidraw.com/apps/painter/");

		action.moveByOffset(600, 222).clickAndHold().moveByOffset(0, 500).moveByOffset(0, -500).moveByOffset(150, 150)
				.moveByOffset(-150, 150).moveByOffset(150, 190).release().moveByOffset(50, -490).clickAndHold()
				.moveByOffset(0, 50).release().moveByOffset(0, 50).clickAndHold().moveByOffset(0, 400).release()
				.moveByOffset(200, -500).clickAndHold().moveByOffset(-150, 250).moveByOffset(150, 250).release()
				.moveByOffset(50, -500).clickAndHold().moveByOffset(0, 500).moveByOffset(0, -250).moveByOffset(150, 0)
				.moveByOffset(0, -250).moveByOffset(0, 500).release().perform();
	}
}
