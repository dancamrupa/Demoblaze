# Demoblaze
Demoblaze platform automation

## Demoblaze module

Run the automation on the Demoblaze site following the process of selecting two products, going to the shopping cart, making the purchase, filling out a form with personal data and finalizing the purchase. Gradle, Java, SerenityBDD, Cucumber and Screenplay.

tools used on the project

Java 1.8	
requires Java 1.8 to run properly.

Gradle 7.0
Gradle is used to manage all dependencies

Cucumber 	
the automation tool to handle the .feature files with the Gherkin sintax

WebDriverManager 
the WebDriverManager for handling the appropiated WebDriver and may be set up on buildGradle file

Code Structure
the code was developed using screenplay pattern as below:


### Drivers	
contains all the drivers for each browser
### Questions	
Contains all the validations needed to ensure the tests
### Tasks	
Contains all the task to execute on the automation
### Uis	
contains all the abstraction classes with the selectors for each site
### Runners	
Contains all the runers to run the automation
### Steps Definitions	
Contains all the step definitions for each test
### Features	
Contains all the scenarios under the Gherkin language

## drivers

WebDriversSetup

This class contains the option and method to open the Google Chrome browser to open the url

package plataforma.demoblaze.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriversSetup {

    public static WebDriver driver;

    public static WebDriversSetup withChromeOptions() {

        WebDriverManager.chromedriver().setup();

        System.setProperty("webdriver.timeouts.implicitlywait", "10000");
        System.setProperty("serenity.take.screenshots","FOR_EACH_ACTION");
        System.setProperty("chrome.capabilities.unexpectedAlertBehavior", "ignore");
        System.setProperty("serenity.verbose.steps","FALSE");
        System.setProperty("serenity.report.encoding","UTF8");
        System.setProperty("feature.file.encoding","UTF8");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        options.addArguments("--allow-running-insecure-content --disable-popup-blocking --disable-dev-shm-usage");
        options.addArguments("--disable-infobars --test-type --disable-extensions --disable-translate");
        options.addArguments("--ignore-certificate-errors --disable-gpu --no-sandbox --disable-download-notification");

        driver = new ChromeDriver(options);
        return new WebDriversSetup();
    }

    public static WebDriver on(String url) {
        driver.get(url);
        return driver;
    }

    public static WebDriver quit(){
        driver.quit();
        return driver;
    }
}

## Questions

PurchaseMessage

This class contains a boolean response with the Question<String> implementation and returns a String Response that waits until the element is present.

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


## Tasks

BuyProducts
  
This task performs the selection of two products

public class BuyProducts implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        Click.on(PHONE_CATEGORY);
        Click.on(PRODUCTO_PHONE);
        Click.on(AAD_CART_BUTTON);
        Click.on(HOME_BUTTON);

        Click.on(LAPTOP_CATEGORY);
        Click.on(ProductsUserInterface.PRODUCTO_LAPTOP);
        Click.on(AAD_CART_BUTTON);
        Click.on(HOME_BUTTON);

        Click.on(CAR);
        Click.on(PLACE_ORDER);

    }

    public static BuyProducts on() {
        return Instrumented.instanceOf(BuyProducts.class).withProperties();
    }
}

FillForm
  
This task is responsible for filling out a form to make the purchase

public class FillForm implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        Enter.theValue("Pepito Perez").into(DATA_NAME);
        Enter.theValue("Colombia").into(DATA_COUNTRY);
        Enter.theValue("Bogota").into(DATA_CITY);
        Enter.theValue("420500482001").into(DATA_CREDIT_CARD);
        Enter.theValue("Marzo").into(DATA_MONTH);
        Enter.theValue("2025").into(DATA_YEAR);

        Click.on(PURCHASE);
        Click.on(OK_BUTTON);

    }
    public static FillForm on() {
        return Instrumented.instanceOf(FillForm.class).withProperties();
    }
}

## UserInterfaces

BuyProductsUserInterface 

Here its where we can store all the locators using the class Target to stablish the element as a Target, the location method used is custom Xpaths that were made manually during the execution of the manual test.

public class BuyProductsUserInterface {

    public static final Target PURCHASE = Target.the("purchase")
            .locatedBy(("//button[contains(text(),'Purchase')]"));
    public static final Target OK_BUTTON = Target.the("OK button")
            .locatedBy(("//button[contains(text(),'OK')]"));
}

PlaceProductOrderUserInterface 

Here its where we can store all the locators using the class Target to stablish the element as a Target, the location method used is custom Xpaths that were made manually during the execution of the manual test.

public class PlaceProductOrderUserInterface {

    public static final Target HOME_BUTTON = Target.the("home button")
            .locatedBy("//li[@class='nav-item active']");
    public static final Target CAR = Target.the("car")
            .locatedBy(String.valueOf(By.id("cartur")));
    public static final Target PLACE_ORDER = Target.the("place order")
            .locatedBy(("//button[contains(text(),'Place Order')]"));
}

ProductCategoryUserInterface 

Here its where we can store all the locators using the class Target to stablish the element as a Target, the location method used is custom Xpaths that were made manually during the execution of the manual test.

public class ProductCategoryUserInterface {

    public static final Target PHONE_CATEGORY = Target.the("phone category")
            .locatedBy("//a[@id='itemc'][1]");
    public static final Target LAPTOP_CATEGORY = Target.the("laptop category")
            .locatedBy("//a[@id='itemc'][2]");

}

ProductFormUserInterface 

Here its where we can store all the locators using the class Target to stablish the element as a Target, the location method used is custom Xpaths that were made manually during the execution of the manual test.

public class ProductFormUserInterface {

    public static final Target DATA_NAME = Target.the("data name")
            .locatedBy(String.valueOf(By.id("name")));
    public static final Target DATA_COUNTRY = Target.the("data country")
            .locatedBy(String.valueOf(By.id("country")));
    public static final Target DATA_CITY = Target.the("data city")
            .locatedBy(String.valueOf(By.id("city")));
    public static final Target DATA_CREDIT_CARD = Target.the("data creditCart")
            .locatedBy(String.valueOf(By.id("card")));
    public static final Target DATA_MONTH = Target.the("data month")
            .locatedBy(String.valueOf(By.id("month")));
    public static final Target DATA_YEAR = Target.the("data year")
            .locatedBy(String.valueOf(By.id("year")));

}

ProductsUserInterface 

Here its where we can store all the locators using the class Target to stablish the element as a Target, the location method used is custom Xpaths that were made manually during the execution of the manual test.

public class ProductsUserInterface {

    public static final Target PRODUCTO_PHONE = Target.the("product phone")
            .locatedBy("//a[contains(text(),'Samsung galaxy s6')]");
    public static final Target PRODUCTO_LAPTOP = Target.the("product laptop")
            .locatedBy("//a[contains(text(),'2017 Dell 15.6 Inch')]");
    public static final Target AAD_CART_BUTTON = Target.the("add carr button")
            .locatedBy("//a[@class='btn btn-success btn-lg']");

}

SuccessfulPurchase 

Here its where we can store all the locators using the class Target to stablish the element as a Target, the location method used is custom Xpaths that were made manually during the execution of the manual test.

public class SuccessfulPurchase {

    public static final Target SUCCESSFUL_PURCHASE = Target.the("successful Purchase")
            .locatedBy("//h2[contains(text(),'Thank you for your purchase!')]");

}

## utils

GlobalData 

This class allows us to access the URL of the page, which we are going to do the automation

public class GlobalData {

    public static final String URL = "https://www.demoblaze.com/";

}

## Runner

Follows the steps and executes the proper methods on the stepdefinitions, this class runs via @RunWith from the class CucumberWithSerenity.class and uses @CucumberOptions to call the feature, set the glue folder with Steps Definitions and the snnipets output with CamelCase.

BuyProductsRunner

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/BuyProduct.feature",
        glue = "plataforma.demoblaze.stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

## Step Definitions

BuyProductsStepDefinitions

Before everything starts, its needed to create an instance of the actor using the OnStage class using the @Before annotation

    @Before
    public void startStage() {
        OnStage.setTheStage(new OnlineCast());
    }

The controller sets the options necessary to run the browser correctly with the line followed by the URL that is passed raw to the capability.


    @Given("the user wants to enter the demoblaze platform")
    public void theUserWantsToEnterTheDemoblazePlatform() {
        WebDriversSetup.withChromeOptions();
        OnStage.theActorCalled("DannyRuiz").can(BrowseTheWeb.with(WebDriversSetup.on(URL))
        );
    }

Holding the flow; When you execute the tasks of selecting the products to buy and fill out the form to finalize the purchase.

    @When("the user selects the products and makes the purchase on the demoblaze platform")
    public void theUserDelectsTheProductsAndMakesThePurchaseOnTheDemoblazePlatform() {
        OnStage.theActorCalled("DannyRuiz").attemptsTo(
                BuyProducts.on(),
                FillForm.on()
        );
    }

Holding the flow; Then validate the message that the purchase was made successfully

    @Then("the user will be able to buy the product")
    public void theUserWilBeAbleToBuyTheProduct() {

        theActorInTheSpotlight()
                .should(
                        seeThat(PurchaseMessage.ofUser())
                );
    }
}

## Feature

BuyProduct.feature

Feature: Purchase of products on the demoblaze platform

  Scenario: Successful purchase
    Given the user wants to enter the demoblaze platform
    When the user selects the products and makes the purchase on the demoblaze platform
    Then the user will be able to buy the product

buildGradle

version '1.0-SNAPSHOT'

repositories {
    mavenCentral()
    maven {
        url "https://plugins.gradle.org/m2/"
    }
}

buildscript {
    repositories {
        mavenCentral()
        maven {
            url "https://plugins.gradle.org/m2/"
        }
        google()
    }
    dependencies {
        classpath('net.serenity-bdd:serenity-gradle-plugin:2.5.8')
    }
}

apply plugin: 'java'
apply plugin: 'idea'
apply plugin: 'net.serenity-bdd.aggregator'

tasks.withType(JavaCompile) {
    options.encoding = 'UTF-8'
}

ext {
    serenityVersion = '2.4.24'
    serenityCucumberVersion = '2.4.24'
}

serenity {
    reports = ["single-page-html"]
}

dependencies {
    implementation "net.serenity-bdd:serenity-core:$rootProject.ext.serenityVersion"
    implementation "net.serenity-bdd:serenity-junit:$rootProject.ext.serenityVersion"
    implementation "net.serenity-bdd:serenity-screenplay:$rootProject.ext.serenityVersion"
    implementation "net.serenity-bdd:serenity-cucumber6:$rootProject.ext.serenityCucumberVersion"
    implementation "net.serenity-bdd:serenity-screenplay-webdriver:$rootProject.ext.serenityVersion"
    implementation "net.serenity-bdd:serenity-ensure:$rootProject.ext.serenityVersion"
    implementation "net.serenity-bdd:serenity-reports:$rootProject.ext.serenityVersion"
    implementation 'org.seleniumhq.selenium:selenium-java:3.141.59'
    implementation 'io.github.bonigarcia:webdrivermanager:5.3.1'
    implementation 'org.apache.poi:poi-ooxml:4.0.0'

}

gradle.startParameter.continueOnFailure = true
test.finalizedBy(aggregate)

## Execution

in order to execute the project and generates the Aggregate report provided by Serenity BDD, we open the CMD on the IDE and type the follow command.

   gradle clean test aggregate

these command executes all the declared scenarios on this project

   1 actionable task: 1 executed

At the end we must go and open the file index.html that is located on on the following route

 <ProjectoName>\target\site\serenity\index.html

This Readme.md was made it by Danny Camilo Ruiz Pardo


