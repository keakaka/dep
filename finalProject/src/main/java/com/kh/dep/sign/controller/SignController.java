package com.kh.dep.sign.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kh.dep.common.CommonUtils;
import com.kh.dep.member.model.service.MemberService;
import com.kh.dep.member.model.vo.MemberDepartment;
import com.kh.dep.sign.model.exception.InsertSignException;
import com.kh.dep.sign.model.service.SignService;
import com.kh.dep.sign.model.vo.InsertSign;
import com.kh.dep.sign.model.vo.MemberDep;

@Controller
public class SignController {
	
	@Autowired
	private SignService ss;
	@Autowired
	private MemberService ms;
	
	@RequestMapping(value="signWright.sg")
	public String signWright(Model model){
		
		ArrayList<MemberDepartment> depList = ms.selectDepList();
		model.addAttribute("depList", depList);
		System.out.println(depList);
		return "sign/signWright";
	}
	
	@RequestMapping(value="insertSign.sg")
	public String insertSign(InsertSign is, HttpServletRequest request, String signTitle, String signContent, @RequestParam("appList") int[] appList, int[] recList, MultipartFile signFile, int empNo){
		
		String root = request.getSession().getServletContext().getRealPath("resources");
		String filePath = root + "\\uploadSignFiles";
		String originFileName = signFile.getOriginalFilename();
		String ext = originFileName.substring(originFileName.lastIndexOf("."));
		String changeName = CommonUtils.getRandomString();
		
		try {
			signFile.transferTo(new File(filePath + "\\" + changeName + ext));
			is.setFilePath(filePath);
			is.setOriginFileName(originFileName);
			is.setChangeName(changeName);
			is.setExt(ext);
			is.setSignTitle(signTitle);
			is.setSignContent(signContent);
			is.setWriter(empNo);
			
			int result = ss.insertSign(is);
			
		} catch (Exception e) {
			new File(filePath + "\\" + changeName + ext).delete();
			String message = e.getMessage();
		}
		
		System.out.println("signcontent=" + signContent);
		for(int i = 0; i < appList.length; i++){
			System.out.println("appList = " + appList[i]);
		}
		for(int i = 0; i < recList.length; i++){
			System.out.println("recList = " + recList[i]);
		}
		System.out.println("파일 : " + signFile);
		
		
		
		return "sign/signWright";
	}
	
	
	@RequestMapping(value="depEmpSelect.sg")
	public @ResponseBody ArrayList<MemberDep> depEmpSelect(@RequestParam String depName){
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		System.out.println("dep : " + depName);
		ArrayList<MemberDep> list = ss.selectMemberDep(depName);
		System.out.println("리스트 : " + list);
		hmap.put("list", list);
		return list;
	}
}
