package PageTests;
import MainApp.GetPageInfo;
import jxl.write.Label;
import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Dimension;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page_Tests {

	// Webdriver instance that will hold driver for the current Session.
	WebDriver webDriver;
	WebDriver next_WebD;

	// Main Class object to get webDriver and related info.
	GetPageInfo gpI = new GetPageInfo();

	// String var to hold title got by webDriver,
	// this then used to check if Title matches the loaded page's Title.
	String got_Title = "";

	int columnInd = 0;


	// TestCase to check if JS is supported by current Driver or not
	@Test
	public void chk_JS(){

		System.out.println("------->> Checking JavaScript Support: ");

		// Gets current webDriver for the session
		webDriver = gpI.get_webDriver();

		// Checks if webDriver supports JavaScript or Not.
		if (webDriver instanceof JavascriptExecutor ){

			try {


				jxl.write.Number num = new jxl.write.Number(GetPageInfo.column_Ind,1,1);
				Label lb1 = new Label(GetPageInfo.column_Ind+1,1,"Java Script Test");
				Label lb2 = new Label(GetPageInfo.column_Ind+2,1,"WhiteBox Tests");
				Label lb3 = new Label(GetPageInfo.column_Ind+3,1,"Passed");
				DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
				Date dateobj = new Date();

				String date = df.format(dateobj);

				Label lb4 = new Label(GetPageInfo.column_Ind+4,1,date);

			
				GetPageInfo.writeSheet.addCell(num);
				GetPageInfo.writeSheet.addCell(lb1);
				GetPageInfo.writeSheet.addCell(lb2);
				GetPageInfo.writeSheet.addCell(lb3);
				GetPageInfo.writeSheet.addCell(lb4);
				
				GetPageInfo.writeBook.write();
				GetPageInfo.writeBook.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 


			// If Supports JS then puts True.
			assertTrue(true);;
			System.out.println("JavaScript Supported!!!");
			// Closing the session.
			webDriver.close();


		}

		else {
			// If Doesn't Supports JS then puts False.
			assertFalse(true);
			webDriver.close();

		}

	}

	// TestCase to check if Page's title matches the Expected Title.
	@Test
	public void chk_Title(){

		System.out.println("------->> Checking Page's Title: ");

		// Expected Title to be Got by webDriver
		String expectedTitle = "AliExpress.com - Online Shopping for Electronics, Fashion, Home & Garden, Toys & Sports, Automobiles from China.";

		// Getting the URL's title loaded by webDriver
		webDriver = gpI.get_webDriver();
		got_Title = gpI.get_Title();
		System.out.println("Got Title: " + got_Title);

		// Checking if loaded page's title matches expected title.
		if ( expectedTitle.contains(got_Title)){
			// If title matches then asserts True.
			System.out.println("Title Matched!!!");




			try {

				jxl.write.Number num = new jxl.write.Number(GetPageInfo.column_Ind,2,2);
				Label lb1 = new Label(GetPageInfo.column_Ind+1,2,"Title Check Test");
				Label lb2 = new Label(GetPageInfo.column_Ind+2,2,"WhiteBox Tests");
				Label lb3 = new Label(GetPageInfo.column_Ind+3,2,"Passed");

				DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
				Date dateobj = new Date();

				String date = df.format(dateobj);

				Label lb4 = new Label(GetPageInfo.column_Ind+4,2,date);

				

				GetPageInfo.writeSheet.addCell(num);
				GetPageInfo.writeSheet.addCell(lb1);
				GetPageInfo.writeSheet.addCell(lb2);
				GetPageInfo.writeSheet.addCell(lb3);
				GetPageInfo.writeSheet.addCell(lb4);
				GetPageInfo.writeBook.write();
				GetPageInfo.writeBook.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} 

			assertTrue(true);
			webDriver.close();

		}
		else {
			// if title doesn't matches then asserts False.
			assertFalse(true);
			webDriver.close();
		}

	}




	//TestCase to check if searchField is Displayed on not.
	@Test
	public void chk_Search_Display(){

		System.out.println("------->> Checking Search Field's Visibility : ");

		// Getting webDriver to run the test.
		webDriver = gpI.get_webDriver();

		//Finding the SearchBox through it's name in  webPage.
		// It returns a WebElement.
		WebElement searchTag = webDriver.findElement(By.name("SearchText"));


		//Checking if searchField got in searchTag is Displayed or not.
		if ( searchTag.isDisplayed()){


			try {

				jxl.write.Number num = new jxl.write.Number(GetPageInfo.column_Ind,3,3);
				Label lb1 = new Label(GetPageInfo.column_Ind+1,3,"Search Field Display Test");
				Label lb2 = new Label(GetPageInfo.column_Ind+2,3,"WhiteBox Tests");
				Label lb3 = new Label(GetPageInfo.column_Ind+3,3,"Passed");

				DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
				Date dateobj = new Date();

				String date = df.format(dateobj);

				Label lb4 = new Label(GetPageInfo.column_Ind+4,3,date);

				

				GetPageInfo.writeSheet.addCell(num);
				GetPageInfo.writeSheet.addCell(lb1);
				GetPageInfo.writeSheet.addCell(lb2);
				GetPageInfo.writeSheet.addCell(lb3);
				GetPageInfo.writeSheet.addCell(lb4);
				GetPageInfo.writeBook.write();
				
				GetPageInfo.writeBook.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 


			System.out.println("Search Field is Displayed!!!");
			assertTrue(true);
			webDriver.close();
		}
		else{
			assertFalse(true);
			webDriver.close();
		}


	}


	

	//TestCase to check if searchField text is displayed or Not.
	@Test
	public void chk_Search_Content(){

		System.out.println("------->> Checking Search Field's Content: ");

		//Text to be entered in search.
		String textToSearch = "IPhone 5S";

		// Getting webDriver to run the test.
		webDriver = gpI.get_webDriver();

		//Finding the SearchBox through it's name in  webPage.
		// It returns a WebElement.
		WebElement searchTag = webDriver.findElement(By.name("SearchText"));

		//Sending the texttoSearch at the SearchBox through the method sendKeys().
		searchTag.sendKeys(textToSearch);

		//Checking if text sent matches the text Retrieved after sending,
		// True, if both texts match else false.
		if (searchTag.getAttribute("value").matches(textToSearch) ){
			
			try {

				jxl.write.Number num = new jxl.write.Number(GetPageInfo.column_Ind,4,4);
				Label lb1 = new Label(GetPageInfo.column_Ind+1,4,"Search Button Test");
				Label lb2 = new Label(GetPageInfo.column_Ind+2,4,"WhiteBox Tests");
				Label lb3 = new Label(GetPageInfo.column_Ind+3,4,"Passed");

				DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
				Date dateobj = new Date();

				String date = df.format(dateobj);

				Label lb4 = new Label(GetPageInfo.column_Ind+4,4,date);

				GetPageInfo.writeSheet.addCell(lb4);

				GetPageInfo.writeSheet.addCell(num);
				GetPageInfo.writeSheet.addCell(lb1);
				GetPageInfo.writeSheet.addCell(lb2);
				GetPageInfo.writeSheet.addCell(lb3);
				GetPageInfo.writeBook.write();
				GetPageInfo.writeBook.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

			
			
			assertTrue(true);
			System.out.println("Search Field Content Matched!!!");
			webDriver.close();
		}
		else {
			assertFalse(true);
		}

	}

	//TestCase to check if the Search button is Displayed or not.
	@Test
	public void chk_Search_Btn(){

		System.out.println("------->> Checking Search Button Visibility: ");

		// Getting webDriver to run the test.
		webDriver = gpI.get_webDriver();

		//Finding the SearchButton through it's Class-Name in  webPage.
		// It returns a WebElement.
		WebElement searchBtn = webDriver.findElement(By.className("search-button"));

		System.out.println(searchBtn.getCssValue("background-color"));

		//Checking if searchField got in searchButton is Displayed or not.
		if ( searchBtn.isDisplayed()){

			try {

				jxl.write.Number num = new jxl.write.Number(GetPageInfo.column_Ind,5,5);
				Label lb1 = new Label(GetPageInfo.column_Ind+1,5,"Search Button Test");
				Label lb2 = new Label(GetPageInfo.column_Ind+2,5,"WhiteBox Tests");
				Label lb3 = new Label(GetPageInfo.column_Ind+3,5,"Passed");

				DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
				Date dateobj = new Date();

				String date = df.format(dateobj);

				Label lb4 = new Label(GetPageInfo.column_Ind+4,5,date);

				GetPageInfo.writeSheet.addCell(lb4);

				GetPageInfo.writeSheet.addCell(num);
				GetPageInfo.writeSheet.addCell(lb1);
				GetPageInfo.writeSheet.addCell(lb2);
				GetPageInfo.writeSheet.addCell(lb3);
				GetPageInfo.writeBook.write();
				GetPageInfo.writeBook.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 


			System.out.println("----------> Search Button is Displayed!!!");
			assertTrue(true);
			webDriver.close();
		}
		else{
			assertFalse(true);
		}


	}

	
	//TestCase to check SearchButton's Color
	@Test
	public void chk_Srch_Btn_Color()
	{
		System.out.println("--------> Checking Search Button's Color:");

		//Expected Color for the Search Button to be displayed.
		String expected_Color = "rgba(230, 46, 4, 1)";

		// Getting webDriver to run the test.
		webDriver = gpI.get_webDriver();

		//Finding the SearchButton through it's Class-Name in  webPage.
		// It returns a WebElement.
		WebElement searchBtn = webDriver.findElement(By.className("search-button"));

		// Getting the CSS attribute Background Color of the search button.
		String got_Color = searchBtn.getCssValue("background-color");

		//Checking if searchField got in searchButton is Displayed or not.
		if ( expected_Color.contains(got_Color)){


			try {

				jxl.write.Number num = new jxl.write.Number(GetPageInfo.column_Ind,6,6);
				Label lb1 = new Label(GetPageInfo.column_Ind+1,6,"Search Button Color Test");
				Label lb2 = new Label(GetPageInfo.column_Ind+2,6,"WhiteBox Tests");
				Label lb3 = new Label(GetPageInfo.column_Ind+3,6,"Passed");

					DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
				Date dateobj = new Date();
				
				String date = df.format(dateobj);

				Label lb4 = new Label(GetPageInfo.column_Ind+4,6,date);

				GetPageInfo.writeSheet.addCell(lb4);

				GetPageInfo.writeSheet.addCell(num);
				GetPageInfo.writeSheet.addCell(lb1);
				GetPageInfo.writeSheet.addCell(lb2);
				GetPageInfo.writeSheet.addCell(lb3);
				GetPageInfo.writeBook.write();
				GetPageInfo.writeBook.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 


			assertTrue(true);
			System.out.println("Color Matched!!!");
			webDriver.close();
		}
		else{
			assertFalse(true);
		}

	}


	//TestCase for testing searchButton Functionality
	@Test
	public void srch_Btn_Func(){

		System.out.println("--------> Checking Search Button's Functionality:");

		// Getting webDriver to run the test.
		webDriver = gpI.get_webDriver();

		//Text to be entered in search.
		String textToSearch = "IPhone 5S";

		//Finding the SearchBox through it's name in  webPage.
		// It returns a WebElement.
		WebElement searchTag = webDriver.findElement(By.name("SearchText"));

		//Sending the texttoSearch at the SearchBox through the method sendKeys().
		searchTag.sendKeys(textToSearch);


		//Finding the SearchButton through it's Class-Name in  webPage.
		// It returns a WebElement.
		WebElement searchBtn = webDriver.findElement(By.className("search-button"));

		// Storing previous page's URL window handler to return incase.
		String prev_Url = webDriver.getCurrentUrl();

		boolean true_Check = false;

		// Clicking the search button, that now searches for text entered in search field.
		searchBtn.click();


		// A set is returned by getWindowHandles(), it keeps record of all the window navigations,
		// webDriver can switch between those windows using switchTo method
		for ( String new_Handles : webDriver.getWindowHandles()){

			//Switching to new Window after the searchButton has been pressed.
			webDriver.switchTo().window(new_Handles);

			// Checking if the searchButton searched for the text written in searchField.
			// If the title matches the searchField text then its working fine else, Not.
			if ( webDriver.getTitle().contains("Shop "+textToSearch)){


				try {

					jxl.write.Number num = new jxl.write.Number(GetPageInfo.column_Ind,7,7);
					Label lb1 = new Label(GetPageInfo.column_Ind+1,7,"Search Button Function Test");
					Label lb2 = new Label(GetPageInfo.column_Ind+2,7,"WhiteBox Tests");
					Label lb3 = new Label(GetPageInfo.column_Ind+3,7,"Passed");

						DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
				Date dateobj = new Date();
				
				String date = df.format(dateobj);

				Label lb4 = new Label(GetPageInfo.column_Ind+4,7,date);

				GetPageInfo.writeSheet.addCell(lb4);
				
					GetPageInfo.writeSheet.addCell(num);
					GetPageInfo.writeSheet.addCell(lb1);
					GetPageInfo.writeSheet.addCell(lb2);
					GetPageInfo.writeSheet.addCell(lb3);
					GetPageInfo.writeBook.write();
					GetPageInfo.writeBook.close();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 


				System.out.println("--------> Search Button working Fine!!!");
				true_Check = true;
				break;
			}
			else {
				assertFalse(true);
				webDriver.close();
			}

		}

		// Check that manages if searchButton works Fine.
		if (true_Check){

			System.out.println("----------> Returning to Main Page...");
			assertTrue(true);
			// Loading the MainPage after successful run of searchButton.
			webDriver.get(prev_Url);

		}

	}


	// TestCase to check if webDriver returned to MainPage Successfully or Not.
	@Test
	public void chk_Driver_MainPage(){

		System.out.println("----------> Checking if Returned Successfully...");

		//Checking if the Loaded Page's URL matches the default Page's Title.
		if ( webDriver.getTitle().matches(gpI.get_Title())){

			try {

				jxl.write.Number num = new jxl.write.Number(GetPageInfo.column_Ind,8,8);
				Label lb1 = new Label(GetPageInfo.column_Ind+1,8,"Return Functionality Test");
				Label lb2 = new Label(GetPageInfo.column_Ind+2,8,"WhiteBox Tests");
				Label lb3 = new Label(GetPageInfo.column_Ind+3,8,"Passed");

					DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
				Date dateobj = new Date();
				
				String date = df.format(dateobj);

				Label lb4 = new Label(GetPageInfo.column_Ind+4,8,date);

				GetPageInfo.writeSheet.addCell(lb4);

				GetPageInfo.writeSheet.addCell(num);
				GetPageInfo.writeSheet.addCell(lb1);
				GetPageInfo.writeSheet.addCell(lb2);
				GetPageInfo.writeSheet.addCell(lb3);
				GetPageInfo.writeBook.write();
				GetPageInfo.writeBook.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 



			System.out.println("-------------> Returned Successfully!!!");
			assertTrue(true);
			webDriver.close();
		}
		else {
			assertFalse(true);
		}

	}


	//TestCase to check the functionality of SignIn Button.
	@Test
	public void chk_Btn_SignIn(){

		System.out.println("----------> Checking SignIn Link Functionality...");

		// Getting webDriver to run the test.
		webDriver = gpI.get_webDriver();


		//Finding the SignUpButton through it's Class-Name in webPage.
		// It returns a WebElement.
		WebElement signInLink = webDriver.findElement(By.linkText("Sign in"));

		// Getting the URL to Signup Page.
		String signInUrl = signInLink.getAttribute("href");
		//		System.out.println("---> : " + signUpBtn.getAttribute("href"));

		System.out.println("------------> Shifting to SignIn Page...");

		// switiching to SignIn Page through the URL obtained from HREF tag.

		signInLink.click();

		for ( String new_Handles : webDriver.getWindowHandles()){

			//Switching to new Window after the searchButton has been pressed.
			webDriver.switchTo().window(new_Handles);

		}



		System.out.println("------------> Checking if SignIn Button Exists...");


		try{
			Thread.sleep(15000);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		webDriver.switchTo().frame("alibaba-login-box");

		WebElement element = webDriver.findElement(By.id("fm-login-submit"));
		
		WebElement elem_LoginId = webDriver.findElement(By.id("fm-login-id"));
				
		elem_LoginId.sendKeys("ahadmahmood1234@gmail.com");		
		
		WebElement elem_Pass = webDriver.findElement(By.id("fm-login-password"));
		elem_Pass.sendKeys("ahadmahmood");

		
		if ( element.isEnabled()){

			try {

				jxl.write.Number num = new jxl.write.Number(GetPageInfo.column_Ind,9,9);
				Label lb1 = new Label(GetPageInfo.column_Ind+1,9,"SignIn Button Test");
				Label lb2 = new Label(GetPageInfo.column_Ind+2,9,"WhiteBox Tests");
				Label lb3 = new Label(GetPageInfo.column_Ind+3,9,"Passed");

					DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
				Date dateobj = new Date();
				
				String date = df.format(dateobj);

				Label lb4 = new Label(GetPageInfo.column_Ind+4,9,date);

				GetPageInfo.writeSheet.addCell(lb4);

				GetPageInfo.writeSheet.addCell(num);
				GetPageInfo.writeSheet.addCell(lb1);
				GetPageInfo.writeSheet.addCell(lb2);
				GetPageInfo.writeSheet.addCell(lb3);
				GetPageInfo.writeBook.write();
				GetPageInfo.writeBook.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 


			System.out.println("-----------> SignIn Button Available!!!");
			assertTrue(true);
			webDriver.close();
		}
		else {
			assertFalse(true);
		}


	}



	//TestCase to check the functionality of JoinIn Button.
	@Test
	public void chk_Btn_JoinIn(){

		System.out.println("----------> Checking JoinIn Link Functionality...");

		// Getting webDriver to run the test.
		webDriver = gpI.get_webDriver();


		//Finding the JoinInButton through it's Class-Name in webPage.
		// It returns a WebElement.
		WebElement joinInLink = webDriver.findElement(By.linkText("Join"));

		// Getting the URL to JoinInPage.
		String joinInUrl = joinInLink.getAttribute("href");

		System.out.println("------------> Shifting to JoinIn Page...");

		// switiching to JoinIn Page through the URL obtained from HREF tag.

		joinInLink.click();

		for ( String new_Handles : webDriver.getWindowHandles()){

			//Switching to new Window after the searchButton has been pressed.
			webDriver.switchTo().window(new_Handles);

		}

		System.out.println("------------> Checking if JoinIn Button Exists...");

		WebElement element = webDriver.findElement(By.id("submit-btn"));


		if ( element.isEnabled()){


			try {

				jxl.write.Number num = new jxl.write.Number(GetPageInfo.column_Ind,10,10);
				Label lb1 = new Label(GetPageInfo.column_Ind+1,10,"JoinIn Button Test");
				Label lb2 = new Label(GetPageInfo.column_Ind+2,10,"WhiteBox Tests");
				Label lb3 = new Label(GetPageInfo.column_Ind+3,10,"Passed");

					DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
				Date dateobj = new Date();
				
				String date = df.format(dateobj);

				Label lb4 = new Label(GetPageInfo.column_Ind+4,10,date);

				GetPageInfo.writeSheet.addCell(lb4);

				GetPageInfo.writeSheet.addCell(num);
				GetPageInfo.writeSheet.addCell(lb1);
				GetPageInfo.writeSheet.addCell(lb2);
				GetPageInfo.writeSheet.addCell(lb3);
				GetPageInfo.writeBook.write();
				GetPageInfo.writeBook.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 


			System.out.println("-----------> JoinIn Button Available!!!");
			assertTrue(true);
			webDriver.close();
		}
		else {
			assertFalse(true);
		}

	}



	//TestCase to check the Dimensions of WebPage
	@Test
	public void chk_Window_Size(){

		System.out.println("-----------> Changing browser's window size...");

		// Getting webDriver to run the test.
		//		webDriver = gpI.get_webDriver();

		//Initializing new Dimension to be set.
		Dimension dim = new Dimension(750, 550);

		//Changing browser's dimension with new dimension
		webDriver.manage().window().setSize(dim);;

		//Comparing browser's dimension with changed dimesion,
		if(webDriver.manage().window().getSize() == dim ){

			try {

				jxl.write.Number num = new jxl.write.Number(GetPageInfo.column_Ind,11,11);
				Label lb1 = new Label(GetPageInfo.column_Ind+1,11,"JoinIn Button Test");
				Label lb2 = new Label(GetPageInfo.column_Ind+2,11,"WhiteBox Tests");
				Label lb3 = new Label(GetPageInfo.column_Ind+3,11,"Passed");

					DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
				Date dateobj = new Date();
				
				String date = df.format(dateobj);

				Label lb4 = new Label(GetPageInfo.column_Ind+4,11,date);

				GetPageInfo.writeSheet.addCell(lb4);

				GetPageInfo.writeSheet.addCell(num);
				GetPageInfo.writeSheet.addCell(lb1);
				GetPageInfo.writeSheet.addCell(lb2);
				GetPageInfo.writeSheet.addCell(lb3);
				GetPageInfo.writeBook.write();
				GetPageInfo.writeBook.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 


			System.out.println("-----------> Browser's size changed Successfully!!!");
			assertTrue(true);
			webDriver.close();

		}

		else {
			assertFalse(true);
			webDriver.close();
		}


	}


}
