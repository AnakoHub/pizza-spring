package pizza.spring.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecapCommandePage {
	
	private WebDriver webDriver;
	
	public RecapCommandePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public boolean isLinkPresent(String link) {
		return webDriver.getCurrentUrl().contains(link);
	}
}
