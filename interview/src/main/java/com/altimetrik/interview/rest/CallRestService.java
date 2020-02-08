package com.altimetrik.interview.rest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.altimetrik.interview.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
//import com.springboot.thymeprj.model.Student;
import com.google.gson.GsonBuilder;

import org.json.*;
//import  org.json.*;

@Component
@RestController
public class CallRestService implements CommandLineRunner{
	
	RestTemplate restTemplate=new RestTemplate();
	HashMap<String,String> map1=null;
	String jsnData = null;
	@GetMapping("/myrestserve/{id}")
	public ResponseEntity<String> callRestService(@PathVariable("id") String id) throws IOException
	{
		if(id.length()==17)
		{
		HttpHeaders headers=new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		String url="https://vpic.nhtsa.dot.gov/api/vehicles/DecodeVinExtended/"+id+"?format=json";
		String str=restTemplate.exchange(url, HttpMethod.GET,entity,String.class).getBody();
		JSONObject root=new JSONObject(str);
		JSONArray allData=root.getJSONArray("Results");
		System.out.println(allData);				
		map1=new HashMap<String,String>();
		for(int i=0;i<allData.length();i++)
		{
		JSONObject json1 = allData.getJSONObject(i);
		String value=json1.get("Value").toString();
		System.out.println("value "+value);
		String variable=json1.get("Variable").toString();		
		if(value!="null")
		{
			map1.put(variable,value);
		}
		}
		
		for(Map.Entry<String,String> vl:map1.entrySet())
		{
			System.out.println("Key"+vl.getKey());
			System.out.println("Value"+vl.getValue());
		}		
		}
		else
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Invalid Vehicle Identification number");
		}
		String json = new ObjectMapper().writeValueAsString(map1);
		//return json;
		
		return ResponseEntity.status(HttpStatus.OK)
		        .body(json);
		//GsonBuilder gsonMapBuilder = new GsonBuilder();
		 
		//Gson gsonObject = gsonMapBuilder.create();
 
		//JSONObject jsnData = gsonObject.toJson(map1);
		//return new ResponseEntity<JSONObject>(jsnData,HttpStatus.OK);
	}
				

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// callRestService();
	}
	
}
