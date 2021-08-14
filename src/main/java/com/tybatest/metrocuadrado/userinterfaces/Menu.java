package com.tybatest.metrocuadrado.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public final class Menu {

  public static final Target MENU_OPTION =
      Target.the("Metrocuadrado system menu option")
          .locatedBy(
              "//nav[@role='navigation']/div[contains(@class, 'container-fluid')]//li//a[text()='{0}']");
  public static final Target SUBMENU_OPTION =
      Target.the("Metrocuadrado system submenu option")
          .locatedBy("//a[@data-gtm-title='{0}' and text()='{1}']");

  private Menu() {}
}
