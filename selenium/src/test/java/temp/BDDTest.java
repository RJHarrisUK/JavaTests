package temp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BDDTest {
	
	public static WebDriver driver;
	
	@Before
	public static void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public static void teardown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Given("^the correct web address$")
	public void the_correct_web_address() {
		driver.manage().window().maximize();
		driver.get("http://www.practiceselenium.com/welcome.html");
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() {
		WebElement menu = driver
				.findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a"));
		menu.click();
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() {
		WebElement frame = driver.findElement(By.xpath("/html/body/div/div"));
		frame.click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.SPACE);
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() {
		WebElement proceedCheckout = driver
				.findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[5]/a"));
		proceedCheckout.click();
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() {
		WebElement proceedCheckout = driver.findElement(
				By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000452010925\"]/div/div/form/div/button"));
		proceedCheckout.isDisplayed();
	}

}
