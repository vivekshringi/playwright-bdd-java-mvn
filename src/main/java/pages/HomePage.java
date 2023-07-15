package pages;

import com.microsoft.playwright.Page;

public class HomePage extends BasePage {

    public HomePage(Page page) {
        super(page);
    }

    public void open() {
        page.navigate("https://playwright.dev/java");
    }
}
