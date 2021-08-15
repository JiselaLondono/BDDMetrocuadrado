package com.tybatest.metrocuadrado.questions;

import static com.tybatest.metrocuadrado.userinterfaces.CreditResult.VALUE;
import static com.tybatest.metrocuadrado.utils.Utilities.removeCharactersToValue;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class MonthlyFeeValue implements Question<Integer> {

  private static final String FEE_TABLE_ITEM = "3";

  @Override
  public Integer answeredBy(Actor actor) {
    return removeCharactersToValue(Text.of(VALUE.of(FEE_TABLE_ITEM)).viewedBy(actor).asString());
  }

  public static MonthlyFeeValue is() {
    return new MonthlyFeeValue();
  }
}
