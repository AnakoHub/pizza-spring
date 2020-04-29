package pizza.spring.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommandeDePizzaAcceptanceTest {

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
	public void anOrderIsPlacedForAPizzaTheFormIsFilledIn() throws Exception {
		webDriver.navigate().to("http://localhost:8080/pizza-spring/");
		WebElement commanderPageButton = WebDriver.
	}

	@Test
	public void anErrorMessageIsDisplayedWhenNoPizzaIsSelectionedInDuringTheOrder() throws Exception {
		webDriver.navigate().to("http://localhost:8080/pizza-spring/");
	}
}
