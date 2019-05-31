package temp;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ShoppingWebsiteTest {

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
	public void mthodTest() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	
	// Search for "Dress" 
	WebElement search = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
	search.sendKeys("Dress");
	search.submit();
	
	//	in chrome - search for contains dress in centre panel - //ul[contains(@class, 'product_list')]//h5/a[contains(@title, 'Dress'0)]
	// print to console check - pass/fail
	WebElement checkDress = driver.findElement(By.xpath("//ul[contains(@class, 'product_list')]//h5/a[contains(@title, 'Dress')]"));
	Boolean check = checkDress.isDisplayed();
	if (check) {
		System.out.println("Pass");
		assertTrue(check);
	} else { 
		System.out.println("Fail");
		fail();
		}
	WebElement dressSelect = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img"));

	// hover over dress to set new menu
	Actions action = new Actions(driver);
	action.moveToElement(dressSelect).perform();
	WebElement addCart = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[2]"));
	addCart.click();
	
	// change dress to pink and check out
	WebElement dressColour = driver.findElement(By.xpath("//*[@id=\"color_24\"]"));
	dressColour.click();
	WebElement proceedCheckout = driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span"));
	proceedCheckout.click();
	}

	}