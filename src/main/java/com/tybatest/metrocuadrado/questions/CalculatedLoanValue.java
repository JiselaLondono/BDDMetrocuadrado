package com.tybatest.metrocuadrado.questions;

import static com.tybatest.metrocuadrado.userinterfaces.CreditResult.VALUE;
import static com.tybatest.metrocuadrado.utils.Utilities.removeCharactersToValue;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class CalculatedLoanValue implements Question<Integer> {

  private static final String LOAN_TABLE_ITEM = "2";

  @Override
  public Integer answeredBy(Actor actor) {
    return removeCharactersToValue(Text.of(VALUE.of(LOAN_TABLE_ITEM)).viewedBy(actor).asString());
  }

  public static CalculatedLoanValue is() {
    return new CalculatedLoanValue();
  }
}
