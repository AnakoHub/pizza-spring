package pizza.spring.service;

import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		//Access the website to be tested
		webDriver.navigate().to("http://localhost:8080/pizza-spring/");
		
		//Find the right element from the navbar and click on it
		List<WebElement> navbarLinks = webDriver.findElements(By.id("menu"));
		for (WebElement x : navbarLinks) {
			if(webDriver.findElement(By.xpath("//a[contains(text(), 'Commander')]")).isDisplayed()) {
				x.click();
				webDriver.navigate().to("http://localhost:8080/pizza-spring/commande");
			}
		}
		
		//Find an element from the SELECT menu and select it
		Select pizza = new Select(webDriver.findElement(By.id("pizzaId")));
		pizza.selectByIndex(3);
		
		//Find the nom, and telephone field and fill them, then click on the commander button
		WebElement nameInput = webDriver.findElement(By.id("nom"));
		WebElement telephoneInput = webDriver.findElement(By.id("telephone"));
		WebElement commandButton = webDriver.findElement(By.xpath("//button[contains(text(),'Commander')]"));
		nameInput.sendKeys("Test java 1");
		telephoneInput.sendKeys("06060606");
		commandButton.click();
		
	}

	@Test
	public void anErrorMessageIsDisplayedWhenNoPizzaIsSelectionedInDuringTheOrder() throws Exception {
		//Access the website to be tested
		webDriver.navigate().to("http://localhost:8080/pizza-spring/");
		
		//Find the right element from the navbar and click on it
		List<WebElement> navbarLinks = webDriver.findElements(By.id("menu"));
		for (WebElement x : navbarLinks) {
			if(webDriver.findElement(By.xpath("//a[contains(text(), 'Commander')]")).isDisplayed()) {
				x.click();
				webDriver.navigate().to("http://localhost:8080/pizza-spring/commande");
			}
		}
		
		//Find the nom, and telephone field and fill them, then click on the commander button
		WebElement nameInput = webDriver.findElement(By.id("nom"));
		WebElement telephoneInput = webDriver.findElement(By.id("telephone"));
		WebElement commandButton = webDriver.findElement(By.xpath("//button[contains(text(),'Commander')]"));
		nameInput.sendKeys("Test java 2");
		telephoneInput.sendKeys("06060606");
		commandButton.click();
	}
	
	@Test
	public void anErrorMessageIsDisplayedWhenNoTelephoneNumberIsEntered() throws Exception {
		//Access the website to be tested
		webDriver.navigate().to("http://localhost:8080/pizza-spring/");
		
		//Find the right element from the navbar and click on it
		List<WebElement> navbarLinks = webDriver.findElements(By.id("menu"));
		for (WebElement x : navbarLinks) {
			if(webDriver.findElement(By.xpath("//a[contains(text(), 'Commander')]")).isDisplayed()) {
				x.click();
				webDriver.navigate().to("http://localhost:8080/pizza-spring/commande");
			}
		}
		
		//Find the nom, and telephone field and fill them, then click on the commander button
		WebElement nameInput = webDriver.findElement(By.id("nom"));
		WebElement telephoneInput = webDriver.findElement(By.id("telephone"));
		WebElement commandButton = webDriver.findElement(By.xpath("//button[contains(text(),'Commander')]"));
		nameInput.sendKeys("Test java 3");
		telephoneInput.sendKeys("06060606");
		commandButton.click();
	}
}
