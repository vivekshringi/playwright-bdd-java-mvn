package modules;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Payment extends BaseModule {
    public Locator cartPreview;

    public Locator add;

    public Locator remove;
    public Payment(Page page) {
        super(page);
        this.page = page;
        cartPreview = page.locator(".cart-preview show");
    }

    public Locator getOrder(int orderNo){
       return cartPreview.locator(".list-item").nth(orderNo-1);
    }

    public String getCoffeeName(int orderNo){
        return getOrder(orderNo).locator("div.span").innerText();
    }

    public String getCount(int orderNo){
        return getOrder(orderNo).locator("div.unit-desc").innerText();
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
