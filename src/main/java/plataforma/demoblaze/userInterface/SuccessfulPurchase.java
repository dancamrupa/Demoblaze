package plataforma.demoblaze.userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class SuccessfulPurchase {

    public static final Target SUCCESSFUL_PURCHASE = Target.the("successful Purchase")
            .locatedBy("//h2[contains(text(),'Thank you for your purchase!')]");

}
