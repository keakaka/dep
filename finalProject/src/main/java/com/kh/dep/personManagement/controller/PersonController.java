package com.kh.dep.personManagement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.kh.dep.member.model.service.MemberService;
import com.kh.dep.member.model.vo.MemberDepartment;
import com.kh.dep.member.model.vo.MemberJob;
import com.kh.dep.member.model.vo.MemberSelect;
import com.kh.dep.personManagement.model.pmService.PmService;
import com.kh.dep.personManagement.model.vo.DepLeave;
import com.kh.dep.personManagement.model.vo.PromotionLi;
import com.kh.dep.personManagement.model.vo.VacationLi;
import com.kh.dep.personManagement.model.vo.Working;


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
	public @ResponseBody ArrayList<Working> depMgtdayList(@RequestParam String day,@RequestParam String depName,@RequestParam String year){
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		System.out.println("근태 컨트롤 입장"+day);
		
		ArrayList<Working> list = ps.depMgtdayList(day ,depName , year);
		
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
	
	@RequestMapping(value="vacationList.pm")
	public @ResponseBody ArrayList<VacationLi> depVacationList(@RequestParam String depName){
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		System.out.println("휴가 컨트롤 입장"+depName);
		
		ArrayList<VacationLi> list = ps.vacationDepList(depName);
		
		hmap.put("list", list);
		
		return list;
	}
	
	@RequestMapping("vacationDayList.pm")
	public @ResponseBody ArrayList<VacationLi> depVacationDayList(@RequestParam String day){
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		System.out.println("휴가 날짜 컨트롤 입장"+day);
		
		ArrayList<VacationLi> list = ps.vacationDayList(day);
		
		hmap.put("list", list);
		
		return list;
	}
	
	
	
	@RequestMapping("promotion.pm")
	public String promotion(){
		
		
		
		return "personManagement/promotion";
	}
	

	@RequestMapping("depPromotinList.pm")
	public @ResponseBody ArrayList<PromotionLi> selectPromotionList(@RequestParam String depName){
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		System.out.println("진급 컨트롤 입장"+depName);
		
		ArrayList<PromotionLi> list = ps.selectPromotionList(depName);
		
		hmap.put("list", list);
		
		return list;
	}
	
	@RequestMapping("depPromotiondayList.pm")
	public @ResponseBody ArrayList<PromotionLi> selectPromotiondayList(@RequestParam String year,@RequestParam String day,@RequestParam String depName){
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		System.out.println("진급 날짜 컨트롤 입장 "+day+"진급부서 "+depName);
		
		ArrayList<PromotionLi> list = ps.selectPromotiondayList(day,depName,year);
		
		hmap.put("list", list);
		
		return list;
	}



	
	@RequestMapping("leave.pm")
	public String leave(Model model){
		
		ArrayList<MemberDepartment> deplist = ms.selectDepList();

		ArrayList<MemberJob> joblist = ms.selectJobList();
		
		ArrayList<MemberSelect> mlist = ms.selectAllMember();
		
		model.addAttribute("deplist", deplist);
		model.addAttribute("joblist", joblist);
		model.addAttribute("mlist", mlist);
		
		
		
		return "personManagement/leave";
	}
	
	
	@RequestMapping("moveDept.pm")
	public String moveDept(Model model){
		
		
		ArrayList<MemberDepartment> deplist = ms.selectDepList();

		ArrayList<MemberJob> joblist = ms.selectJobList();
		
		ArrayList<MemberSelect> mlist = ms.selectAllMember();
		
		model.addAttribute("deplist", deplist);
		model.addAttribute("joblist", joblist);
		model.addAttribute("mlist", mlist);
		
		
		
		return "personManagement/moveDept";
	}
	
	
	@RequestMapping("depleave.pm")
	public String movedepleave(){
		
		
		return "personManagement/depLeave";
	}
	
	
	@RequestMapping("depleaveList.pm")
	public @ResponseBody ArrayList<DepLeave> selectDepLeaveList(@RequestParam String depName){
		
		
		ArrayList<DepLeave> dlist = ps.selectDepLeaveList(depName);
		
		System.out.println(dlist);
		//hmap.put("list", list);
		
		return dlist;
	}
	
	@RequestMapping("depleavedayList.pm")
	public @ResponseBody ArrayList<DepLeave> depLeavedayList(@RequestParam String day,@RequestParam String depName,@RequestParam String year){
		
		
		ArrayList<DepLeave> list = ps.selectDepLeavedayList(day ,depName , year);
		
		System.out.println(list);
		//hmap.put("list", list);
		
		return list;
	}
	
	@RequestMapping("depmoveDeptRecord.pm")
	public String movedepmoveDeptRecord(){
		
		return "personManagement/depMovedept";
	}
	

}
