package plataforma.demoblaze.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static plataforma.demoblaze.userInterface.PlaceProductOrderUserInterface.*;
import static plataforma.demoblaze.userInterface.ProductCategoryUserInterface.*;
import static plataforma.demoblaze.userInterface.ProductsUserInterface.*;

public class BuyProducts implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PHONE_CATEGORY),
                Click.on(PRODUCTO_PHONE),
                Click.on(AAD_CART_BUTTON),
                WaitUntil.the(HOME_BUTTON, isClickable()),
                Click.on(HOME_BUTTON),
                Click.on(LAPTOP_CATEGORY),
                Click.on(PRODUCTO_LAPTOP),
                Click.on(AAD_CART_BUTTON),
                WaitUntil.the(HOME_BUTTON, isClickable()),
                Click.on(HOME_BUTTON),
                WaitUntil.the(CAR, isClickable()),
                Click.on(CAR),
                Click.on(PLACE_ORDER)
        );
    }

    public static BuyProducts on() {
        return Instrumented.instanceOf(BuyProducts.class).withProperties();
    }
}
