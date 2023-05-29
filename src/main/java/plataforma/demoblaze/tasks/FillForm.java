package plataforma.demoblaze.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static plataforma.demoblaze.userInterface.BuyProductsUserInterface.*;
import static plataforma.demoblaze.userInterface.ProductFormUserInterface.*;

public class FillForm implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue("Pepito Perez").into(DATA_NAME),
                Enter.theValue("Colombia").into(DATA_COUNTRY),
                Enter.theValue("Bogota").into(DATA_CITY),
                Enter.theValue("420500482001").into(DATA_CREDIT_CARD),
                Enter.theValue("Marzo").into(DATA_MONTH),
                Enter.theValue("2025").into(DATA_YEAR),
                Click.on(PURCHASE)
        );
    }

    public static FillForm on() {
        return Instrumented.instanceOf(FillForm.class).withProperties();
    }
}
