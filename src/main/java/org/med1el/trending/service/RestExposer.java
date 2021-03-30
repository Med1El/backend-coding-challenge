package org.med1el.trending.service;

import java.util.List;

import org.med1el.trending.business.LanguageTrendCalculator;
import org.med1el.trending.pojos.RestResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestExposer {
	
	@GetMapping("/trending")
	public List<RestResponse> trendInGithub() {
		return LanguageTrendCalculator.calculate(); 
	}
	
}
