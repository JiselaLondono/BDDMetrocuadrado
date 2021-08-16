package com.tybatest.metrocuadrado.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public final class CreditResult {
  public static final Target VALUE =
      Target.the("Value generated according to the loan calculation")
          .locatedBy(
              "//div[@ng-show='showLoanInfo']//table//tr[@ng-repeat='bank in bankList']/td[{0}]");
  public static final Target DETAILED_LOAN_VALUES =
      Target.the("Loan information detail")
          .locatedBy("//div[@ng-show='showLoanInfo']/div[@class='datos_superior']//dl[{0}]//dd");
  public static final Target VALUE_BY_FEEL =
      Target.the("Value generated according to the calculation of the value of fees")
          .locatedBy(
              "//div[@ng-show='showLoanInfoByQuota']//table//tr[@ng-repeat='bank in bankList']/td[{0}]");
  public static final Target DETAILED_CREDIT_VALUES =
      Target.the("Fee calculation information detail")
          .locatedBy(
              "//div[@ng-show='showLoanInfoByQuota']/div[@class='datos_superior']//dl[{0}]//dd");

  private CreditResult() {}
}
