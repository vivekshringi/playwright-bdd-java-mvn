package pages;

import com.microsoft.playwright.Page;
import modules.BaseModule;
import modules.CoffeeHeader;

public class CheckOutPage extends BaseModule {
    public CoffeeHeader header;

    public CheckOutPage(Page page) {
        super(page);
        this.header = new CoffeeHeader(page);
    }
}
