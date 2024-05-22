package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import modules.BaseModule;
import modules.CartOverview;
import modules.CoffeeCard;
import modules.CoffeeHeader;

public class MenuPage extends BaseModule {
    public CoffeeCard coffeeCard;
    public CoffeeHeader coffeeHeader;

    public CartOverview cartOverview;

    public Locator promo;
    public Locator acceptOffer;

    public Locator skipOffer;
    public MenuPage(Page page) {
        super(page);
        this.coffeeCard = new CoffeeCard(page);
        this.coffeeHeader = new CoffeeHeader(page);
        this.promo =  page.locator(".promo");
        this.cartOverview = new CartOverview(page);
        this.acceptOffer = promo.locator("button.yes").getByText("Yes");
        this.skipOffer = promo.locator("button").nth(1);
    }

    public void open(String appURL) {
        page.navigate(appURL);
    }

    public void selectCoffee(String name) {
        this.getCoffeeContainer(name).click();
    }

    public Locator getCoffeeContainer(String name){
        coffeeCard.coffeeContainer = page.locator("[data-test="+name+"]");
        return coffeeCard.coffeeContainer;
    }


    public void doubleClick(String name) {
        coffeeCard.coffeeName.getByText(name).first().dblclick();
    }

    public void hoverOnCoffee(String name) {
        this.getCoffeeContainer(name).hover();
    }

    public String propertyOnHover() {
        return  (String) coffeeCard.coffeeContainer.evaluate("el=>getComputedStyle(el).borderColor");
    }

    public String getTotalText() {
        coffeeCard.total.isVisible();
        return coffeeCard.total.innerText();
    }

    public String getPriceText() {
        coffeeCard.coffeePrice.isVisible();
        return coffeeCard.coffeePrice.innerText();
    }

    public void isPromoExist() {
        promo.isVisible();
        coffeeCard.coffeePrice.innerText();
    }
}


