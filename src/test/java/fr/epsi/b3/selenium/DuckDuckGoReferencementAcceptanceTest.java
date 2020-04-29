package fr.epsi.b3.selenium;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DuckDuckGoReferencementAcceptanceTest {

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
  public void checkSeleniumDevSiteFoundInFirstPageOfDuckduckgo() throws Exception {
    // On précise l'URI sur la barre d'adresse du navigateur
    webDriver.navigate().to("https://duckduckgo.com/");
    // On extrait des références sur les éléments de la page :
    // le champ de saisie pour la recherche et le bouton pour lancer la recherche
    WebElement searchInput = webDriver.findElement(By.name("q"));
    WebElement searchButton = webDriver.findElement(By.id("search_button_homepage"));

    // On remplit le champ de saisie et on clique sur le bouton de recherche
    searchInput.sendKeys("selenium");
    searchButton.click();

    // On vérifie que dans la page dans laquelle on se situe
    // (normalement la page des résultats de la recherche),
    // on trouve bien des liens vers le site voulu.
    List<WebElement> resultLinks = webDriver.findElements(By.partialLinkText("https://www.selenium.dev"));
    assertFalse("Aucun lien trouvé pour selenium.dev", resultLinks.isEmpty());
  }

}