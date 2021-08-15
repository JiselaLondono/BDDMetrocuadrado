package com.tybatest.metrocuadrado.tasks;

import static com.tybatest.metrocuadrado.userinterfaces.CreditCalculator.CALCULATE_CREDIT_BUTTON;
import static com.tybatest.metrocuadrado.userinterfaces.CreditCalculator.MONTHLY_INCOME;
import static com.tybatest.metrocuadrado.userinterfaces.CreditCalculator.TERM_IN_YEARS;
import static com.tybatest.metrocuadrado.utils.Constants.FULL_TERM_OPTION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class AddCreditCalculationInformation implements Task {

  private int monthlyIncome;
  private int term;

  public AddCreditCalculationInformation(int monthlyIncome, int term) {
    this.monthlyIncome = monthlyIncome;
    this.term = term;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Enter.theValue(String.valueOf(monthlyIncome)).into(MONTHLY_INCOME),
        SelectFromOptions.byVisibleText(String.format(FULL_TERM_OPTION, term)).from(TERM_IN_YEARS),
        Click.on(CALCULATE_CREDIT_BUTTON));
  }

  public static AddCreditCalculationInformation withTheFollowingData(int monthlyIncome, int term) {
    return instrumented(AddCreditCalculationInformation.class, monthlyIncome, term);
  }
}
