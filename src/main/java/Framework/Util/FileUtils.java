package Framework.Util;

import Framework.Elements.Input;
import Framework.Log;

import java.io.File;

public class FileUtils {
    public static boolean fileExists(String downloadDirectory, String nameFile){
        File file = new File(downloadDirectory+nameFile);
        Log.info("file "+nameFile+" in "+downloadDirectory+" exists");
        return file.exists();
    }

    public static void fileUpload(Input inputElement, String downloadDirectory, String nameFile){
        File file = new File(downloadDirectory+nameFile);
        Log.info("file "+nameFile+" upload to "+ downloadDirectory);
        inputElement.sentKeys(file.getAbsolutePath());
    }
}
