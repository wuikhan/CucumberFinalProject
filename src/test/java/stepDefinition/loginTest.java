package stepDefinition;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class loginTest {
	WebDriver driver;

	@Given("^I open chrome browser$")
	public void i_open_chrome_browser() {
		String OS = System.getProperty("os.name").toLowerCase();
		System.out.println(OS);
		if (OS.equals("mac os x")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver-mac");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/Drivers/chromedriver-win.exe");
			driver = new ChromeDriver();
		}
	}

	@When("^I go to the homepage$")
	public void i_go_to_the_homepage() {
		String url = "https://login.salesforce.com/";
		driver.get(url);
	}

	@Then("^I should see logo$")
	public void i_should_see_logo() {
		boolean logoPresent = driver.findElement(By.id("logo")).isDisplayed();
		assertEquals(logoPresent, true);
	}

	@Then("^I enter username$")
	public void i_enter_username() {
		driver.findElement(By.id("username")).sendKeys("test.user@gmail.com.test");
	}

	@Then("^I enter password$")
	public void i_enter_password() {
		driver.findElement(By.id("password")).sendKeys("Welcome1!");
	}

	@When("^I click login button$")
	public void i_click_login_button() {
		driver.findElement(By.id("Login")).click();
	}

	@Then("^I should see log out$")
	public void i_should_see_log_out() throws InterruptedException {
		Thread.sleep(3000);
		String setupText = driver.findElement(By.xpath("//a[@title='Setup']")).getText();
		System.out.println(setupText);
		assertEquals(setupText, "Setup");
	}

	@Then("^I quit$")
	public void i_quit() {
		driver.close();
	}
}
