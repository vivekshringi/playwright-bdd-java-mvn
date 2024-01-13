package steps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;


public class Hooks extends BaseSteps {

    public Hooks(ScenarioContext scenarioContext) {
        super(scenarioContext);
    }

    @AfterAll
    static void after_all() {
        System.out.print("AfterAll");
        ScenarioContext.playwright.close();
    }

    @Before
    static void before() {
        System.out.print("Before");
    }

    private void takeScreenshot(Page page, Boolean fullpage, String scenarioTraceName){
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("target", "Screenshots",scenarioTraceName + ".png"))
                .setFullPage(fullpage));
    }

    private void attachingVideoToTheHTMLReport(Page page, String scenarioTraceName, Scenario scenario){
        Path path = page.video().path();
        File file = new File(String.valueOf(path));
        byte[] b = new byte[(int) file.length()];
        try{
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(b);
        }
        catch (FileNotFoundException e){
            System.out.println("File Not Found.");
            e.printStackTrace();
        }
        catch (IOException e1)
        {
            System.out.println("Error Reading The File.");
            e1.printStackTrace();
        }
        scenario.attach(b,"video/.webm", scenarioTraceName);
    }

    private void attachingScreenShotToTheHTMLReport(Scenario scenario, String scenarioTraceName) throws IOException {
        BufferedImage bImage = ImageIO.read(new File(scenarioTraceName + ".png"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "png", bos );
        byte [] data = bos.toByteArray();
        scenario.attach(data,"image/png", scenarioTraceName);
    }

    private void attachingTraceToTheHTMLReport(Scenario scenario, Path tracePath){
        String html = "<a href="+tracePath+">link text</a>";
        scenario.attach(html.getBytes(), "text/html",tracePath+".zip");
    }
    @After
    public void after(Scenario scenario) throws IOException {
        System.out.print("After");
        String scenarioTraceName = scenario.getName().toLowerCase(Locale.ROOT).replace(" ", "-");
        if (scenario.isFailed()) {
            takeScreenshot(page,true, scenarioTraceName);
            attachingScreenShotToTheHTMLReport(scenario,scenarioTraceName);
        }
        Path tracePath = Paths.get("target", "Traces", scenarioTraceName + "-trace.zip");
        this.scenarioContext.context.tracing().stop(new Tracing.StopOptions()
                    .setPath(tracePath));
        this.scenarioContext.context.close();
        this.scenarioContext.cleanUp();
         attachingVideoToTheHTMLReport(page, scenarioTraceName, scenario);
    }
}
