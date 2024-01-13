package modules;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.MouseButton;

public class CartOverview extends BaseModule {
    public Locator cartPreview;

    public Locator add;

    public Locator remove;
    public CartOverview(Page page) {
        super(page);
        this.page = page;
        cartPreview = page.locator(".cart-preview.show");
    }

    public Locator getOrder(int orderNo){
       return cartPreview.locator(".list-item").nth(orderNo);
    }

    public String getCoffeeName(int orderNo){
        return getOrder(orderNo).locator("div>span").first().innerText();
    }

    public String getCount(int orderNo){
        return getOrder(orderNo).locator(".unit-desc").innerText();
    }

    public void addOrder(int orderNo){
        add = getOrder(orderNo).locator(".unit-controller").getByText("+");
        add.click();
    }

    public void removeOrder(int orderNo){
        remove = getOrder(orderNo).locator(".unit-controller").getByText("+");
        remove.click();
    }

}
