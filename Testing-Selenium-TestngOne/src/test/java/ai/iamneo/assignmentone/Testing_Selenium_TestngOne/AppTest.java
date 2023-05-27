package ai.iamneo.assignmentone.Testing_Selenium_TestngOne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.port", "8080");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://iamneo.ai");
	}

	@Test
	public void titlematch() throws InterruptedException {

		String expectedTitle = "We are Hiring!";
		String actualTitle = driver.getTitle();

		if (actualTitle.equals(expectedTitle)) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
	}

	@AfterMethod
	public void facebookTest() throws InterruptedException {

		driver.get("https://www.facebook.com");

		driver.navigate().back();

		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL: " + currentUrl);

		driver.navigate().forward();

		driver.navigate().refresh();

		driver.quit();
	}
}
