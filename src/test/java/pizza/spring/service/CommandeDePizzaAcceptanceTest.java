package pizza.spring.service;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

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
	public void anOrderIsPlacedForAPizzaWhenTheFormIsFilledIn() throws Exception {
		webDriver.navigate().to("http://localhost:8080/pizza-spring/");
		
		List<WebElement> navbarLinks = webDriver.findElements(By.id("menu"));
		WebElement commandPageButton = aNav.findElement(By.partialLinkText("http://localhost:8080/pizza-spring/commande"));
		commandPageButton.click();
		
		WebElement listPizza = webDriver.findElement(By.id("pizzaId"));
		WebElement pizzaName = listPizza.findElement(By.tagName("option"));
		WebElement pizzaSelection = pizzaName.findElement(By.name("Orientale"));
		
		WebElement nameInput = webDriver.findElement(By.id("nom"));
		WebElement telephoneInput = webDriver.findElement(By.id("telephone"));
		WebElement commandButton = webDriver.findElement(By.id(""));
		nameInput.sendKeys("Test java 1");
		telephoneInput.sendKeys("06060606");
		commandButton.click();
	}

//	@Test
//	public void anErrorMessageIsDisplayedWhenNoPizzaIsSelectionedInDuringTheOrder() throws Exception {
//		webDriver.navigate().to("http://localhost:8080/pizza-spring/");
//	}
}
