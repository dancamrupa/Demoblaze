package plataforma.demoblaze.userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class ProductsUserInterface {

    public static final Target PRODUCTO_PHONE = Target.the("product phone")
            .locatedBy("//a[contains(text(),'Samsung galaxy s6')]");
    public static final Target PRODUCTO_LAPTOP = Target.the("product laptop")
            .locatedBy("//a[contains(text(),'2017 Dell 15.6 Inch')]");
    public static final Target AAD_CART_BUTTON = Target.the("add carr button")
            .locatedBy("//a[@class='btn btn-success btn-lg']");

}
