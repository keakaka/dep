package com.kh.dep.sign.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.dep.sign.model.service.SignService;
import com.kh.dep.sign.model.vo.MemberDep;

@Controller
public class SignController {
	
	@Autowired
	private SignService ss;
	
	
	@RequestMapping(value="signWright.sg")
	public String signWright(){
		
		
		
		
		return "sign/signWright";
	}
	
	@RequestMapping(value="insertSign.sg")
	public String insertSign(String signContent, String testPerson){
		
		String signContent2 = signContent;
		String testPerson2 = testPerson;
		
		System.out.println("signcontent=" + signContent2);
		System.out.println("testPerson = " + testPerson);
		
		return "sign/signWright";
	}
	
	
	@RequestMapping(value="depEmpSelect.sg")
	public @ResponseBody HashMap<String, Object> depEmpSelect(@RequestParam String dep){
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		
		ArrayList<MemberDep> list = ss.selectMemberDep(dep);
		hmap.put("list", list);
		
		return hmap;
	}
}