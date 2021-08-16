#language: es
#Autor: Jisela Londoño Herrera

Característica: Calcular préstamo de Crédito Hipotecario en Metrocuadrado
  Como usuario del sistema de Metrocuadrado
  Quiero simular cuánto me puede prestar un banco
  Para la adquisión de vivienda

  Esquema del escenario: Cálculo exitoso de préstamo para crédito hipotecario
    Dado que Jisela quiere hacer uso de la 'Calculadora de crédito', una de las 'Herramientas' de Metrocuadrado
    Y quiere simular el cálculo del 'préstamo' a pagar a un banco para un Crédito Hipotecario
    Cuando indica un valor de ingresos mensuales de <ingresos> y un plazo en años de <plazo>
    Entonces ella debería ver un resumen con el valor estimado de préstamo de <prestamo> y valor de cuota mensual de <cuota>
    Y la información detallada del préstamo es correspondiente de acuerdo al cálculo y a los datos ingresados

    Ejemplos:
      | ingresos | plazo | prestamo  | cuota   |
      | 9000000  | 10    | 206053903 | 2700000 |
      | 737717   | 10    | 16889941  | 221315  |

  @manual-result:passed
  @manual-last-tested:sprint-1
  @manual-test-evidence:assets/manual_test_loan_calculation_case_1.PNG
  Esquema del escenario: Cálculo no exitoso de préstamo por valor de ingreso mensual inferior al permitido
    Dado que Jisela quiere hacer uso de la 'Calculadora de crédito', una de las 'Herramientas' de Metrocuadrado
    Y quiere simular el cálculo del 'préstamo' a pagar a un banco para un Crédito Hipotecario
    Cuando indica un valor de ingresos mensuales de <ingresos> y un plazo en años de <plazo>
    Entonces ella debería ver el siguiente mensaje: 'Los ingresos deben ser mayores o iguales a $737,717.'

    Ejemplos:
      | ingresos | plazo |
      | 737716   | 10    |