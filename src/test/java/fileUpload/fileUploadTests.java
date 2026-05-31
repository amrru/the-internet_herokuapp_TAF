package fileUpload;
import base.baseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class fileUploadTests extends baseTests {
    @Test
    public void testFileUpload(){
        String filePath = "C:\\Users\\Amr\\IdeaProjects\\myFirstSeleniumProject1\\resources\\testfile.txt";
        var fileUploadPage = HomePage.clickFileUpload();
        fileUploadPage.uploadfile(filePath);
        assertEquals(fileUploadPage.getUploadedFileName(),"testfile.txt","The file name is incorrect");
    }
}
