package com.nagp.users;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class UserPojo {
	//public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		public String userJsonData(String login, String email, String password, String twitter_username, String facebook_username, String pic) throws JsonGenerationException, JsonMappingException, IOException {		
			UserBody user = new UserBody(login, email,password,twitter_username,facebook_username,pic);
				User jUser=new User(user);
				ObjectMapper objMap = new ObjectMapper();
				String mydata = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(jUser);
				
				System.out.println(mydata);
				return mydata;
			}
}
