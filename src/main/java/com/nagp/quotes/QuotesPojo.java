package com.nagp.quotes;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class QuotesPojo {
	//public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
	public String quoteJsonData(String auther, String body) throws JsonGenerationException, JsonMappingException, IOException {		
			QuoteBody quote = new QuoteBody(auther, body);
			Quote jQuote=new Quote(quote);
			ObjectMapper objMap = new ObjectMapper();
			String mydata = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(jQuote);
			return mydata;
		}
	}

