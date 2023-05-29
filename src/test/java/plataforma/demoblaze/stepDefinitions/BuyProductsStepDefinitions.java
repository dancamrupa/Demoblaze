package plataforma.demoblaze.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import plataforma.demoblaze.driver.WebDriversSetup;
import plataforma.demoblaze.questions.PurchaseMessage;
import plataforma.demoblaze.tasks.BuyProducts;
import plataforma.demoblaze.tasks.FillForm;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static plataforma.demoblaze.utils.GlobalData.URL;

public class BuyProductsStepDefinitions {

    @Before
    public void startStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("the user wants to enter the demoblaze platform")
    public void theUserWantsToEnterTheDemoblazePlatform() {
        WebDriversSetup.withChromeOptions();
        OnStage.theActorCalled("DannyRuiz").can(BrowseTheWeb.with(WebDriversSetup.on(URL))
        );
    }

    @When("the user selects the products and makes the purchase on the demoblaze platform")
    public void theUserDelectsTheProductsAndMakesThePurchaseOnTheDemoblazePlatform() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                BuyProducts.on(),
                FillForm.on()
        );
    }

    @Then("the user will be able to buy the product")
    public void theUserWilBeAbleToBuyTheProduct() {

        theActorInTheSpotlight()
                .should(
                        seeThat(PurchaseMessage.ofUser())
                );
    }
}