package com.kh.dep.personManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {
	
	
	@RequestMapping("depMgt.pm")
	public String depMgt(){
		
		
		return "personManagement/departmentManagement";
	}
	
	
	
	@RequestMapping("promotion.pm")
	public String promotion(){
		
		
		return "personManagement/promotion";
	}
	
	
	
	

}
