package com.kh.dep.depEmergency.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.dep.depEmergency.model.depEService.DepEService;
import com.kh.dep.depEmergency.model.exception.DepESelectListException;
import com.kh.dep.depEmergency.model.vo.DepE;

@Controller
public class DepEController {

	@Autowired
	private DepEService ds;
	
	@RequestMapping("depESelect.de")
	public String depESelect(Model model , @RequestParam String loginUser)
	{
	
		
		ArrayList<DepE> DepEList;
		try {
			DepEList = ds.selectDepList(loginUser);
			model.addAttribute("DepEList" , DepEList);
			
			return "depE/depESelect";
		
		} catch (DepESelectListException e) {
			// TODO Auto-generated catch block
			model.addAttribute("msg", e.getMessage());
			
			return "common/errorPage";
		}
	}
}
