package com.nagp.createuserpojo;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class CreateUserPojo {
		public String createUserJsonData(String login, String email, String password) throws JsonGenerationException, JsonMappingException, IOException {				
				CreateUserBody user = new CreateUserBody(login, email,password);
				CreateUser jUser=new CreateUser(user);
				ObjectMapper objMap = new ObjectMapper();
				String mydata = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(jUser);
				System.out.println(mydata);
				return mydata;
			}
}
