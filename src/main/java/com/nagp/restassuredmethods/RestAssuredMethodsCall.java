package com.nagp.restassuredmethods;

import com.nagp.constants.AccessTokens;
import com.nagp.constants.HttpMethods;
import com.nagp.resources.ResourceURLs;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * 
 * @author sanjeetpandit @ Different RestAssured methods
 *
 */
public class RestAssuredMethodsCall {
	ResourceURLs resource = new ResourceURLs();
	Response response = null;

	/**
	 * 
	 * @param requestType
	 * @param entityString
	 * @param request
	 * @param id
	 * @param integer
	 * @return
	 * 
	 */
	public Response restAssuredCalls(String requestType, String entityString, String request,
			String quote_id, String path, String userToken) {

		switch (requestType) {
		case HttpMethods.GET:
			RestAssured.baseURI = resource.getBaseURI();
			response = RestAssured.given().relaxedHTTPSValidation().headers("Authorization",AccessTokens.AUTHORISATION).header("User-Token",AccessTokens.USER_TOKEN).log().all().when().get(request).then().extract().response();
			break;
		case HttpMethods.GET_WITH_PATHPARAM:
			RestAssured.baseURI = resource.getBaseURI();
			response = RestAssured.given().relaxedHTTPSValidation().headers("Authorization",AccessTokens.AUTHORISATION).header("User-Token",AccessTokens.USER_TOKEN).pathParam("login", "gose").log().all().when().get(request+"{login}").then().extract().response();
			break;
		case HttpMethods.POST:
			RestAssured.baseURI = resource.getBaseURI();
			response = RestAssured.given().relaxedHTTPSValidation().body(entityString).headers("Authorization",AccessTokens.AUTHORISATION).log().all().contentType(ContentType.JSON).when()
					.post(request).then().extract().response();
		case HttpMethods.POST_USERTOKEN:
			RestAssured.baseURI = resource.getBaseURI();
			response = RestAssured.given().relaxedHTTPSValidation().body(entityString).headers("Authorization",AccessTokens.AUTHORISATION).header("User-Token",AccessTokens.USER_TOKEN).log().all().contentType(ContentType.JSON).when()
					.post(request).then().extract().response();
			break;
		case HttpMethods.PUT:
			RestAssured.baseURI = resource.getBaseURI();
			response = RestAssured.given().urlEncodingEnabled(false).headers("Authorization",AccessTokens.AUTHORISATION).header("User-Token",userToken).log().all().when().put(request).then().extract().response();
			break;
		case HttpMethods.PUT_WITH_QUERYPARAM:
			RestAssured.baseURI = resource.getBaseURI();
			response = RestAssured.given().relaxedHTTPSValidation().urlEncodingEnabled(false).headers("Authorization",AccessTokens.AUTHORISATION).header("User-Token",AccessTokens.USER_TOKEN).queryParam("type","user").queryParam("filter", "gose").log().all().when().put(request).then().extract().response();
			break;
		case HttpMethods.PUT_WITH_LOGINPATH:
			RestAssured.baseURI = resource.getBaseURI();
			response = RestAssured.given().relaxedHTTPSValidation().urlEncodingEnabled(false).headers("Authorization",AccessTokens.AUTHORISATION).header("User-Token",userToken).pathParam("login", "gose").log().all().when().put(request+"{login}").then().extract().response();
			break;
		case HttpMethods.PUT_WITH_PATHPARAM:
			RestAssured.baseURI = resource.getBaseURI();
			int QueryParam=Integer.parseInt(quote_id);
			response = RestAssured.given().relaxedHTTPSValidation().urlEncodingEnabled(false).headers("Authorization",AccessTokens.AUTHORISATION).header("User-Token",AccessTokens.USER_TOKEN).pathParam("quote_id", QueryParam).log().all().when().put(request+"{quote_id}"+path).then().extract().response();
			break;
		case HttpMethods.PATCH:
			// TO DO
			break;
		case HttpMethods.DELETE:
			RestAssured.baseURI = resource.getBaseURI();
			int QuoteID=Integer.parseInt(quote_id);
			response = (Response) RestAssured.given().relaxedHTTPSValidation().urlEncodingEnabled(false).headers("Authorization",AccessTokens.AUTHORISATION).header("User-Token",AccessTokens.USER_TOKEN).pathParam("quote_id", QuoteID).log().all().when().delete(request+"{quote_id}").then().extract().response();
			break;
		case HttpMethods.DEFAULT:
			// TO DO
			break;

		}

		return response;
	}
}
