package MainApp;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class GetPageInfo {

	// Initial Fields
	WebDriver webDriver;

	//Website to be Checked
	String baseUrl = "http://www.aliexpress.com/";

	// check for JavaScript Run.
	boolean isJSEnable = false;


	String xl_Name = "";
	Scanner sc;

	public static WritableWorkbook writeBook;
	public static WritableSheet writeSheet;
	public static int column_Ind = 0;

	static Workbook wBookCopy;

	File ff;

	boolean four_Check = false;


	// Main Constructor
	public GetPageInfo(){

		System.out.println("------->> Enter the name of Excel File you want as Output(e.g fileName.xls): ");

		sc = new Scanner(System.in);
		xl_Name = sc.nextLine();


		ff = new File(xl_Name);

		if ( !ff.exists()){

			try {

				ff.createNewFile();

				writeBook = Workbook.createWorkbook(ff);

				writeSheet = writeBook.createSheet("Tests Responses", 0);

				//				Label lb1 = new Label(0,0,"Test ID: ");
				//			
				//				writeSheet.addCell(lb1);
				//
				//				for ( int i = 1;i<12;i++){
				//
				//					Number num = new Number(0,i,i);
				//					writeSheet.addCell(num);
				//
				//				}
				//
				//				writeBook.write();

				System.out.println("---------> File Created Successfully!!!");


			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else {

			try{

				wBookCopy = Workbook.getWorkbook(new File(xl_Name));
				writeBook = Workbook.createWorkbook(new File(xl_Name),wBookCopy);
				writeSheet = writeBook.getSheet(0);


				if( writeSheet.getColumns() % 5 == 0){

					if (writeSheet.getColumns() == 5 ){
						four_Check = true;
					}

					if ( !four_Check){
						column_Ind = writeSheet.getColumns() - 5;
					}
				}
				else{

					column_Ind++;
				}

				System.out.println(writeSheet.getName());

			}

			catch(Exception e){
				e.printStackTrace();
			}

		}


		// Trying to get driver for MozillaFirefox that is used to run thr URL,
		// and to run testcases.
		try{
			// Initializing webDriver for FireFox Browser.
			webDriver = new FirefoxDriver();

			// Loading the webPage here from the webDriver.
			webDriver.get(baseUrl);
			
		}

		// If System has no FireFox installed, Closes the connection,
		// and notifies user.
		catch (Exception e){
			System.out.println("-------->> Mozilla Firefox not installed!!!");
			webDriver.close();
		}



	}	

	// Function that returns title of loaded URL.

	public String get_Title(){

		String title = "";

		//Getting page's title loaded by webDriver.
		title = webDriver.getTitle();

		// returning the page's title.
		return title;
	}

	// Function that returns current WebDriver.
	public WebDriver get_webDriver(){

		// returns instance of Current WebDriver
		return webDriver;
	}

	public static void main (String []args){
		new GetPageInfo();
	}

}
