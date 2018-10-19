package com.kh.dep.rtc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.dep.sign.model.service.SignService;
import com.kh.dep.sign.model.vo.Proceeding;

@Controller
public class RTCController {
	@Autowired 
	private SignService ss;
	
	@RequestMapping(value="rtcMain.rtc")
	public String showRTCMain(){
		
		return "rtc/rtcMain";
	}
	
	@RequestMapping(value="insertProceeding.rtc")
	public @ResponseBody int insertProceeding(Proceeding p, String messageContent, int empNo, String roomId){
		p.setRoomContent(messageContent);
		p.setEmpNo(empNo);
		p.setRoomName(roomId);
		
		return ss.insertProceeding(p);
	}
}
