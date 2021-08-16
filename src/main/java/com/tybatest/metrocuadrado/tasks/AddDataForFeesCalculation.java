package com.tybatest.metrocuadrado.tasks;

import static com.tybatest.metrocuadrado.userinterfaces.CreditCalculator.CALCULATE_FEES_BUTTON;
import static com.tybatest.metrocuadrado.userinterfaces.CreditCalculator.CREDIT_VALUE;
import static com.tybatest.metrocuadrado.userinterfaces.CreditCalculator.TERM_IN_YEARS_BY_FEE;
import static com.tybatest.metrocuadrado.utils.Constants.FULL_TERM_OPTION;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class AddDataForFeesCalculation implements Task {

  private int creditValue;
  private int term;

  public AddDataForFeesCalculation(int creditValue, int term) {
    this.creditValue = creditValue;
    this.term = term;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Enter.theValue(String.valueOf(creditValue)).into(CREDIT_VALUE),
        SelectFromOptions.byVisibleText(String.format(FULL_TERM_OPTION, term))
            .from(TERM_IN_YEARS_BY_FEE),
        WaitUntil.the(CALCULATE_FEES_BUTTON, isEnabled()),
        Click.on(CALCULATE_FEES_BUTTON));
  }

  public static AddDataForFeesCalculation asTheFollowing(int creditValue, int term) {
    return instrumented(AddDataForFeesCalculation.class, creditValue, term);
  }
}
