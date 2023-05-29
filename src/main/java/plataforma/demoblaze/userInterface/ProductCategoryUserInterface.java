package plataforma.demoblaze.userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class ProductCategoryUserInterface {

    public static final Target PHONE_CATEGORY = Target.the("phone category")
            .locatedBy("//a[@id='itemc'][1]");
    public static final Target LAPTOP_CATEGORY = Target.the("laptop category")
            .locatedBy("//a[@id='itemc'][2]");

}
