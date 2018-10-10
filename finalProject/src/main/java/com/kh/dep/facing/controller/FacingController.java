package com.kh.dep.facing.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.kh.dep.facing.model.exception.FacingSelectListException;
import com.kh.dep.facing.model.facingService.FacingService;
import com.kh.dep.facing.model.vo.Facing;
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
		/*String loginUser = Integer.parseInt(request.parameter("loginUser"));
		*/
		/*Model model ,@RequestParam String loginUser*/
		/*int userNo = Integer.parseInt(loginUser);
		System.out.println(userNo);
		*/
		/*int userNo = Integer.parseInt("loginUser");
		*/
		int userNo = Integer.parseInt(loginUser);
		System.out.println("인트처리된 회원번호" + userNo);
		
		ArrayList<Facing> Facinglist;
		try {
			Facinglist = fs.selectFacingList(userNo);
			model.addAttribute("facing" , Facinglist);
			System.out.println("돌아온 리스트값"+Facinglist);
			return "facing/facingList";
				
		} catch (FacingSelectListException e) {
			// TODO Auto-generated catch block
			model.addAttribute("msg", e.getMessage());
			
			return "common/errorPage";
		}
		
	}
	
	@RequestMapping("facing.ms")
	public String facing() {
		return "facing/facing";
	}
}
