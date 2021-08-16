package com.tybatest.metrocuadrado.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class CreditCalculator {
  public static final Target CALCULATOR_TYPE =
      Target.the("Type of calculator to simulate credit").locatedBy("//a[@class='ver{0}']");
  public static final Target MONTHLY_INCOME =
      Target.the("Text field to type monthly income").located(By.id("ingresosMensuales"));
  public static final Target TERM_IN_YEARS =
      Target.the("Selection list to choose term in years")
          .locatedBy("//select[@ng-model='termInYears']");
  public static final Target CALCULATE_CREDIT_BUTTON =
      Target.the("Button to calculate credit information")
          .locatedBy("//button/h4[text()='Calcular Crédito']");
  public static final Target CREDIT_VALUE =
      Target.the("Text field to type credit value").located(By.name("loadAmount"));
  public static final Target TERM_IN_YEARS_BY_FEE =
      Target.the("Selection list to choose term in years by fee")
          .locatedBy("//select[@ng-model='termInYearsByQuota']");
  public static final Target CALCULATE_FEES_BUTTON =
      Target.the("Button to calculate fees information")
          .locatedBy("//button/h4[text()='Calcular Cuotas']");

  private CreditCalculator() {}
}
