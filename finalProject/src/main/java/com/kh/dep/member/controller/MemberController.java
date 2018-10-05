package com.kh.dep.member.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.dep.member.exception.LoginException;
import com.kh.dep.member.model.service.MemberService;
import com.kh.dep.member.model.vo.Department;
import com.kh.dep.member.model.vo.Job;
import com.kh.dep.member.model.vo.MemberDepartment;
import com.kh.dep.member.model.vo.MemberJob;
import com.kh.dep.member.model.vo.MemberSelect;
import com.kh.dep.member.model.vo.Position;

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


	@RequestMapping("moveMemberInsert.me")
	public String moveMemberInsert(Model model){

		ArrayList<MemberDepartment> deplist = ms.selectDepList();

		ArrayList<MemberJob> joblist = ms.selectJobList();

		model.addAttribute("deplist", deplist);
		model.addAttribute("joblist", joblist);

		return "personManagement/memberInsert";
	}

	@RequestMapping("memberInsert.me")
	public String memberInsert(MemberSelect m, Model model){

		System.out.println("컨트롤러 입력");

		System.out.println(m);


		return "personManagement/memberInsert";
	}

	@RequestMapping(value="myInfo.me")
	public String selectMyInfoDetail(){
		return "eb/myInfo";
	}

	@RequestMapping(value="updateMyInfo.me")
	public String updateMyInfoDetail(MemberSelect m, Model model){
		try {
			System.out.println("내정보수정 컨트롤러");
			boolean result = ms.checkPw(m);
			/*System.out.println(result);*/
			if(result){
				int result2 = ms.updateMyInfo(m);
				/*System.out.println(result2);*/
				if(result2 > 0){
					MemberSelect loginUser = ms.selectUpdateMember(m);
					System.out.println("controller member : " + loginUser);

					model.addAttribute("loginUser", loginUser);
					System.out.println("내 정보 수정 완료");

				}
			}else{
				model.addAttribute("result", result);
			}
			return "eb/myInfo";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());

			return "common/errorPage";
		}


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
	public String showMyJobPosition(@RequestParam("var") int empNo, Model model){
		try {
			List<Position> myJobPositionList = ms.selectMyJobPositionRecord(empNo);

			model.addAttribute("myJobPositionList", myJobPositionList);
			System.out.println("나의 직책이력 : " + myJobPositionList);

			return "eb/detailOfJobPosition";

		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());

			return "common/errorPage";
		}

	}

	@RequestMapping(value="myDepartment.me")
	public String showMyDepartment(@RequestParam("var") String empId, Model model){
		try {
			List<Department> myDepRecordList = ms.selectMyDepRecordInfo(empId);

			model.addAttribute("myDepRecordList", myDepRecordList);
			System.out.println("나의 부서이력 : " + myDepRecordList);

			return "eb/detailOfDepartment";

		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());

			return "common/errorPage";
		}



	}

	@RequestMapping(value="myJobRank.me")
	public String showMyJobRank(@RequestParam("var") int empNo, Model model){
		try {
			List<Job> myJobRankRecordList = ms.selectMyJobRecord(empNo);

			model.addAttribute("myJobRankRecordList", myJobRankRecordList);
			System.out.println("나의 직급이력 : " + myJobRankRecordList);

			return "eb/detailOfJobRank";

		} catch (Exception e) {

			model.addAttribute("msg", e.getMessage());

			return "common/errorPage";
		}


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
