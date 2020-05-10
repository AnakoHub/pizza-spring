package pizza.spring.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommandePage {
	
	private WebDriver webDriver;
	
	public CommandePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	/**
	 * Selection de la pizza selon son index dans la liste
	 * @param index de la pizza dans la liste
	 * @return La page avec la pizza selectionné
	 */
	public CommandePage selectPizza(int index) {
		Select pizza = new Select(webDriver.findElement(By.id("pizzaId")));
		pizza.selectByIndex(index);
		return this;
	}
	
	/**
	 * Envoie du nom entrée dans le formulaire
	 * @param words Nom entré
	 * @return La page avec les noms entrés dans le formulaire
	 */
	public CommandePage enterName(String... words) {
	    WebElement nameInput = webDriver.findElement(By.id("nom"));
	    nameInput.sendKeys(String.join(" ", words));
	    return this;
	  }
	
	/**
	 * Envoie du numéor de telephone entrée dans le formulaire
	 * @param words Numéro de téléphone entré
	 * @return La page avec le numéro entrés dans le formulaire
	 */
	public CommandePage enterTelephone(String... words) {
		WebElement nameInput = webDriver.findElement(By.id("telephone"));
		nameInput.sendKeys(String.join(" ", words));
		return this;
	}
	
	/**
	 * Clique sur le bouton de commande du formulaire
	 * @return La page récapitulative de la commande
	 */
	public RecapCommandePage clickOnCommande() {
		WebElement searchButton = webDriver.findElement(By.xpath("//button[contains(text(),'Commander')]"));
		searchButton.click();
		return new RecapCommandePage(webDriver);
	}
	
	/**
	 * Verification de la présence d'un élément dans la page
	 * @param element à verifier dans la page
	 * @return Boolean indiquant si l'élément est présent dans la page
	 */
	public boolean isElementPresent(String element) {
		return webDriver.findElement(By.id(element)).isDisplayed();
	}
}
