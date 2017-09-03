package com.cts.rest;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class SpringRestClient {

	private static String REST_URI = "http://localhost:8086/shop_client/countries";
	@Autowired
	private static ReadProperties readProp;
	/*
	 * Add HTTP Authorization header, using Basic-Authentication to send
	 * user-credentials.
	 */
	private static HttpHeaders getHeaders() {
		String plainCredentials = "1GTR1TEX8DZ102725:1M8PDMMA8SP032025";
		String base64Credentials = new String(
				Base64.encodeBase64(plainCredentials.getBytes()));

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Credentials);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return headers;
	}

	public static void getAllCountries() {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> request = new HttpEntity<String>(getHeaders());
		ResponseEntity<List> response = restTemplate.exchange(REST_URI,
				HttpMethod.GET, request, List.class);
		List<LinkedHashMap<String, Object>> usersMap = (List<LinkedHashMap<String, Object>>) response
				.getBody();
		if (usersMap != null) {
			for (LinkedHashMap<String, Object> map : usersMap) {
				System.out.println("User : id=" + map.get("id") + ", Name="
						+ map.get("countryName"));
			}
		} else {
			System.out.println("No user exist----------");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getAllCountries();
	}

}
