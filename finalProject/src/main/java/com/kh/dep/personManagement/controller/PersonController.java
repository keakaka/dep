package com.kh.dep.personManagement.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.dep.member.model.service.MemberService;
import com.kh.dep.member.model.vo.MemberDepartment;
import com.kh.dep.member.model.vo.MemberJob;

@Controller
public class PersonController {
	
	@Autowired
	private MemberService ms;
	
	@RequestMapping("depMgt.pm")
	public String depMgt(){
		
		
		return "personManagement/departmentManagement";
	}
	
	
	
	@RequestMapping("promotion.pm")
	public String promotion(){
		
		
		
		return "personManagement/promotion";
	}
	
	
	@RequestMapping("leave.pm")
	public String leave(Model model){
		
		ArrayList<MemberDepartment> deplist = ms.selectDepList();

		ArrayList<MemberJob> joblist = ms.selectJobList();
		
		
		model.addAttribute("deplist", deplist);
		model.addAttribute("joblist", joblist);
		
		
		
		return "personManagement/leave";
	}
	
	
	@RequestMapping("moveDept.pm")
	public String moveDept(Model model){
		
		
		ArrayList<MemberDepartment> deplist = ms.selectDepList();

		ArrayList<MemberJob> joblist = ms.selectJobList();
		
		
		model.addAttribute("deplist", deplist);
		model.addAttribute("joblist", joblist);
		
		
		
		
		return "personManagement/moveDept";
	}
	
	
	
	

}
