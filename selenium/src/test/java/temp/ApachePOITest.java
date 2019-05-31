package temp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApachePOITest {

	public static WebDriver driver;
	
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
	public void mthodTest() {
		// open chrome
		driver.manage().window().maximize();
		driver.get("https://thedemosite.co.uk/");
		
		// set up excel
		FileInputStream file = null;
		try {
			file = new FileInputStream(Constants.PATHTOFILE + Constants.FILENAME);
		} catch (FileNotFoundException e) {
		}
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {
		}
				
		// start loop
		for (int i=1; i<=4; i++) {
		// create sheet + point to usernames and passwords
		XSSFSheet sheet = workbook.getSheetAt(0);
		String username = sheet.getRow(i).getCell(0).getStringCellValue();
		String password = sheet.getRow(i).getCell(1).getStringCellValue();
		
		// Go to the user tab
		WebElement addUser = driver.findElement(
				By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
		addUser.click();

		// Set username and password
		WebElement addUsername = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
		addUsername.sendKeys(username);
		WebElement addPassword = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
		addPassword.sendKeys(password);
		WebElement submitNewUser = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
		submitNewUser.submit();

		// Go to the login tab
		WebElement toLogin = driver
				.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[2]/small/a"));
		toLogin.click();

		// Enter username and password
		WebElement loginUsername = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
		loginUsername.sendKeys(username);
		WebElement loginPassword = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
		loginPassword.sendKeys(password);

		// Login
		WebElement loginClick = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
		loginClick.click(); 

		// populate results
		WebElement endState = driver
				.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
		XSSFCell resultCell = sheet.getRow(i).getCell(2);
		resultCell.setCellValue(endState.getText());
		//end loop
		}
		
		// save workbook
		try {
			FileOutputStream out = new FileOutputStream(new File(Constants.PATHTOFILE + Constants.FILENAME));
			workbook.write(out);
			out.close();
			System.out.println("Saved");
		} catch (IOException e) {
		}
	}
}