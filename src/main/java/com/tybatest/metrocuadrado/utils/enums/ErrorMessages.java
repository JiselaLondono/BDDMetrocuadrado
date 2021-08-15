package com.tybatest.metrocuadrado.utils.enums;

public enum ErrorMessages {
  INVALID_VALUE_TYPE("El tipo de valor ingresado es inválido"),
  DISPLAYED_VALUE_ERROR(
      "Dentro de la información detallada, el valor presentado de %s no es el esperado"),
  LOAN_VALUE_ERROR("El valor estimado del préstamo presente en la tabla no es el esperado"),
  MONTHLY_FEE_VALUE_ERROR("El valor de la cuota mensual presente en la tabla no es el esperado");

  private String message;

  ErrorMessages(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
