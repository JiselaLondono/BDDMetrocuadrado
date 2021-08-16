package com.tybatest.metrocuadrado.questions;

import static com.tybatest.metrocuadrado.userinterfaces.CreditResult.DETAILED_CREDIT_VALUES;
import static com.tybatest.metrocuadrado.utils.Constants.INITIAL_FEE;
import static com.tybatest.metrocuadrado.utils.Constants.LOAN;
import static com.tybatest.metrocuadrado.utils.Constants.PROPERTY_VALUE;
import static com.tybatest.metrocuadrado.utils.Utilities.removeCharactersToValue;
import static com.tybatest.metrocuadrado.utils.enums.ErrorMessages.INVALID_VALUE_TYPE;

import com.tybatest.metrocuadrado.exceptions.InvalidValueTypeException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

@Subject("In the credit detail, el value of #valueType")
public class InTheCreditDetail implements Question<Integer> {

  private String valueType;
  private static final String LOAN_ITEM = "1";
  private static final String INITIAL_FEE_ITEM = "3";
  private static final String PROPERTY_VALUE_ITEM = "4";

  public InTheCreditDetail(String valueType) {
    this.valueType = valueType;
  }

  @Override
  public Integer answeredBy(Actor actor) {
    switch (valueType) {
      case LOAN:
        return removeCharactersToValue(
            Text.of(DETAILED_CREDIT_VALUES.of(LOAN_ITEM)).viewedBy(actor).asString());
      case INITIAL_FEE:
        return removeCharactersToValue(
            Text.of(DETAILED_CREDIT_VALUES.of(INITIAL_FEE_ITEM)).viewedBy(actor).asString());
      case PROPERTY_VALUE:
        return removeCharactersToValue(
            Text.of(DETAILED_CREDIT_VALUES.of(PROPERTY_VALUE_ITEM)).viewedBy(actor).asString());
      default:
        throw new InvalidValueTypeException(INVALID_VALUE_TYPE.getMessage());
    }
  }

  public static InTheCreditDetail theValueOf(String valueType) {
    return new InTheCreditDetail(valueType);
  }

  public InTheCreditDetail is() {
    return this;
  }
}
