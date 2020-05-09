package pizza.spring.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommandeDePizzaAvecPOMAcceptanceTest {
	private WebDriver webDriver;

	@Before
	public void createWebDriver() {
		webDriver = new FirefoxDriver();
	}

	@After
	public void closeWebDriver() {
		webDriver.quit();
	}
	
	@Test
	public void anOrderIsPlacedForAPizzaWhenTheFormIsFilledIn() throws Exception {
		
	}
}
