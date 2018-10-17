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
import com.kh.dep.sign.model.exception.SelectDocException;
import com.kh.dep.sign.model.service.SignService;
import com.kh.dep.sign.model.vo.Document;
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
	public String insertSign(Model model, InsertSign is, HttpServletRequest request, String signTitle, 
			String signContent, @RequestParam("appList") int[] appList, int[] recList, MultipartFile signFile, int empNo){
		
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
			is.setAppList(appList);
			is.setRecList(recList);
			ss.insertSign(is);
			return "sign/signWright";
		} catch (Exception e) {
			new File(filePath + "\\" + changeName + ext).delete();
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
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
	
	@RequestMapping(value="signImWriter.sg")
	public String signImWriter(Model model, int empNo){
		Document d = new Document();
		d.setEmpNo(empNo);
		try {
			ArrayList<Document> list = ss.selectImWriter(d);
			model.addAttribute("list", list);
			return "sign/signImWriter";
			
		} catch (SelectDocException e) {
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="signApprovalList.sg")
	public String signApprovalList(Model model, int empNo){
		try {
			ArrayList<Document> list = ss.selectApprovalList(empNo);
			
			model.addAttribute(list);
			return "sign/signApprovalList";
		} catch (SelectDocException e) {
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="signReceive.sg")
	public String signReceive(Model model, int empNo){
		
		return "sign/signReceive";
	}
}
