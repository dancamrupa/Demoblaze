package plataforma.demoblaze.userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class BuyProductsUserInterface {

    public static final Target PURCHASE = Target.the("purchase")
            .locatedBy(("//button[contains(text(),'Purchase')]"));
}
