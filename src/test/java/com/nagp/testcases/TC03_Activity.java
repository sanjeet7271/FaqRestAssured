package com.nagp.testcases;

import java.util.List;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.nagp.config.ConfigReader;
import com.nagp.constants.HttpMethods;
import com.nagp.constants.HttpStatusCodes;
import com.nagp.excelsheetreader.ExcelSheetReader;
import com.nagp.resources.ResourceURLs;
import com.nagp.restassuredmethods.RestAssuredMethodsCall;
import io.restassured.response.Response;

/**
 * 
 * @author sanjeetpandit
 * @Test cases for users
 *
 */
public class TC03_Activity extends ConfigReader{
	List<Integer> activityID;
	ResourceURLs resources = new ResourceURLs();
	private static Logger logger = Logger.getLogger(TC03_Activity.class);
	Response response;
	RestAssuredMethodsCall rest = new RestAssuredMethodsCall();
	String xlFilePath = "./src/main/resources/testdata/TestData.xlsx";
	String sheetName = "Users";
	ExcelSheetReader provideData = new ExcelSheetReader();
	Object[][] data = null;
	int createdID;
	/**
	 *  Get all activities
	 */
	@Test(priority = 1, description = "gettting all activity")
	public void getAllActivities() {
		try {
			response = rest.restAssuredCalls(HttpMethods.GET, "", resources.getResourceforActivity(), "","", "");
			int statusCode = response.getStatusCode();
			Assert.assertEquals(HttpStatusCodes.RESPONSE_STATUS_CODE_200, statusCode, "response is not 200");
			activityID=response.jsonPath().get("activities.activity_id");
			System.out.println(activityID);

		} catch (Exception e) {
			logger.error("Exception " + e);
			logger.error("Response not found.");
			Assert.fail("Status code is not correct.");
		}
	}
	@Test(priority = 2, description = "Follow the Activity")
	public void followActivity() {
		try {
			response = rest.restAssuredCalls(HttpMethods.PUT_WITH_QUERYPARAM, "", resources.getFollowActivity(), "","","");
			int statusCode = response.getStatusCode();
			System.out.println(statusCode);
			System.out.println(response.asString());
			Assert.assertEquals(HttpStatusCodes.RESPONSE_STATUS_CODE_200, statusCode, "response is not 200");

		} catch (Exception e) {
			logger.error("Exception " + e);
			logger.error("Response not found.");
			Assert.fail("Status code is not correct.");
		}
	}
@Test(priority = 3, description = "UnFollow the activity")
	public void unfollowActivity() {
		try {
			System.out.println(resources.getUnfollowActivity());
			response = rest.restAssuredCalls(HttpMethods.PUT_WITH_QUERYPARAM, "", resources.getUnfollowActivity(), "","", "");
			System.out.println(response.asString());
			int statusCode = response.getStatusCode();
			System.out.println(statusCode);
			Assert.assertEquals(HttpStatusCodes.RESPONSE_STATUS_CODE_200, statusCode, "response is not 200");
			//commonUtility.findUserID(response);

		} catch (Exception e) {
			logger.error("Exception " + e);
			logger.error("Response not found.");
			Assert.fail("Status code is not correct.");
		}
	}
	
	@Test(priority = 4, description = "delete the activity")
	public void deleteActivity() {
		try {
			String hostURL=resources.deleteActivity();
			System.out.println(hostURL);
			response = rest.restAssuredCalls(HttpMethods.DELETE, "", hostURL, String.valueOf(activityID.get(1)),"","");
			int statusCode = response.getStatusCode();
			System.out.println(statusCode);
			Assert.assertEquals(HttpStatusCodes.RESPONSE_STATUS_CODE_200, statusCode, "response is not 200");

		} catch (Exception e) {
			logger.error("Exception " + e);
			logger.error("Response not found.");
			Assert.fail("Status code is not correct.");
		}
	}
}
