package com.tybatest.metrocuadrado.questions;

import static com.tybatest.metrocuadrado.userinterfaces.CreditResult.VALUE_BY_FEEL;
import static com.tybatest.metrocuadrado.utils.Utilities.removeCharactersToValue;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class CalculatedMonthlyFeeValue implements Question<Integer> {

  private static final String FEE_TABLE_ITEM = "2";

  @Override
  public Integer answeredBy(Actor actor) {
    return removeCharactersToValue(
        Text.of(VALUE_BY_FEEL.of(FEE_TABLE_ITEM)).viewedBy(actor).asString());
  }

  public static CalculatedMonthlyFeeValue is() {
    return new CalculatedMonthlyFeeValue();
  }
}
