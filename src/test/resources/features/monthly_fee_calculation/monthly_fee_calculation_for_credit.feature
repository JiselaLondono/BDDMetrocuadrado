#language: es
#Autor: Jisela Londoño Herrera

Característica: Calcular valor de cuotas de Crédito Hipotecario en Metrocuadrado
  Como usuario del sistema de Metrocuadrado
  Quiero simular cuánto sería el valor de la cuota a pagar a un banco
  Para la adquisión de vivienda

  Esquema del escenario: Cálculo exitoso de valor de cuota para crédito hipotecario
    Dado que Jisela quiere hacer uso de la 'Calculadora de crédito', una de las 'Herramientas' de Metrocuadrado
    Y quiere simular el cálculo de 'cuotas mensuales' a pagar a un banco para un Crédito Hipotecario
    Cuando indica un valor del crédito de <credito> y un plazo en años de <plazo>
    Entonces ella debería ver un resumen con el valor de cuota mensual de <cuota> y valor de préstamo de <credito>
    Y la información detallada del crédito es correspondiente de acuerdo al cálculo y a los datos ingresados

    Ejemplos:
      | credito  | plazo | cuota  |
      | 15000000 | 15    | 159340 |
      | 75000000 | 10    | 982753 |

  @manual-result:passed
  @manual-last-tested:sprint-1
  @manual-test-evidence:assets/manual_test_fee_calculation_case_1.PNG
  Esquema del escenario: Cálculo no exitoso de valor de cuota por valor de crédito inferior al permitido
    Dado que Jisela quiere hacer uso de la 'Calculadora de crédito', una de las 'Herramientas' de Metrocuadrado
    Y quiere simular el cálculo de 'cuotas mensuales' a pagar a un banco para un Crédito Hipotecario
    Cuando indica un valor del crédito de <credito> y un plazo en años de <plazo>
    Entonces ella debería ver el siguiente mensaje: 'El valor del crédito debe ser mayor o igual a $15,000,000.'

    Ejemplos:
      | credito  | plazo |
      | 14999999 | 15    |