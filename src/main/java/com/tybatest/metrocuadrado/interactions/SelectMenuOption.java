package com.tybatest.metrocuadrado.interactions;

import static com.tybatest.metrocuadrado.userinterfaces.Menu.MENU_OPTION;
import static com.tybatest.metrocuadrado.userinterfaces.Menu.SUBMENU_OPTION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

public class SelectMenuOption implements Interaction {

  private String menuOption;
  private String submenuOption;

  public SelectMenuOption(String menuOption) {
    this.menuOption = menuOption;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Click.on(MENU_OPTION.of(menuOption)),
        Click.on(SUBMENU_OPTION.of(menuOption, submenuOption)),
        OpenNextTab.inBrowser()
        /*Switch.toWindow(TITLE)*/ );
  }

  public static SelectMenuOption named(String menuOption) {
    return instrumented(SelectMenuOption.class, menuOption);
  }

  public SelectMenuOption andSubmenu(String submenuOption) {
    this.submenuOption = submenuOption;
    return this;
  }
}
