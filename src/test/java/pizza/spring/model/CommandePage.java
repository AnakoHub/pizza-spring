package pizza.spring.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommandePage {
	
	private WebDriver webDriver;
	
	public CommandePage(WebDriver webDriver) {
		this.webDriver = webDriver;
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
	
	public RecapCommandePage clickOnSearch() {
		WebElement searchButton = webDriver.findElement(By.xpath("//button[contains(text(),'Commander')]"));
		searchButton.click();
		return new RecapCommandePage(webDriver);
	}
}
