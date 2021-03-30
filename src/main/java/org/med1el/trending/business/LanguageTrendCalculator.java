package org.med1el.trending.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.med1el.trending.pojos.Item;
import org.med1el.trending.pojos.RestResponse;
import org.med1el.trending.pojos.RootObject;
import org.med1el.trending.service.RestConsumer;



public class LanguageTrendCalculator {
	
	public  static List<RestResponse> calculate() {
		
		RootObject obj = RestConsumer.getJsonObject();

		List<RestResponse> list = new ArrayList<RestResponse>();
		
		int index;
		
		for(Item item : obj.getItems()) {
			
			if(item.getLanguage()!=null) {
				
				index = checkIfExists( list, item.getLanguage() );
				
				if( index == -1 ) {
					
					RestResponse rr = new RestResponse();
					rr.setLanguage(item.getLanguage());
					rr.addRepo(item.getHtml_url());
					rr.incrementNumOfRepos();
					
					list.add(rr);
					
				} else {
					
					list.get(index).addRepo(item.getHtml_url());
					list.get(index).incrementNumOfRepos();
					
				}	
			}
		}
		
		Collections.sort(list, new Comparator<RestResponse>() {
			
			@Override
			public int compare(RestResponse o1, RestResponse o2) {	
				return o2.getNumOfRepos() - o1.getNumOfRepos();
		}
		});
		
		
		return list;
		
	}
	
	
	private static int checkIfExists(List<RestResponse> listRes, String language) {
		
		int index=-1;
		for (RestResponse rr : listRes) {
			index++;
			if(rr.getLanguage().equalsIgnoreCase(language)) {
				return index;
			}
		}
		
		return -1;
		
	}

}
