package modules;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.MouseButton;

public class CoffeeCard extends BaseModule {
    public Locator coffeeContainer;

    public Locator coffeeName;

    public Locator coffeePrice;

    public Locator total;
    public CoffeeCard(Page page, String name) {
        super(page);
        this.page = page;
        coffeeName = page.locator("h4").getByText(name);
        coffeePrice = coffeeName.locator("small").first();
        total = page.locator("[data-test=\"checkout\"]");
        coffeeContainer = getCoffeeContainer(name);
    }

    public CoffeeCard(Page page) {
        super(page);
        this.page = page;
        coffeeName = page.locator("h4");
        coffeePrice = coffeeName.locator("small").first();
        total = page.locator("[data-test=\"checkout\"]");
    }

    public Locator getCoffeeContainer(String name){
        coffeeContainer= page.locator("[data-test="+name+"]");
        return coffeeContainer;
    }

    public void addToCart(String response){
        Locator button = page.locator("dialog").locator("button").getByText(response);
        button.click();
    }

    public void rightClick(String name){
        getCoffeeContainer(name).click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
    }
}
