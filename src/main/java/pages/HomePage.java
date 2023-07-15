package pages;

import com.microsoft.playwright.Page;
import modules.ProductCard;

public class HomePage extends BasePage {

    public HomePage(Page page) {
        super(page);
    }

    public void open() {
        page.navigate("/");
    }

    public ProductCard getProductCardLocator(String productName) {
        return new ProductCard(page, productName);
    }
}
