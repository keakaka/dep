package com.kh.dep.facing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
@Controller
public class FacingController {

	@RequestMapping("facinglist.ms")
	public String logout(){
		System.out.println("컨트롤 오니?");
		return "facing/facing";
	}
}
