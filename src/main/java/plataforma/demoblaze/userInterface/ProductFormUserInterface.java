package plataforma.demoblaze.userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class ProductFormUserInterface {

    public static final Target DATA_NAME = Target.the("data name")
            .locatedBy("//input[@id='name']");
    public static final Target DATA_COUNTRY = Target.the("data country")
            .locatedBy("//input[@id='country']");
    public static final Target DATA_CITY = Target.the("data city")
            .locatedBy("//input[@id='city']");
    public static final Target DATA_CREDIT_CARD = Target.the("data creditCart")
            .locatedBy("//input[@id='card']");
    public static final Target DATA_MONTH = Target.the("data month")
            .locatedBy("//input[@id='month']");
    public static final Target DATA_YEAR = Target.the("data year")
            .locatedBy("//input[@id='year']");

}
