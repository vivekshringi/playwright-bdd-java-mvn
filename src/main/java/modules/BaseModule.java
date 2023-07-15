package modules;

import com.microsoft.playwright.Page;

public class BaseModule {
    protected Page page;

    public BaseModule(Page page) {
        this.page = page;
    }
}
