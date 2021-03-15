package com.nagp.testcases;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.nagp.constants.HttpMethods;
import com.nagp.constants.HttpStatusCodes;
import com.nagp.constants.RequestType;
import com.nagp.excelsheetreader.ExcelSheetReader;
import com.nagp.quotes.QuotesPojo;
import com.nagp.resources.ResourceURLs;
import com.nagp.restassuredmethods.RestAssuredMethodsCall;
import io.restassured.response.Response;

/**
 * 
 * @author sanjeetpandit
 *
 */

public class TC02_Quotes {
	String xlFilePath = "./src/main/resources/testdata/TestData.xlsx";
	String sheetName = "Quote";
	ExcelSheetReader provideData = new ExcelSheetReader();
	Object[][] data = null;
	ResourceURLs resources = new ResourceURLs();
	public static Logger logger = Logger.getLogger(TC02_Quotes.class);
	Response response;
	RestAssuredMethodsCall rest = new RestAssuredMethodsCall();
	QuotesPojo postData = new QuotesPojo();
	int Quote_Id;
	public static String userToken;
	
	@DataProvider(name = "post")
	public Object[][] testData() throws IOException {
		data = provideData.testData(xlFilePath, sheetName);
		return data;
	}

	/**
	 * @get all post ID
	 * 
	 */

	@Test(priority = 1, dataProvider = "post", description = "Add new Quote to your list")
	public void verifyToAddAQuote(String Auther, String body) {
		
		try {
			String dummyTestData = postData.quoteJsonData(Auther,body);
			response = rest.restAssuredCalls(HttpMethods.POST_USERTOKEN, dummyTestData, resources.getResourceforAddQuote(), "","", "");
			int statusCode = response.getStatusCode();
			Quote_Id = response.jsonPath().get("id");
			System.out.println(Quote_Id);
			System.out.println(statusCode);
			System.out.println(response.asString());
			Assert.assertEquals(HttpStatusCodes.RESPONSE_STATUS_CODE_200, statusCode);

		} catch (Exception e) {
			logger.error("Exception " + e);
			logger.error("Properties file not found.");
			Assert.fail("Properties file not found.");
		}
	}

	@Test(priority = 2, description = "Hide the added Quote")
	public void verifyToHideTheQuotes() {
		try {
			response = rest.restAssuredCalls(HttpMethods.PUT_WITH_PATHPARAM, "",resources.getResourceforHideQuote(),String.valueOf(Quote_Id),RequestType.HIDE, "");
			int statusCode = response.getStatusCode();
			Assert.assertEquals(HttpStatusCodes.RESPONSE_STATUS_CODE_200, statusCode);
			System.out.println(statusCode);
			System.out.println(response.asString());
			logger.info("Validating duplicate Post ID");
		} catch (Exception e) {
			logger.error("Exception " + e);
			logger.error("Properties file not found.");
			Assert.fail("Properties file not found.");
		}
	}
	@Test(priority = 3, description = "UnHide the quotes")
	public void verifyUnHideTheQuotes() {
		try {
			response = rest.restAssuredCalls(HttpMethods.PUT_WITH_PATHPARAM, "",resources.getResourceforHideQuote(),String.valueOf(Quote_Id),RequestType.UNHIDE, "");
			int statusCode = response.getStatusCode();
			Assert.assertEquals(HttpStatusCodes.RESPONSE_STATUS_CODE_200, statusCode);
			System.out.println(statusCode);
			System.out.println(response.asString());
			logger.info("Validating duplicate Post ID");
		} catch (Exception e) {
			logger.error("Exception " + e);
			logger.error("Properties file not found.");
			Assert.fail("Properties file not found.");
		}
	}
	
	@Test(priority = 4, description = "Add quote into your favourite list")
	public void verifyToMakeFavouriteQuotes() {
		try {
			response = rest.restAssuredCalls(HttpMethods.PUT_WITH_PATHPARAM, "",resources.getResourceforHideQuote(),String.valueOf(Quote_Id),RequestType.FAV, "");
			int statusCode = response.getStatusCode();
			Assert.assertEquals(HttpStatusCodes.RESPONSE_STATUS_CODE_200, statusCode);
			System.out.println(statusCode);
			System.out.println(response.asString());
			logger.info("Validating duplicate Post ID");
		} catch (Exception e) {
			logger.error("Exception " + e);
			logger.error("Properties file not found.");
			Assert.fail("Properties file not found.");
		}
	}
}
