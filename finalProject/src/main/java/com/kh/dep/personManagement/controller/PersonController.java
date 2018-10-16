package com.kh.dep.personManagement.controller;

import java.util.ArrayList;
import java.util.HashMap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.dep.personManagement.model.pmService.PmService;
import com.kh.dep.personManagement.model.vo.Working;


import com.kh.dep.member.model.service.MemberService;
import com.kh.dep.member.model.vo.MemberDepartment;
import com.kh.dep.member.model.vo.MemberJob;

@Controller
public class PersonController {
	
	@Autowired
	private PmService ps;
  @Autowired
	private MemberService ms;

	
	@RequestMapping("depMgt.pm")
	public String depMgt(){
		
		
		System.out.println("근태관리 입장");
		
		return "personManagement/departmentManagement";
	}
	
	
	
	@RequestMapping("depMgtList.pm")
	public @ResponseBody ArrayList<Working> depMgtList(@RequestParam String depName){
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		System.out.println("근태 컨트롤 입장"+depName);
		
		ArrayList<Working> list = ps.depMgtList(depName);
		
		hmap.put("list", list);
		
		return list;
	}
	@RequestMapping("depMgtdayList.pm")
	public @ResponseBody ArrayList<Working> depMgtdayList(@RequestParam String day){
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		System.out.println("근태 컨트롤 입장"+day);
		
		ArrayList<Working> list = ps.depMgtdayList(day);
		
		hmap.put("list", list);
		
		return list;
	}
	
	
	
	@RequestMapping("depVacation.pm")
	public String depVacation()
	{
		System.out.println("컨트롤 입장");
		return "personManagement/depVacation";
	}
	@RequestMapping("depPromotion.pm")
	public String depPromotion()
	{
		System.out.println("컨트롤 입장");
		return "personManagement/depPromotion";
	}
	@RequestMapping("vacationList.pm")
	public @ResponseBody ArrayList<Working> depVacationList(@RequestParam String day){
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		System.out.println("근태 컨트롤 입장"+day);
		
		ArrayList<Working> list = ps.depMgtdayList(day);
		
		hmap.put("list", list);
		
		return list;
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
