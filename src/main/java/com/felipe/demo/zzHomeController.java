package com.felipe.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

import jakarta.validation.Valid;

@Controller
@CacheConfig(cacheNames = {"example"})
public class zzHomeController {

	List<Country> globalList = getListCountries();
	boolean update = true;

	@Cacheable
	public List<Country> getListCountries() {
		String uri = "https://api.apilayer.com/exchangerates_data/symbols";
		// header to use api key
		HttpHeaders headers = new HttpHeaders();
		headers.add("apikey", "CBHQdfr9eyHXDSDMuip3IRVVazo6sHHb");

		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode= null;
		try {
			jsonNode = objectMapper.readTree(response.getBody());
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		List<Country> list = new ArrayList<Country>();
		Iterator<String> iterator = jsonNode.get("symbols").fieldNames();
		iterator.forEachRemaining(e -> list.add(new Country(e)));
		return list;
	}
	
	
	/*
	 * @Scheduled(fixedRate = 604800) public void updateCountries() { update = true;
	 * }
	 */
	 

	// creates page home
	@GetMapping("/home")
	// adds return of the method to the html page as parameter
	@ModelAttribute("countries")
	public List<Country> home(Model model,
			@Valid @ModelAttribute("selectedOption") Values selected, BindingResult bind ) {
		
		  //if(update) { 
			  globalList = getListCountries(); 
			  update = false; 
			  //}
		
		model.addAttribute("list", globalList);

		return globalList;
	}

}
