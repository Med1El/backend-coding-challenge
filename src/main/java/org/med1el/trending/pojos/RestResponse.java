package org.med1el.trending.pojos;

import java.util.ArrayList;
import java.util.List;

public class RestResponse {
	
	private String language;
	private int numOfRepos;
	private List<String> listOfRepos;
	
	
	public RestResponse() {
		listOfRepos = new ArrayList<String>();
	}
	
	
	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public int getNumOfRepos() {
		return numOfRepos;
	}


	public void setNumOfRepos(int numOfRepos) {
		this.numOfRepos = numOfRepos;
	}


	public List<String> getListOfRepos() {
		return listOfRepos;
	}


	public void setListOfRepos(List<String> listOfRepos) {
		this.listOfRepos = listOfRepos;
	}
	
	public void incrementNumOfRepos() {
		this.numOfRepos++;
	}
	
	public void addRepo(String repo) {
		this.listOfRepos.add(repo);
	}
	
	
	
	
	
	

}
