package com.tybatest.metrocuadrado.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CreditResult {
  public static final Target VALUE =
      Target.the("")
          .locatedBy(
              "//div[@ng-show='showLoanInfo']//table//tr[@ng-repeat='bank in bankList']/td[{0}]");
  public static final Target DETAILED_CREDIT_VALUES =
      Target.the("")
          .locatedBy("//div[@ng-show='showLoanInfo']/div[@class='datos_superior']//dl[{0}]//dd");
}
