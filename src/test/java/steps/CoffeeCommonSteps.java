package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.CoffeeModel;
import modules.CoffeeCard;
import org.junit.Assert;
import pages.CheckOutPage;
import pages.MenuPage;

public class CoffeeCommonSteps extends BaseSteps {
    private final MenuPage menuPage;

    private final CheckOutPage checkOutPage;

    public CoffeeCommonSteps(ScenarioContext scenarioContext) {
        super(scenarioContext);
        this.menuPage = new MenuPage(page);
        this.checkOutPage = new CheckOutPage(page);
    }

    @Given("I opened the coffee shop online")
    public void i_opened_the_coffee_shop_online(){
      menuPage.open("https://coffee-cart.app/");
    }

    @When("I ordered {string}")
    public void i_ordered(String name) {
        menuPage.selectCoffee(name);
    }

    @Then("I should see that one {string} is added into cart")
    public void iShouldSeeItemIsAddedIntoCart(String name) {
        CoffeeModel c = scenarioContext.getSharedInfo(name,CoffeeModel.class);
        Assert.assertEquals(menuPage.coffeeHeader.getItems(),c.getItems().replace('0','1'));
    }

    @And("I should see that Total Price is not same and increased by {string} Price")
    public void iShouldSeeThatTotalPriceIsNotAndIncreasedByCoffeePrice(String name) {
        CoffeeModel c = scenarioContext.getSharedInfo(name ,CoffeeModel.class);
        Assert.assertEquals(menuPage.getTotalText(),"Total: "+c.getPrice());
    }

    @And("I checked {string} price, cart status and total amount on menu page")
    public void iCheckedPriceCartStatusAndTotalAmountOnMenuPage(String name) {
            menuPage.coffeeCard = new CoffeeCard(page, name);
            String price = menuPage.getPriceText();
            String total = menuPage.getTotalText();
            String item = menuPage.coffeeHeader.getItems();
            CoffeeModel c = CoffeeModel.builder().name(name).price(price).total(total).items(item).build();
            System.out.print(c);
            System.out.print(c.getName());
            scenarioContext.setSharedInfo(c.getName(),c);
        }

    @Then("I should see that no {string} is added into cart")
    public void iShouldSeeThatNoItemIsAddedIntoCart(String name) {
        CoffeeModel c = scenarioContext.getSharedInfo(name, CoffeeModel.class);
        System.out.println(c.getItems());
        Assert.assertEquals(menuPage.coffeeHeader.getItems(),c.getItems());
    }

    @And("I should see that Total Price is equal to {string}")
    public void iShouldSeeThatTotalPriceIsEqualTo$(String arg0) {
        CoffeeModel c = scenarioContext.getSharedInfo("Espresso",CoffeeModel.class);
        Assert.assertEquals(menuPage.getTotalText(),"Total: "+arg0);
        scenarioContext.cleanUp();
    }

    @When("I double clicked {string}")
    public void iDoubleClicked(String name) {
        menuPage.coffeeCard = new CoffeeCard(page);
        menuPage.doubleClick(name);
    }

    @Then("The coffee name should be changed from {string} to {string}")
    public void theCoffeeNameShouldBeChangedTo(String englishName, String chineseName) {
        String name = menuPage.coffeeCard.coffeeName.getByText(chineseName).textContent();
        name = name.split(" ")[0];
        Assert.assertEquals(name,chineseName);
    }

    @And("I hover on {string}")
    public void iHoverOn(String name) {
        menuPage.coffeeCard = new CoffeeCard(page,name);
        menuPage.hoverOnCoffee(name);
    }

    @Then("{string} Coffee card border color should be changed to {string}")
    public void coffeeCardBorderColorShouldBeChangedTo(String name, String color) {
        menuPage.coffeeCard = new CoffeeCard(page, name);
        String borderColor = menuPage.propertyOnHover();
        Assert.assertEquals(borderColor, color);
    }

    @When("I right click on {string}")
    public void iRightClickOn(String name) {
        menuPage.coffeeCard = new CoffeeCard(page, name);
        menuPage.coffeeCard.rightClick(name);
    }

    @When("I clicked {string} to add in the cart")
    public void iClickedToAddInTheCart(String response) {
      menuPage.coffeeCard.addToCart(response);
    }

    @Then("I get one {string} coffee in {string} offer to select")
    public void iGetOneCoffeeInOfferToSelect(String arg0, String arg1) {
        menuPage.isPromoExist();
        String offerText = menuPage.promo.locator("span").innerText();
        Assert.assertTrue(offerText.contains(arg0));
        Assert.assertTrue(offerText.contains(arg1));
    }

    @When("I skip the offer")
    public void iSkipTheOffer() {
        menuPage.skipOffer.click();
    }

    @And("Promo coffee is not added in my cart and it shows {string} items")
    @And("Promo coffee is added in my cart and it shows {string} items")
    public void promoCoffeeIsNotAddedInMyCartAndItShowsItems(String items) {
        Assert.assertEquals(items, menuPage.coffeeHeader.getItems());
    }

    @When("I accept the offer")
    public void iAcceptTheOffer() {
        menuPage.acceptOffer.click();
    }

    @When("I hover on total price")
    public void iHoverOnTotalPrice() {
        menuPage.coffeeCard.total.hover();
    }

    @Then("I can see cart overview with {string} {string}")
    public void iCanSeeCartOverviewIncluding(String count, String coffeeName) {
        Assert.assertTrue(menuPage.cartOverview.cartPreview.isVisible());
        Assert.assertEquals(menuPage.cartOverview.getCoffeeName(0),coffeeName);
        Assert.assertEquals(menuPage.cartOverview.getCount(0)," x "+count);
    }
}
