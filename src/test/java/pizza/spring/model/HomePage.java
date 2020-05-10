package pizza.spring.model;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	private WebDriver webDriver;
	
	public HomePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	/**
	 * Ouverture de la page principale du site
	 * @return Page principale du site
	 */
	public HomePage open() {
		webDriver.navigate().to("http://localhost:8080/pizza-spring/");
		assertTrue("Titre de page inattendu " + webDriver.getTitle(),
	               webDriver.getTitle().startsWith("Pizza Spring"));
	    return this;
	}
	
	public static HomePage openWith(WebDriver webDriver) {
		HomePage homePage = new HomePage(webDriver);
		homePage.open();
		return homePage;
	}
	
	/**
	 * Clique sur l'élément "Commander" de la barre de navigation
	 * @return La page de commande
	 */
	public CommandePage clickOnNavCommande() {
		WebElement commandNav = webDriver.findElement(By.xpath("//a[contains(text(), 'Commander')]"));
		commandNav.click();
		
		return new CommandePage(webDriver);
	}
}
