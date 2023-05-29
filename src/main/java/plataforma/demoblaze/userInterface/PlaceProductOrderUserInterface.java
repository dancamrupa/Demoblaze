package plataforma.demoblaze.userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class PlaceProductOrderUserInterface {

    public static final Target HOME_BUTTON = Target.the("home button")
            .locatedBy("//li[@class='nav-item active']");
    public static final Target CAR = Target.the("car")
            .locatedBy("//a[@id='cartur']");
    public static final Target PLACE_ORDER = Target.the("place order")
            .locatedBy("//button[contains(text(),'Place Order')]");
}
