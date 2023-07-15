package modules;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class Header extends BaseModule {

    public Locator welcomeMessage;
    public Locator signInLink;
    public Locator createAccountLink;

    public Header(Page page) {
        super(page);
        welcomeMessage = page.locator(".greet");
        signInLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign In"));
        createAccountLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create an Account"));
    }
}
