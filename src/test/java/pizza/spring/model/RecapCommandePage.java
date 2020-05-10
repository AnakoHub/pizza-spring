package pizza.spring.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecapCommandePage {
	
	private WebDriver webDriver;
	
	public RecapCommandePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	/**
	 * Verification de la présence d'un élément dans le lien
	 * @param element à verifier dans le lien
	 * @return Boolean indiquant si l'élément est présent dans le lien
	 */
	public boolean isLinkPresent(String element) {
		return webDriver.getCurrentUrl().contains(element);
	}
}
