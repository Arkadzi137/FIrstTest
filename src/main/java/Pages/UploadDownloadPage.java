package Pages;

import Framework.Elements.Button;
import Framework.Elements.Input;
import Framework.Elements.Label;
import Framework.Util.FileUtils;
import Framework.Util.ReadJson;
import org.openqa.selenium.By;

public class UploadDownloadPage extends BaseForm {
    public UploadDownloadPage() {
        super(new Button(By.xpath("//a[@id = 'downloadButton']"), "Upload Download page"), "Upload Download page");
    }

    private final static String downloadDirectory = ReadJson.getConfigData("downloadDirectory").toString();
    private Button buttonDownload = new Button(By.xpath("//a[@id = 'downloadButton']"), "Download button");
    private Input buttonUpload = new Input(By.xpath("//input[@id = 'uploadFile']"), "Upload File button");
    private Label textBelowUploadButton = new Label(By.xpath("//p[@id = 'uploadedFilePath']"), "Upload File button");

    public void clickButtonDownload(){
        buttonDownload.click();
    }

    public String getNameFile(){
        return buttonDownload.getAttribute("download");
    }

    public boolean fileIsExists(){
       return FileUtils.fileExists(downloadDirectory,getNameFile());
    }

    public void fileUpload(){
        FileUtils.fileUpload(buttonUpload,downloadDirectory,getNameFile());
    }

    public String getTextBelowUploadButton() {
        return textBelowUploadButton.getText();
    }
}
