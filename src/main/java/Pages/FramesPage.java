package Pages;

import Framework.BrowserFactory.BrowserUtil;
import Framework.Elements.Label;
import org.openqa.selenium.By;

public class FramesPage extends BaseForm {
    public FramesPage() {
        super(new Label(By.id("frame1"),"frames page"),"frames page");
    }

    private String bigFrameId = "frame1";
    private String smallFrameId = "frame2";
    private Label frameText = new Label(By.xpath("//body//h1"),"frame text");

    public String getTextFromBigFrame(){
        BrowserUtil.switchToIframe(bigFrameId);
        String text = frameText.getText().trim();
        BrowserUtil.switchToBasePage();
        return text;
    }

    public String getTextFromSmallFrame(){
        BrowserUtil.switchToIframe(bigFrameId);
        String text = frameText.getText().trim();
        BrowserUtil.switchToBasePage();
        return text;
    }
}
