package com.tybatest.metrocuadrado.stepdefinitions;

import static com.tybatest.metrocuadrado.utils.Constants.INITIAL_FEE;
import static com.tybatest.metrocuadrado.utils.Constants.LOAN;
import static com.tybatest.metrocuadrado.utils.Constants.MONTHLY_INCOME;
import static com.tybatest.metrocuadrado.utils.Constants.PROPERTY_VALUE;
import static com.tybatest.metrocuadrado.utils.enums.ErrorMessages.DISPLAYED_VALUE_ERROR;
import static com.tybatest.metrocuadrado.utils.enums.ErrorMessages.LOAN_VALUE_ERROR;
import static com.tybatest.metrocuadrado.utils.enums.ErrorMessages.MONTHLY_FEE_VALUE_ERROR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import com.tybatest.metrocuadrado.exceptions.DisplayedValueException;
import com.tybatest.metrocuadrado.exceptions.LoanValueException;
import com.tybatest.metrocuadrado.exceptions.MonthlyFeeValueException;
import com.tybatest.metrocuadrado.interactions.SelectMenuOption;
import com.tybatest.metrocuadrado.questions.InTheLoanDetail;
import com.tybatest.metrocuadrado.questions.LoanValue;
import com.tybatest.metrocuadrado.questions.MonthlyFeeValue;
import com.tybatest.metrocuadrado.tasks.AddCreditCalculationInformation;
import com.tybatest.metrocuadrado.tasks.ChooseCalculationType;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class GeneralStepDefinition {

  private int loan;
  private int monthlyIncome;

  @Managed(driver = "chrome")
  WebDriver herBrowser;

  @Before
  public void setStage() {
    OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(herBrowser)));
  }

  @Dado("que {word} quiere hacer uso de la {string}, una de las {string} de Metrocuadrado")
  public void selectMenuOption(String actor, String submenuOption, String menuOption) {
    theActorCalled(actor)
        .wasAbleTo(
            Open.url("https://www.metrocuadrado.com/"),
            SelectMenuOption.named(menuOption).andSubmenu(submenuOption));
  }

  @Dado(
      "quiere simular el cálculo de/del {string} a pagar a un banco para/de un Crédito Hipotecario")
  public void selectCalculationType(String calculationType) {
    theActorInTheSpotlight()
        .attemptsTo(ChooseCalculationType.toSimulateCreditWith(calculationType));
  }

  @Cuando("indica un valor de ingresos mensuales de {int} y un plazo en años de {int}")
  public void addCreditCalculationData(int monthlyIncome, int term) {
    this.monthlyIncome = monthlyIncome;
    theActorInTheSpotlight()
        .attemptsTo(AddCreditCalculationInformation.withTheFollowingData(monthlyIncome, term));
  }

  @Entonces(
      "ella debería ver un valor estimado de préstamo de {int} y un valor de cuota mensual de {int}")
  public void validate(int loan, int monthlyFee) {
    this.loan = loan;
    theActorInTheSpotlight()
        .should(
            seeThat(LoanValue.is(), equalTo(loan))
                .orComplainWith(LoanValueException.class, LOAN_VALUE_ERROR.getMessage()),
            seeThat(MonthlyFeeValue.is(), equalTo(monthlyFee))
                .orComplainWith(
                    MonthlyFeeValueException.class, MONTHLY_FEE_VALUE_ERROR.getMessage()));
  }

  @Entonces(
      "la información detallada del préstamo es correspondiente de acuerdo al cálculo y a los datos ingresados")
  public void validate2() {
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
