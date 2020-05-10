package pizza.spring.service;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pizza.spring.model.CommandePage;
import pizza.spring.model.HomePage;
import pizza.spring.model.RecapCommandePage;

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
	public void anOrderIsPlacedForAPizzaWhenTheFormIsCompletelyFilledIn() throws Exception {
		 CommandePage commandePage= HomePage.openWith(webDriver)
				 						   .clickOnNavCommande();
		 
		 RecapCommandePage recapCommandePage = commandePage.selectPizza(0)
				 										   .enterName("Test POM 1")
				 										   .enterTelephone("07070707")
				 										   .clickOnCommande();

		assertTrue(recapCommandePage.isLinkPresent("/pizza-spring/recap-commande"));
	}
	
	@Test
	public void anErrorMessageIsDisplayedWhenNoPizzaIsSelectionedInDuringTheOrder() throws Exception {
		CommandePage commandePage= HomePage.openWith(webDriver)
				   						   .clickOnNavCommande();
		
		 RecapCommandePage recapCommandePage = commandePage.enterName("Test POM 1")
														   .enterTelephone("07070707")
														   .clickOnCommande();
		
		 assertTrue(commandePage.isElementPresent("pizzaId.errors"));
	}
	
	@Test
	public void anErrorMessageIsDisplayedWhenNoTelephoneNumberIsEntered() throws Exception {
		CommandePage commandePage= HomePage.openWith(webDriver)
				.clickOnNavCommande();
		
		RecapCommandePage recapCommandePage = commandePage.selectPizza(0)
													      .enterName("Test POM 1")
													      .clickOnCommande();
		
		assertTrue(commandePage.isElementPresent("telephone.errors"));
	}
}
