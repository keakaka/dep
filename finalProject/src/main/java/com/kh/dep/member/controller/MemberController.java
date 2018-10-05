package com.kh.dep.member.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.kh.dep.attachment.model.service.AttachService;
import com.kh.dep.attachment.model.service.AttachServiceImpl;
import com.kh.dep.attachment.model.vo.Attachment;
import com.kh.dep.common.CommonUtils;
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
	public String memberInsert(MemberSelect m, Model model,HttpServletRequest request,
					@RequestParam(name="photo", required=false)MultipartFile photo,
					@RequestParam(name="signature", required=false)MultipartFile signature){
		
		
		String root = request.getSession().getServletContext().getRealPath("resources");
		
		String filePath = root + "\\uploadFiles";
		String sigPath = root + "\\signature";
		
		
		String originFileName = photo.getOriginalFilename();
		String orisigFileName = signature.getOriginalFilename();
		
		String ext = originFileName.substring(originFileName.lastIndexOf("."));
		String ext2 = orisigFileName.substring(orisigFileName.lastIndexOf("."));
		
		String changeName = CommonUtils.getRandomString();
		String changeName2 = CommonUtils.getRandomString();
		
		
		try {
			photo.transferTo(new File(filePath + "\\" + changeName + ext) );
			signature.transferTo(new File(sigPath + "\\" + changeName2 + ext2));
			
			
			int result = ms.insertMember(m);
			
		
			
			if(result > 0){
				
				
				
				Attachment file = new Attachment();
				Attachment sig = new Attachment();
				
				file.setOriFileName(originFileName);
				file.setModiFileName(changeName);
				file.setEmpType("ET1");
				
				sig.setOriFileName(orisigFileName);
				sig.setModiFileName(changeName2);
				sig.setEmpType("ET2");
				
				System.out.println(file);
				System.out.println(sig);
				
				AttachService as = new AttachServiceImpl();
				
				
				int result1 = as.insertAttachment(file);
				
				System.out.println("사진 저장 성공 " + result1);
				
				
				if(result1 > 0 ){
					System.out.println("사진 저장 성공 후 서명사진 실행");
					as.insertAttachment(sig);
				}
				
			
				
			}
			
			
			
		} catch (Exception e) {
			
			System.out.println("실패");
			new File(filePath + "\\" + changeName + ext).delete();
			new File(sigPath + "\\" + changeName2 + ext2).delete();
			
		}
		
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
