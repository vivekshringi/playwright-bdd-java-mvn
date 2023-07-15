package steps;

import com.microsoft.playwright.Page;

public class BaseSteps {
    protected World world;
    protected Page page;

    public BaseSteps(World world) {
        this.world = world;
        this.page = this.world.page;
    }
}
