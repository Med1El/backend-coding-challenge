package org.med1el.trending.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.med1el.trending.pojos.RootObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestConsumer {
	
		
		public static RootObject getJsonObject() {
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
			LocalDateTime now = LocalDateTime.now();  
			String yesterday = dtf.format(now.minusDays(1));  
			
			Client client = ClientBuilder.newClient();
			WebTarget target = client.target("https://api.github.com/search/repositories?q=created:%3E"+yesterday+"&sort=stars&order=desc&per_page=100");
			RootObject response = target.request(MediaType.APPLICATION_JSON).get(RootObject.class);
			
			return response;
		}	    
		
}
