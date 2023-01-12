package utils;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static void captureScreenShot(String TestCaseName, WebDriver driver) {
		TakesScreenshot t = (TakesScreenshot)driver ;
		
			File source = t.getScreenshotAs(OutputType.FILE);
		
			File destination = new File(System.getProperty("user.dir")+"//Screenshots//"+TestCaseName+" "+".jpeg");
		
			try {
				FileHandler.copy(source, destination);
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public static String getDatafromExcel(int i, int j) {	
		String path = System.getProperty("user.dir")+"//TestData//Test.xlsx";
		Sheet Datasheet;
		FileInputStream file;
		String value ="";
		
		try {
			file = new FileInputStream(path);
			Datasheet = WorkbookFactory.create(file).getSheet("AmazonTestData");
			value = Datasheet.getRow(i).getCell(j).getStringCellValue();	
		} 
		
		catch (EncryptedDocumentException e) {
			e.printStackTrace();	
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}	
		return value;	
	}
}
