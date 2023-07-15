package steps;

import com.microsoft.playwright.Page;

public class BaseSteps {
    protected ScenarioContext scenarioContext;
    protected Page page;

    public BaseSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
        this.page = this.scenarioContext.page;
    }
}
