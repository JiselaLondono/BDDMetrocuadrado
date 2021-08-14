package com.tybatest.metrocuadrado.stepdefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.tybatest.metrocuadrado.interactions.SelectMenuOption;
import com.tybatest.metrocuadrado.tasks.ChooseCalculationType;
import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class GeneralStepDefinition {

  @Managed(driver = "chrome")
  WebDriver herBrowser;

  @Before
  public void setStage() {
    OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(herBrowser)));
  }

  @Dado("que {word} quiere hacer uso de la {string}, una de las {string} de Metrocuadrado")
  public void selectMenuOption(String actor, String submenuOption, String menuOption) {
    theActorCalled(actor)
        .wasAbleTo(
            Open.url("https://www.metrocuadrado.com/"),
            SelectMenuOption.named(menuOption).andSubmenu(submenuOption));
  }

  @Dado(
      "quiere simular el cálculo de/del {string} a pagar a un banco para/de un Crédito Hipotecario")
  public void selectCalculationType(String calculationType) {
    theActorInTheSpotlight()
        .attemptsTo(ChooseCalculationType.toSimulateCreditWith(calculationType));
  }
}
