package com.nagp.testcases;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.nagp.constants.HttpMethods;
import com.nagp.constants.HttpStatusCodes;
import com.nagp.createuserpojo.CreateUserPojo;
import com.nagp.excelsheetreader.ExcelSheetReader;
import com.nagp.resources.ResourceURLs;
import com.nagp.restassuredmethods.RestAssuredMethodsCall;
import com.nagp.users.UserPojo;

import io.restassured.response.Response;

/**
 * 
 * @author sanjeetpandit
 *
 */
public class TC01_Users {
	String xlFilePath = "./src/main/resources/testdata/TestData.xlsx";
	String sheetName1 = "User";
	String sheetName2 = "CreateUser";
	ExcelSheetReader provideData = new ExcelSheetReader();
	Object[][] data = null;
	ResourceURLs resources = new ResourceURLs();
	private static Logger logger = Logger.getLogger(TC01_Users.class);
	RestAssuredMethodsCall rest = new RestAssuredMethodsCall();
	CreateUserPojo createUserTestData= new CreateUserPojo();
	UserPojo userTestData= new UserPojo();
	public static String user_Token;
	
	@DataProvider(name = "CreateUser")
	public Object[][] testDataUser() throws IOException {
		data = provideData.testData(xlFilePath, sheetName2);
		return data;
	}

	/**
	 * @get all post ID
	 * 
	 */

	@Test(priority = 1, dataProvider = "CreateUser", description = "Creating new User")
	public void createNewUser(String login, String email,String password) {
		try {
			String testData = createUserTestData.createUserJsonData(login,email,password);
			logger.info("Creating new user");
			Response userResponse = rest.restAssuredCalls(HttpMethods.POST, testData, resources.getResourceforGetUser(), ""," ","");
			int statusCode = userResponse.getStatusCode();
			user_Token=userResponse.jsonPath().get("User-Token");
			Assert.assertEquals(HttpStatusCodes.RESPONSE_STATUS_CODE_200, statusCode);
		} catch (Exception e) {
			logger.error("Exception " + e);
			logger.error("Properties file not found.");
			Assert.fail("Properties file not found.");
		}
	}
	
	
	
	@DataProvider(name = "user")
	public Object[][] testData() throws IOException {
		data = provideData.testData(xlFilePath, sheetName1);
		return data;
	}

	/**
	 * @get all post ID
	 * 
	 */

	@Test(priority = 2, dataProvider = "user", description = "Updating user details")
	public void updateTheUser(String login, String email,String password,String twitter_username, String facebook_username,String pic) {
		try {
			String testData = userTestData.userJsonData(login,email,password,twitter_username,facebook_username, pic);
			System.out.println(testData);
			logger.info("updating user details");
			Response userResponse = rest.restAssuredCalls(HttpMethods.PUT_WITH_LOGINPATH, testData, resources.getResourceforGetUser(), ""," ", user_Token);
			int statusCode = userResponse.getStatusCode();
			System.out.println(statusCode);
			System.out.println(userResponse.asString());
			Assert.assertEquals(HttpStatusCodes.RESPONSE_STATUS_CODE_200, statusCode);
		} catch (Exception e) {
			logger.error("Exception " + e);
			logger.error("Properties file not found.");
			Assert.fail("Properties file not found.");
		}
	}
	
	
	/**
	 * 
	 * @validate all email's commented by users to particular user ID
	 * 
	 */

	@Test(priority = 3,description = "get user details")
	public void verifyToGetUser() {
		try {
			logger.info("getting user details");
			Response userResponse = rest.restAssuredCalls(HttpMethods.GET_WITH_PATHPARAM, "", resources.getResourceforGetUser(), ""," ", user_Token);
			int statusCode = userResponse.getStatusCode();
			System.out.println(statusCode);
			System.out.println(userResponse.asString());
			Assert.assertEquals(HttpStatusCodes.RESPONSE_STATUS_CODE_200, statusCode);
		} catch (Exception e) {
			logger.error("Exception " + e);
			logger.error("Properties file not found.");
			Assert.fail("Properties file not found.");
		}
	}

}
