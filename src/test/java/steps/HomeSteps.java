package steps;

import enums.SharedInfoTag;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modules.ProductCard;
import pages.HomePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SearchSteps extends BaseSteps {
    private final HomePage homePage;

    public SearchSteps(ScenarioContext scenarioContext) {
        super(scenarioContext);
        homePage = new HomePage(page);
    }

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        homePage.open();
    }

    @When("I search for {string}")
    public void iSearchFor(String query) {
        page.click(".DocSearch-Button-Placeholder");
        page.fill("#docsearch-input", query);
        scenarioContext.setSharedInfo(SharedInfoTag.TEST, query);
    }

    @Then("I should see search results")
    public void iShouldSeeSearchResults() {
        page.waitForSelector(".DocSearch-Hit-Container");
        assertThat(page.locator(".DocSearch-Hit-Container").first()).isVisible();

        String cos = this.scenarioContext.getSharedInfo(SharedInfoTag.TEST, String.class);
        System.out.println("dd");
    }

    @When("I add {string} {string} in {string} size")
    public void iAddInSize(String color, String name, String size) {
        ProductCard productCard = homePage.getProductCardLocator(name);

        productCard.selectColor(color);
        productCard.selectSize(size);
        productCard.addToCartButton.click();

        System.out.println("ll");
    }
}

