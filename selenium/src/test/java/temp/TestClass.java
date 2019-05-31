package temp;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {

	public static WebDriver driver;
	
	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public static void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void mthodTest() {
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		WebElement webElement = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input"));
		WebElement webElement2 = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[3]/center/input[1]"));
		webElement.sendKeys("Planet Earth TV Series");
		webElement2.click();
	}

}
