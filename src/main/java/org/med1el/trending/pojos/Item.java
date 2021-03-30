package org.med1el.trending.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
	
	private String html_url;
	private String language;
	
	public Item() {}
	
	
	
	public String getHtml_url() {
		return html_url;
	}
	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}



	@Override
	public String toString() {
		return "DataModel [html_url=" + html_url + ", language=" + language + "]";
	}
	
	
	
	

}
