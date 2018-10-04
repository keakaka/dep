package com.kh.dep.rtc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RTCController {
	
	@RequestMapping(value="rtcMain.rtc")
	public String showRTCMain(){
		
		
		
		
		return "rtc/rtcMain";
	}
}
