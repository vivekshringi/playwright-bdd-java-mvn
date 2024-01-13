package steps;

import com.microsoft.playwright.*;
import enums.SharedInfoTag;
import java.nio.file.Paths;

import java.util.concurrent.ConcurrentHashMap;

public class ScenarioContext {
    public Page page;
    public static Playwright playwright = Playwright.create();
    public static Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(100));
    ;
    public BrowserContext context;
    private final ConcurrentHashMap<String, Object> sharedInfo = new ConcurrentHashMap<>();

    public ScenarioContext() {
        context = browser.newContext(
                new Browser.NewContextOptions().setBaseURL("/").setRecordVideoDir(Paths.get("target", "Videos"))
        );
        context.tracing().start(
                new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(true)
        );

        page = context.newPage();
        page.setDefaultTimeout(10000);
    }

    public <T> T getSharedInfo(SharedInfoTag key, Class<T> valueType) {
        return getSharedInfo(key.name(), valueType);
    }

    public <T> T getSharedInfo(String key, Class<T> valueType) {
        try {
            return valueType.cast(sharedInfo.get(key));
        } catch (ClassCastException e) {
            return null;
        }
    }

    public void setSharedInfo(SharedInfoTag key, Object obj) {
        setSharedInfo(key.name(), obj);
    }

    public void setSharedInfo(String key, Object obj) {
        sharedInfo.put(key, obj);
    }

    public void cleanUp() {
        sharedInfo.clear();
    }
}
