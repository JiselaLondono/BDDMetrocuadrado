package com.tybatest.metrocuadrado.tasks;

import static com.tybatest.metrocuadrado.userinterfaces.CreditCalculator.CALCULATOR_TYPE;
import static com.tybatest.metrocuadrado.utils.Constants.FEES;
import static com.tybatest.metrocuadrado.utils.Constants.LOAN;
import static com.tybatest.metrocuadrado.utils.Utilities.replaceAccents;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;

public class ChooseCalculationType implements Task {

  private String calculationType;

  public ChooseCalculationType(String calculationType) {
    this.calculationType = calculationType;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Check.whether(replaceAccents(calculationType).equals(LOAN))
            .andIfSo(Click.on(CALCULATOR_TYPE.of(LOAN)))
            .otherwise(Click.on(CALCULATOR_TYPE.of(FEES))));
  }

  public static ChooseCalculationType toSimulateCreditWith(String calculationType) {
    return instrumented(ChooseCalculationType.class, calculationType);
  }
}
