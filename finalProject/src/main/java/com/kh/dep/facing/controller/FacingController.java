package com.kh.dep.facing.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.kh.dep.addressBook.model.vo.AddressBook;
import com.kh.dep.facing.model.exception.FacingSelectListException;
import com.kh.dep.facing.model.facingService.FacingService;
import com.kh.dep.facing.model.vo.Facing;
import com.kh.dep.facing.model.vo.WorkingRecord;
import com.kh.dep.member.model.service.MemberService;
import com.kh.dep.member.model.vo.MemberSelect;
@Controller
public class FacingController {
	
	@Autowired
	private FacingService fs;
	

	@RequestMapping("facinglist.ms")
	public String selectFacingList(Model model , @RequestParam(name="loginUser")String loginUser ){
		
		System.out.println("컨트롤러 입장");
		System.out.println("회원번호" + loginUser);
	
		/*int userNo = Integer.parseInt(loginUser);
		System.out.println("처리된 회원번호" + userNo);*/
		
		ArrayList<Facing> Facinglist;
		
			try {
				
				Facinglist = fs.selectFacingList(Integer.parseInt(loginUser));
				System.out.println("돌아온 리스트값 페이싱"+Facinglist);
				model.addAttribute("facinglist" , Facinglist);
				
			
				return "facing/facingList";
				
			} catch (FacingSelectListException e) {
				// TODO Auto-generated catch block
				System.out.println("에러입니다.");
				model.addAttribute("msg", e.getMessage());
				
				return "common/errorPage";
			}
			
			
	}
	
	@RequestMapping("facingReceiveList.ms")
	public String selectReceiveList(Model model , @RequestParam(name="loginUser")String loginUser ){
		System.out.println("수신자 컨트롤러 입장");
		
		System.out.println("회원번호" + loginUser);
		
		int empNo = Integer.parseInt(loginUser);
		
		try {
			ArrayList<Facing> FacingReciverList = fs.selectReciveList(empNo);
			model.addAttribute("FacingReciverList" , FacingReciverList);
			
			return "facing/facingReceive";
			
		} catch (FacingSelectListException e) {
			// TODO Auto-generated catch block
			System.out.println("에러입니다.");
			model.addAttribute("msg", e.getMessage());
			
			return "common/errorPage";
		}
		
	
	}
	
	@RequestMapping("facinginsertSelect.ms")
	public String insertFacingSelect(Model model , @RequestParam(name="loginUser") String loginUser)
	{
		System.out.println("인설트 컨트롤러 입장");
		
		
		int empNo = Integer.parseInt(loginUser);
		
		
		System.out.println("회원번호" + empNo);
		
		
		return "facing/facingTest";
	}
	
	
	@RequestMapping("facingInsert.ms")
	public String insertFacing(Model model , @RequestParam(name="loginUser") String loginUser )
	{
		
		System.out.println("인설트 컨트롤러 입장");
		
		
		int empNo = Integer.parseInt(loginUser);
		
		
		System.out.println("insert회원번호 : " + empNo);
		
		/*Facing f = fs.selectInsertFaicng(empNo);
		*/
/*		System.out.println("Insert : " + f);
		*/
		
		return "facing/facingReceive";
		
	}
	
	@RequestMapping("facingSelectOne.ms")
	public String SelectOneFacing(Model model , @RequestParam(name="facingNo") String facingNo)
	{
		System.out.println("selectOne 입장");
		
		int fNo = Integer.parseInt(facingNo);
		
		System.out.println("쪽지번호 : " + fNo);
		
		Facing f;
		try {
			f = fs.selectOneFacing(fNo);
			model.addAttribute("f" , f);
			
			return "facing/facingSelectOneTs1";
		} catch (FacingSelectListException e) {
			// TODO Auto-generated catch block
			model.addAttribute("msg", e.getMessage());
			
			return "common/errorPage";
		}
		
		
	}
	
	@RequestMapping(value="updateFacing.ms")
	public void updateFacing(Model model , @RequestParam String facingNo ,@RequestParam String userNo, HttpServletResponse response)
	{
		
		System.out.println("쪽지 업데이트 입장");
		
		
		int fNo = Integer.parseInt(facingNo);
		int fus = Integer.parseInt(userNo);
		
		
		System.out.println("쪽지번호 : " + fNo);
		System.out.println("사원번호 : " + fus);
		
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			
			ArrayList<Facing> result = fs.updateFacing(fNo ,fus);
			System.out.println("돌아온 리스트값" + result);
			response.getWriter().print(mapper.writeValueAsString(result));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}
	@RequestMapping(value="qrInsert.ms")
	public String qrInsert()
	{
		System.err.println("QR컨트롤 입장");
		
		return "qr/qrCode";
	}

	@RequestMapping(value="qrInsertdb.ms")
	public String Insertqr(Model model,@RequestParam String loginUser )
	{
		System.err.println("출석완료 QR컨트롤 입장");
		
		
		int empNo = Integer.parseInt(loginUser);
		
		System.out.println("출석된 empNo"+empNo);
		
		int result = fs.InsertWorking(empNo);
		
		System.out.println("돌아온 리설트 값 :" + result);
		
		return "qr/qr출석완료";
	}


}
