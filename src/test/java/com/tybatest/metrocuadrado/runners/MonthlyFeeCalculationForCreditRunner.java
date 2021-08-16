package com.tybatest.metrocuadrado.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features =
        "src/test/resources/features/monthly_fee_calculation/monthly_fee_calculation_for_credit.feature",
    glue = "com.tybatest.metrocuadrado.stepdefinitions",
    snippets = CucumberOptions.SnippetType.CAMELCASE)
public class MonthlyFeeCalculationForCreditRunner {}
