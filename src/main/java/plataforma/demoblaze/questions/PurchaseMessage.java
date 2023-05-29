package plataforma.demoblaze.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static plataforma.demoblaze.userInterface.SuccessfulPurchase.SUCCESSFUL_PURCHASE;

public class PurchaseMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(SUCCESSFUL_PURCHASE, isPresent()));
        return Text.of(SUCCESSFUL_PURCHASE).viewedBy(actor).asString();
    }

    public static PurchaseMessage ofUser() {
        return new PurchaseMessage();
    }

}
