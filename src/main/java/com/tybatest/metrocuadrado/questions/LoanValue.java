package com.tybatest.metrocuadrado.questions;

import static com.tybatest.metrocuadrado.userinterfaces.CreditResult.VALUE_BY_FEEL;
import static com.tybatest.metrocuadrado.utils.Utilities.removeCharactersToValue;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class LoanValue implements Question<Integer> {

  private static final String LOAN_TABLE_ITEM = "3";

  @Override
  public Integer answeredBy(Actor actor) {
    return removeCharactersToValue(
        Text.of(VALUE_BY_FEEL.of(LOAN_TABLE_ITEM)).viewedBy(actor).asString());
  }

  public static LoanValue is() {
    return new LoanValue();
  }
}
