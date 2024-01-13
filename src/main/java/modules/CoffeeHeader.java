package modules;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CoffeeHeader extends BaseModule {

    public Locator menu;
    public Locator cart;
    public Locator github;

    public CoffeeHeader(Page page) {
        super(page);
        menu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("menu"));
        cart = page.getByLabel("Cart page");
        github = page.getByLabel("GitHub page");
    }

    public String getItems() {
       String cart = this.cart.innerText();
        return cart.substring(cart.indexOf("(")+1,cart.indexOf(")"));
    }
}
