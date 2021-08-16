# BDDMetrocuadrado

El proyecto BDDMetrocuadrado contiene en la actualidad la automatización de la **Calculadora de crédito de vivienda**, una de las herramientas más importantes dentro del sistema de Metrocuadrado. A nivel general, se tienen escenarios automatizados del cálculo de préstamo para crédito y el cálculo del valor de las cuotas, las cuales son las funcionalidades que maneja la calculadora. Por otro lado, se tienen especificados escenarios manuales que complementan la cobertura de las pruebas a aplicar en dichas funcionalidades. 
### **Dominio de la aplicación**
Una de las herramientas que maneja la aplicación de Metrocuadrado es la **Calculadora de crédito para vivienda**. A través de ella, un usuario puede simular el cálculo de cuánto le puede prestar un banco para la compra de su apartamento o casa, de acuerdo a sus ingresos mensuales. Por otro lado, también puede calcular el valor de la cuota mensual de su crédito de vivienda.

### **Detalles de la implementación y estrategia**

Para el desarrollo de este proyecto, se utilizaron las siguientes herramientas:
+ IDE: Intellij IDEA Community Edition 2020.3.1
+ Automatizador de tareas y manejo de dependencias: Gradle v6.6
+ Lenguaje de programación: Java / JDK v1.8.0_271
+ Sistema de Control de Versiones: Git
+ Navegador: Google Chrome v91
+ Driver: ChromeDriver v91.0.4472.19
+ Frameworks: SerenityBDD 
+ Herramienta BDD: Cucumber (Cucumber for Java plugin en el IDE)
+ Lenguaje de definición de escenarios: Gherkin

Como parte de la estrategia de automatización de este proyecto, el patrón de diseño utilizado es **Screenplay**. Este patrón se presenta como una mejora al patrón Page Object Model, ya que al usar POM, un automatizador construye código basado en la interfaz de usuario y no en las interacciones que tiene el usuario con el sistema. Screenplay es un gran ejemplo de la aplicación de los principios SOLID, sobre todo en el principio de Responsabilidad única y abierto-cerrado.

Implementar Screenplay permite escribir código en un lenguaje mucho más cercano al lenguaje natural y esto es evidenciado en los reportes. Obliga a pensar en términos de roles, objetivos y acciones para lograr esos objetivos. Para tener mayor información de este patrón, visita la página https://serenity-bdd.github.io/theserenitybook/latest/serenity-screenplay.html

En el apartado anterior se hizo mención del uso del framework de SerenityBDD. Dicho framework ayuda a escribir pruebas de aceptación automatizadas de mayor calidad y más rápido, y se caracteriza por escribir test flexibles y fáciles de mantener, generar informes ilustrativos sobre las pruebas, entre otros. Para tener un mayor conocimiento de este framework, visita la página http://serenity-bdd.info/docs/serenity/#introduction     

### **Estructura del proyecto**
La estructura completa del proyecto es la siguiente:

* ```src/main/java```
``` 
+ com.tybatest.metrocuadrado.exceptions
    Clases que capturan excepciones personalizadas cuando falla la automatización.

+ com.tybatest.metrocuadrado.interactions
    Clases que realizan las acciones adicionales que el usuario hace sobre la interfaz, y que el framework de SerenityBDD/screenplay no tiene.

+ com.tybatest.metrocuadrado.questions
    Clases con las que se hacen preguntas al sistema para luego ser verificadas en los stepdefinitions (asserts).  

+ com.tybatest.metrocuadrado.tasks
    Clases que representan las tareas que realiza el actor a nivel de proceso de negocio    

+ com.tybatest.metrocuadrado.userinterfaces
    Clases donde se mapean los elementos de la interfaz de usuario y a su vez para la interaccion con cada uno de estos elementos.

+ com.tybatest.metrocuadrado.utils
    Clases que contienen la utilería o funcionalidades en común, enums, constantes manejadas en el proyecto, etc.
``` 
* ```src/test/java```
``` 
+ com.tybatest.metrocuadrado.runners
    Runners para ejecutar la automatizacion con los escenarios indicados en el feature.
    
+ com.tybatest.metrocuadrado.stepdefinitions
    Clases que son el punto de entrada del feature para la ejecución de la automatización.
``` 
* ```src/test/resources```
```
+ assets
    Archivos de evidencia de los escenarios manuales contemplados en el proyecto.
    
+ features
    Representación de los escenarios de prueba en lenguaje Gherkin a través de archivos cucumber.
    
+ results_reports
    Archivos del último reporte de pruebas generado por SerenityBDD y otros archivos complementarios.    
```

### **Requisitos para la ejecución**

Tener instalado y configurado el funcionamiento de lo siguiente:

+ Java JDK 1.8 (variables de entorno configuradas)
+ IDE de desarrollo, preferiblemente Intellij IDEA Community Edition v2020.3.1 o superior.
  + En el IDE tener instalado el plugin Cucumber for Java y Gherkin
+ Gradle v6.6 o superior (variables de entorno configuradas)
+ Git
+ Navegador Google Chrome v91

**Nota:** _Dado que el driver utilizado dentro de la automatización se encuentra dentro de la raíz del proyecto ./chromedriver.exe, cuya versión es 91.0.4472.19, es importante considerar que éste soporta la versión 91 de Chrome. En caso de que, si la máquina en la que se ejecutará este proyecto tenga una versión del navegador superior a la 91 y la ejecución falla, por favor actualizar la versión del chromedriver por una que soporte la versión del navegador Chrome._ 

### **Comandos para la ejecución de los escenarios**

Para la ejecución de los escenarios de prueba desde la Terminal:

+ Se puede usar el comando: `gradlew test`, el cual ejecuta todos los tests.

+ O tenemos la siguiente instrucción, la cual permite ejecutar todos los test, brindando información en la consola sobre la ejecución: `gradlew clean test --tests com.tybatest.metrocuadrado.runners* --info aggregate`


### **Reportes de resultados de las pruebas**

+ Dado que SerenityBDD se caracteriza por generar reportes detallados que indican el estado funcional de la aplicación y que sirven también como documentación viva, una vez que se ejecutan los tests, se genera un archivo html llamado index.html, el cual contiene el detalle de la ejecución. Este reporte se presenta en la ruta del proyecto `./target/site/serenity/index.html`. Hay que tener en cuenta que esta ruta se genera cuando se ha presentado la primera ejecución de los test.
+ Dentro de la ejecución de los tests de este proyecto, se presentaron resultados exitosos y fallidos de algunos escenarios, los cuales se evidencian detalladamente en el reporte. Para visualizar esto dentro de este repositorio, por favor dirigirse a la ruta `src/test/resources/results_reports/last_run_report.pdf`. Aquí también se evidencia el reporte de aquellos escenarios que se ejecutaron de manera manual.
+ Por otro lado tenemos el Serenity Summary Report. Este es un informe de resumen html autónomo de una sola página, que contiene una descripción general de los resultados de la prueba. Para generarlo, se debe ejecutar el comando `gradle reports`
+ El Serenity Summary Report de la última ejecución de los escenarios de prueba del proyecto se encuentra en la ruta `src/test/resources/results_reports/serenity_summary_report.pdf`

