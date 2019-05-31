package temp;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PHPTravelTest {

	public static WebDriver driver;
	Actions action = new Actions(driver);
	
	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public static void teardown() throws InterruptedException {
		Thread.sleep(20000);
		driver.quit();
	}

	@Test
	public void mthodTest() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("https://www.phptravels.net/");
		
	WebElement dateFrom = driver.findElement(By.xpath("//*[@id=\"dpd1\"]/div/input"));	
	dateFrom.sendKeys("30/05/2019");
	
	WebElement dateTo = driver.findElement(By.xpath("//*[@id=\"dpd2\"]/div/input"));
	dateTo.sendKeys("03/06/2019");
	
	WebElement passengerBtn = driver.findElement(By.xpath("//*[@id=\"travellersInput\"]"));
	passengerBtn.click();
	Thread.sleep(50);
	WebElement adultsPlus = driver.findElement(By.xpath("//*[@id=\"adultPlusBtn\"]"));
	adultsPlus.click();
	Thread.sleep(50);
	passengerBtn.click();
	
	WebElement search = driver.findElement(By.xpath("//*[@id=\"s2id_autogen3\"]/a/span[1]"));
	search.click();
	action.sendKeys("London").perform();
	Thread.sleep(1000);
	action.sendKeys(Keys.ENTER).perform();
	search.submit();
	}
}