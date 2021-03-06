package com.kh.dep.member.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.kh.dep.attachment.model.service.AttachService;
import com.kh.dep.attachment.model.service.AttachServiceImpl;
import com.kh.dep.attachment.model.vo.Attachment;
import com.kh.dep.common.CommonUtils;
import com.kh.dep.member.exception.InsertRecordException;
import com.kh.dep.member.exception.LoginException;
import com.kh.dep.member.model.service.MemberService;
import com.kh.dep.member.model.vo.Alarm;
import com.kh.dep.member.model.vo.Department;
import com.kh.dep.member.model.vo.Job;
import com.kh.dep.member.model.vo.MemberDepartment;
import com.kh.dep.member.model.vo.MemberJob;
import com.kh.dep.member.model.vo.MemberSelect;
import com.kh.dep.member.model.vo.Position;
import com.kh.dep.member.model.vo.SalaryExcel;
import com.kh.dep.member.model.vo.Vacation;
import com.kh.dep.member.model.vo.WorkingHours;

import net.sf.json.JSONObject;

@Controller
@SessionAttributes("loginUser")
public class MemberController {

	@Autowired
	private MemberService ms;

	@Autowired
	private AttachService as;

	@RequestMapping(value="login.me")
	public String loginCheck(MemberSelect m, Model model, RedirectAttributes redirect){

		try {
			MemberSelect loginUser = ms.selectLoginMember(m);

			//System.out.println(loginUser);
			model.addAttribute("loginUser", loginUser);
			
			int myAlarmCount = ms.selectMyAlarmCount(loginUser.getEmpNo());
			//System.out.println(myAlarmCount);
			loginUser.setMyAlarmCount(myAlarmCount);
			redirect.addAttribute("m", loginUser.getEmpNo());
			
			return "redirect:/mainPage.mn";			

		} catch (LoginException e) {

			model.addAttribute("msg", e.getMessage());

			return "common/errorPage";
		}

	}
	
	@RequestMapping("logout.me")
	public String  logout(SessionStatus status){
		
		status.setComplete();
		
		
		return "member/memberLogin";
		
	}


	@RequestMapping("moveMemberInsert.me")
	public String moveMemberInsert(Model model, HttpServletRequest request){

		ArrayList<MemberDepartment> deplist = ms.selectDepList();

		ArrayList<MemberJob> joblist = ms.selectJobList();

		ArrayList<Position> polist = ms.selectpositList();
		
		//사원번호 post 방식으로 넘겨받음
		Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);

		if(map != null){
			int success = (Integer) map.get("success");
				
				model.addAttribute("empNo", success);
		}

		model.addAttribute("deplist", deplist);
		model.addAttribute("joblist", joblist);
		model.addAttribute("polist", polist);

		return "personManagement/memberInsert";
	}

	@RequestMapping("memberInsert.me")
	public String memberInsert(MemberSelect m, Model model,HttpServletRequest request,
			@RequestParam(name="photo", required=false)MultipartFile photo,
			@RequestParam(name="signature", required=false)MultipartFile signature,
			RedirectAttributes redirectAttributes){


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

				int empNo = ms.selectempNumber();
				
				m.setEmpNo(empNo);
				
				int insertId = ms.insertIdPwMember(empNo);
				
				int record = ms.insertRecord(m);

				Attachment file = new Attachment();
				Attachment sig = new Attachment();

				file.setOriFileName(originFileName);
				file.setModiFileName(changeName + ext);
				file.setEmpNo(empNo);
				file.setEmpType("ET1");

				sig.setOriFileName(orisigFileName);
				sig.setModiFileName(changeName2 + ext2);
				sig.setEmpNo(empNo);
				sig.setEmpType("ET2");

				//System.out.println(file);
				//System.out.println(sig);


				int result1 = as.insertAttachment(file);

				//System.out.println("사진 저장 성공 " + result1);


				if(result1 > 0 ){
					//System.out.println("사진 저장 성공 후 서명사진 실행");
					as.insertAttachment(sig);
					
					int success = empNo;
					//redirectAttributes.addAttribute("success", success);
					redirectAttributes.addFlashAttribute("success", success); // post방식으로 전송
				}



			}



		} catch (Exception e) {
			

			new File(filePath + "\\" + changeName + ext).delete();
			new File(sigPath + "\\" + changeName2 + ext2).delete();

		}

		return "redirect:/moveMemberInsert.me";
	}
	
	
	@RequestMapping("insertLeave.me")
	public String insertLeaveMember(MemberSelect m){
		
		try {
			int result = ms.insertLeaveMember(m);
		} catch (InsertRecordException e) {
			
		}
		
		
		return "redirect:/leave.pm";
	}
	
	@RequestMapping("insertmoveDept.me")
	public String insertMoveDept(MemberSelect m){
		
		
		try {
			int result = ms.insertMoveDept(m);
		} catch (InsertRecordException e) {
		}
		
		
		
		
		return "redirect:/moveDept.pm";
	}

	@RequestMapping(value="myInfo.me")
	public String selectMyInfoDetail(){
		return "eb/myInfo";
	}

	@RequestMapping(value="updateMyInfo.me")
	public void updateMyInfoDetail(String empId, String empPwd, String empName, String phone, String check, String emergencyPhone, String email, String address, Model model, HttpServletResponse response){

		boolean result = ms.checkPw(empId, empPwd);

		if(result){
			MemberSelect m = new MemberSelect();
			m.setEmpId(empId);
			m.setEmpPwd(empPwd);
			m.setEmpName(empName);
			m.setPhone(phone);

			if(check.equals("1")){
				check="Y";
			}
			else{
				check="N";
			}

			m.setPhoneReveal(check);
			m.setEmergencyPhone(emergencyPhone);
			m.setEmail(email);
			m.setAddress(address);

			int result2 = ms.updateMyInfo(m);
			if(result2 > 0){
				MemberSelect loginUser = null;
				try {
					loginUser = ms.selectUpdateMember(m);
				} catch (Exception e) {
					e.printStackTrace();
				}

				model.addAttribute("loginUser", loginUser);
			}
		}

		try {
			PrintWriter out = response.getWriter();
			out.println(result);

			JSONObject json = new JSONObject();
			json.put("data", result);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value="salary.me")
	public String insertEmpSalary(){
		return "eb/allEmployeeSalary";
	}

	@RequestMapping(value="mySalary.me")
	public String showMySalary(@RequestParam("var") int empNo, Model model){
		List<SalaryExcel> list = ms.selectMySalaryRecord(empNo);
		
		model.addAttribute("mySalaryRecordlist", list);
		
		return "eb/detailOfSalary";
	}

	@RequestMapping(value="myJobPosition.me")
	public String showMyJobPosition(@RequestParam("var") int empNo, Model model){
		try {
			List<Position> myJobPositionList = ms.selectMyJobPositionRecord(empNo);

			model.addAttribute("myJobPositionList", myJobPositionList);

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

			return "eb/detailOfJobRank";

		} catch (Exception e) {

			model.addAttribute("msg", e.getMessage());

			return "common/errorPage";
		}


	}

	@RequestMapping(value="myWorkingHours.me")
	public String showMyWorkingHours(@RequestParam("var") int empNo, Model model){
		List<WorkingHours> myWorkingHoursRecordList = ms.selectMyWorkingHoursRecord(empNo);


		model.addAttribute("myWorkingHoursRecordList", myWorkingHoursRecordList);

		return "eb/detailOfWorkingHours";
	}

	@RequestMapping(value="myVacation.me")
	public String showMyVacationRecord(@RequestParam("var") int empNo, Model model){

		List<Vacation> myVacationRecordList = ms.selectMyVacationRecord(empNo);

		model.addAttribute("myVacationRecordList", myVacationRecordList);

		return "eb/detailOfVacation";
	}


	@RequestMapping(value="updateMyVacation.me")
	public String applyVacation(int empNo, String vacKind, String vacReason, String vacStartdate, String vacEnddate, Model model){

		Vacation myVac = new Vacation();
		myVac.setEmpNo(empNo);



		myVac.setVacType(vacKind);
		myVac.setVacReason(vacReason);
		/*myVac.setVacStartdate(new SimpleDateFormat("yyyy-MM-dd").format(vacStartdate));*/
		myVac.setVacStartdate(vacStartdate);
		myVac.setVacEnddate(vacEnddate);

		int result = ms.insertMyVacation(myVac);

		return "eb/detailOfVacation";
	}

	@RequestMapping(value="updateMyImage.me")
	public String updateMyImage(MultipartFile findFile, HttpServletRequest request, HttpServletResponse response){

		String root = request.getSession().getServletContext().getRealPath("resources");
		String filePath = root + "\\uploadFiles";

		String originFileName = findFile.getOriginalFilename();
		String newFileName = System.currentTimeMillis() + "." + originFileName.substring(originFileName.lastIndexOf(".") + 1);

		//System.out.println(originFileName);

		try {

			MemberSelect m=(MemberSelect) request.getSession().getAttribute("loginUser");

			//DB내 회원 프로필 사진 파일명 변경해주는 구문
			int empNo = m.getEmpNo();
			int result = ms.updateMyImage(empNo, newFileName, originFileName);

			if(result > 0){

				findFile.transferTo(new File(filePath + "\\" + newFileName));

				m.setModiFileName(newFileName);


				/*response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");*/


				PrintWriter out = response.getWriter();
				out.println(newFileName);

				out.flush();
				out.close();

				JSONObject json = new JSONObject();
				json.put("data", newFileName);


			}else{
			}

		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


		return "eb/myInfo";
	}
	

	@RequestMapping(value="excelUploadAjax.me")
	public void excelUpload(Model model, MultipartHttpServletRequest req, HttpServletResponse response){
		
		
		List<SalaryExcel> list = new ArrayList<SalaryExcel>();
		
		String excelType = req.getParameter("excelType");
		if(excelType.equals("xlsx")){
			list = ms.xlsxExcelReader(req);
		}else if(excelType.equals("xls")){
			list = ms.xlsExcelReader(req);
		}
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(mapper.writeValueAsString(list));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}
	
	@RequestMapping(value="selectSearchCondition.me")
	public void selectSearchCondition(String depType, String jobType, String dateType, String nameType, HttpServletResponse response){
		
		List<SalaryExcel> list = new ArrayList<SalaryExcel>();
		list = ms.selectSearchCondition(depType, jobType, dateType, nameType);
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(mapper.writeValueAsString(list));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="alarm.me")
	public void selectMyAlarm(int empNo, HttpServletResponse response){
		List<Alarm> alarmList = new ArrayList<Alarm>();
		
		alarmList = ms.selectMyAlarmList(empNo);
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(mapper.writeValueAsString(alarmList));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="deleteAlarm.me")
	public String updateMyAlarm(int alarmNo, HttpServletRequest request, RedirectAttributes redirect){
		
		int result = ms.updateMyAlarm(alarmNo);
		
		MemberSelect loginUser=(MemberSelect) request.getSession().getAttribute("loginUser");
		int empNo = loginUser.getEmpNo();
		loginUser.setMyAlarmCount(ms.selectMyAlarmCount(empNo));
		redirect.addAttribute("m", loginUser.getEmpNo());
		return "redirect:/mainPage.mn";
	}
	
	
	@RequestMapping("checkMember.me")
	public @ResponseBody int checkMember(MemberSelect m){

		
		int result = ms.selectCheckMember(m);
		
		return result;
	}
	

}
