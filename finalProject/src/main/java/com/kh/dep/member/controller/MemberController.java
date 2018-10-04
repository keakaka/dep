package com.kh.dep.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.dep.member.exception.LoginException;
import com.kh.dep.member.model.service.MemberService;
import com.kh.dep.member.model.vo.MemberSelect;

@Controller
@SessionAttributes("loginUser")
public class MemberController {
	
	@Autowired
	private MemberService ms;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping(value="login.me")
	public String loginCheck(MemberSelect m, Model model){
		
		
		//임시 비밀번호 생성용
		// 계정 암호화 된 패스워드 DB에 저장 후 
		// 주석 처리하고 사용하면 됨
		/*String encPassword = passwordEncoder.encode(m.getEmpPwd());
		m.setEmpPwd(encPassword);

		System.out.println("로그인 시 암호화 패스워드 : " + m.getEmpPwd());*/
		
		
	
		try {
			MemberSelect loginUser = ms.selectLoginMember(m);
			
			System.out.println("controller member : " + loginUser);
			
			model.addAttribute("loginUser", loginUser);
			
			return "board/boardList";
			
		} catch (LoginException e) {
			
			model.addAttribute("msg", e.getMessage());
			
			return "common/errorPage";
		}
		

		
	}
	
	@RequestMapping(value="myInfo.me")
	public String selectMyInfoDetail(){
		return "eb/myInfo";
	}
	
	@RequestMapping(value="updateMyInfo.me")
	public String updateMyInfoDetail(MemberSelect m, Model model){
		System.out.println("내정보수정 컨트롤러 이동완료!");
		int result = ms.updateMyInfo(m);
		if(result > 0){
			System.out.println("내 정보 수정 완료");
		}
		return "eb/myInfo";
	}
	
	@RequestMapping(value="salary.me")
	public String insertEmpSalary(){
		return "eb/allEmployeeSalary";
	}
	
	@RequestMapping(value="mySalary.me")
	public String showMySalary(){
		return "eb/detailOfSalary";
	}
	
	@RequestMapping(value="myJobPosition.me")
	public String showMyJobPosition(){
		return "eb/detailOfJobPosition";
	}
	
	@RequestMapping(value="myDepartment.me")
	public String showMyDepartment(){
		return "eb/detailOfDepartment";
	}
	
	@RequestMapping(value="myJobDuty.me")
	public String showMyJobDuty(){
		return "eb/detailOfDuty";
	}
	
	@RequestMapping(value="myWorkingHours.me")
	public String showMyWorkingHours(){
		return "eb/detailOfWorkingHours";
	}
	
	@RequestMapping(value="myVacation.me")
	public String showMyVacation(){
		return "eb/detailOfVacation";
	}

}
