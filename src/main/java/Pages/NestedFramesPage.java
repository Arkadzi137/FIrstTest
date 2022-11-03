package Pages;

import Framework.BrowserFactory.BrowserUtil;
import Framework.Elements.Button;
import Framework.Elements.Label;
import Framework.Util.ReadJson;
import org.openqa.selenium.By;


public class NestedFramesPage extends BaseForm {
    public NestedFramesPage() {
        super(new Label(By.xpath("//iframe[@id = 'frame1']"),"nested frames page"),"nested frames page");
    }

    private String childExpectText = ReadJson.getTestingData("child_frame_text").toString().trim();
    private String parentExpectText = ReadJson.getTestingData("parent_frame_text").toString().trim();
    private String parentFrameId = "frame1";
    private Label frameText = new Label(By.xpath("//body"),"frame text");
    private Button buttonFrames = new Button(By.xpath("//div[contains(@class, 'show')]//li[@id='item-2']"),"button Web Tables");

    public boolean iframeContainText(){
        BrowserUtil.switchToIframe(parentFrameId);
        String parentText = frameText.getText().trim();
        BrowserUtil.switchToIframe(0);
        String childText = frameText.getText().trim();
        BrowserUtil.switchToBasePage();
        if (parentText.equals(parentExpectText) && childText.equals(childExpectText)) return true;
        return false;
    }

    public void clickButtonFrames(){
        buttonFrames.click();
    }
}
