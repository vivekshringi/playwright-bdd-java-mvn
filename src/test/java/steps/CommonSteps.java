package steps;

import io.cucumber.java.en.Then;
import pages.BasePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CommonSteps extends BaseSteps {
    private final BasePage lumaPage;

    public CommonSteps(ScenarioContext scenarioContext) {
        super(scenarioContext);
        this.lumaPage = new BasePage(page);
    }

    @Then("I should see {string} notification")
    public void iShouldSeeNotification(String expectedAlertText) {
        assertThat(lumaPage.alert).hasText(expectedAlertText);
    }
}
