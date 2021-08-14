package com.tybatest.metrocuadrado.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.Set;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

public class OpenNextTab implements Interaction {

  @Override
  public <T extends Actor> void performAs(T actor) {
    WebDriver driver = BrowseTheWeb.as(actor).getDriver();
    Set<String> browserTabs = driver.getWindowHandles();
    browserTabs.remove(driver.getWindowHandle());
    driver.switchTo().window(browserTabs.iterator().next());
  }

  public static OpenNextTab inBrowser() {
    return instrumented(OpenNextTab.class);
  }
}
