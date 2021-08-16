package com.tybatest.metrocuadrado.stepdefinitions;

import static com.tybatest.metrocuadrado.utils.Constants.INITIAL_FEE;
import static com.tybatest.metrocuadrado.utils.Constants.LOAN;
import static com.tybatest.metrocuadrado.utils.Constants.MONTHLY_INCOME;
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
import com.tybatest.metrocuadrado.questions.CalculatedLoanValue;
import com.tybatest.metrocuadrado.questions.InTheLoanDetail;
import com.tybatest.metrocuadrado.questions.MonthlyFeeValue;
import com.tybatest.metrocuadrado.tasks.AddDataForLoanCalculation;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

public class LoanCalculationForCreditStepDefinition {

  private int loan;
  private int monthlyIncome;

  @Cuando("indica un valor de ingresos mensuales de {int} y un plazo en años de {int}")
  public void addCreditCalculationData(int monthlyIncome, int term) {
    this.monthlyIncome = monthlyIncome;
    theActorInTheSpotlight()
        .attemptsTo(AddDataForLoanCalculation.asTheFollowing(monthlyIncome, term));
  }

  @Entonces(
      "ella debería ver un resumen con el valor estimado de préstamo de {int} y valor de cuota mensual de {int}")
  public void validateLoanCalculationAndMonthlyFee(int loan, int monthlyFee) {
    this.loan = loan;
    theActorInTheSpotlight()
        .should(
            seeThat(CalculatedLoanValue.is(), equalTo(loan))
                .orComplainWith(LoanValueException.class, LOAN_VALUE_ERROR.getMessage()),
            seeThat(MonthlyFeeValue.is(), equalTo(monthlyFee))
                .orComplainWith(
                    MonthlyFeeValueException.class, MONTHLY_FEE_VALUE_ERROR.getMessage()));
  }

  @Entonces(
      "la información detallada del préstamo es correspondiente de acuerdo al cálculo y a los datos ingresados")
  public void validateLoanInformation() {
    theActorInTheSpotlight()
        .should(
            seeThat(InTheLoanDetail.theValueOf(MONTHLY_INCOME).is(), equalTo(monthlyIncome))
                .orComplainWith(
                    DisplayedValueException.class,
                    String.format(DISPLAYED_VALUE_ERROR.getMessage(), MONTHLY_INCOME)),
            seeThat(InTheLoanDetail.theValueOf(LOAN).is(), equalTo(loan))
                .orComplainWith(
                    DisplayedValueException.class,
                    String.format(DISPLAYED_VALUE_ERROR.getMessage(), LOAN)),
            seeThat(
                    InTheLoanDetail.theValueOf(INITIAL_FEE).is(),
                    equalTo((int) Math.round(((double) loan * 30) / 70)))
                .orComplainWith(
                    DisplayedValueException.class,
                    String.format(DISPLAYED_VALUE_ERROR.getMessage(), INITIAL_FEE)),
            seeThat(
                    InTheLoanDetail.theValueOf(PROPERTY_VALUE).is(),
                    equalTo((int) Math.round(((double) loan * 100) / 70)))
                .orComplainWith(
                    DisplayedValueException.class,
                    String.format(DISPLAYED_VALUE_ERROR.getMessage(), PROPERTY_VALUE)));
  }
}
