package com.springboot.thymeprj.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.thymeprj.model.Vehicle;

@Controller
@RequestMapping("/vehicle")
public class StudentController {	
	RestTemplate restTemplate=new RestTemplate();


@PostMapping("/save2")
public String saveForm2(@ModelAttribute("vehicle") Vehicle vehicle,Model model) throws IOException
{
	String uri = "http://localhost:8080/myrestservce/"+vehicle.getVehicleId();
	System.out.println(vehicle.getVehicleId());
	RestTemplate restTemplate = new RestTemplate();	
	ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	
    System.out.println(result.getBody());
    String str=result.getBody();
    str=str.replaceAll("\"", "");
    str=str.replaceAll("[{}]", "");
    String[] array1=str.split(",");    
    System.out.println(str);
    model.addAttribute("vehicles", array1);
    //model.addAttribute()
    return "showVehicleInfo";
}



@GetMapping("/getVehicle")
public String getForm(Model model)
{
	model.addAttribute("vehicle",new Vehicle());	
	//studentService.save(theStudent);
	return "showVehicleEntry";
}

}