package com.tybatest.metrocuadrado.stepdefinitions;

import static com.tybatest.metrocuadrado.utils.Constants.INITIAL_FEE;
import static com.tybatest.metrocuadrado.utils.Constants.LOAN;
import static com.tybatest.metrocuadrado.utils.Constants.PROPERTY_VALUE;
import static com.tybatest.metrocuadrado.utils.enums.ErrorMessages.DISPLAYED_VALUE_ERROR;
import static com.tybatest.metrocuadrado.utils.enums.ErrorMessages.LOAN_VALUE_ERROR;
import static com.tybatest.metrocuadrado.utils.enums.ErrorMessages.MONTHLY_FEE_VALUE_ERROR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import com.tybatest.metrocuadrado.exceptions.DisplayedValueException;
import com.tybatest.metrocuadrado.exceptions.LoanValueException;
import com.tybatest.metrocuadrado.exceptions.MonthlyFeeValueException;
import com.tybatest.metrocuadrado.questions.CalculatedMonthlyFeeValue;
import com.tybatest.metrocuadrado.questions.InTheCreditDetail;
import com.tybatest.metrocuadrado.questions.LoanValue;
import com.tybatest.metrocuadrado.tasks.AddDataForFeesCalculation;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

public class MonthlyFeeCalculationForCreditStepDefinition {

  private int creditValue;

  @Cuando("indica un valor del crédito de {int} y un plazo en años de {int}")
  public void addFeeCalculationData(int creditValue, int term) {
    this.creditValue = creditValue;
    theActorInTheSpotlight()
        .attemptsTo(AddDataForFeesCalculation.asTheFollowing(creditValue, term));
  }

  @Entonces(
      "ella debería ver un resumen con el valor de cuota mensual de {int} y valor de préstamo de {int}")
  public void validateMonthlyFeeCalculationAndLoan(int monthlyFee, int loan) {
    theActorInTheSpotlight()
        .should(
            seeThat(CalculatedMonthlyFeeValue.is(), equalTo(monthlyFee))
                .orComplainWith(
                    MonthlyFeeValueException.class, MONTHLY_FEE_VALUE_ERROR.getMessage()),
            seeThat(LoanValue.is(), equalTo(loan))
                .orComplainWith(LoanValueException.class, LOAN_VALUE_ERROR.getMessage()));
  }

  @Entonces(
      "la información detallada del crédito es correspondiente de acuerdo al cálculo y a los datos ingresados")
  public void validateCreditInformation() {
    theActorInTheSpotlight()
        .should(
            seeThat(InTheCreditDetail.theValueOf(LOAN).is(), equalTo(creditValue))
                .orComplainWith(
                    DisplayedValueException.class,
                    String.format(DISPLAYED_VALUE_ERROR.getMessage(), LOAN)),
            seeThat(
                    InTheCreditDetail.theValueOf(INITIAL_FEE).is(),
                    equalTo((int) Math.round(((double) creditValue * 30) / 70)))
                .orComplainWith(
                    DisplayedValueException.class,
                    String.format(DISPLAYED_VALUE_ERROR.getMessage(), INITIAL_FEE)),
            seeThat(
                    InTheCreditDetail.theValueOf(PROPERTY_VALUE).is(),
                    equalTo((int) Math.round(((double) creditValue * 100) / 70)))
                .orComplainWith(
                    DisplayedValueException.class,
                    String.format(DISPLAYED_VALUE_ERROR.getMessage(), PROPERTY_VALUE)));
  }
}
