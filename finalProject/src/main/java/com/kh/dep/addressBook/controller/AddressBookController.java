package com.kh.dep.addressBook.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.dep.addressBook.model.service.AddressBookService;
import com.kh.dep.addressBook.model.vo.AddressBook;
import com.kh.dep.member.model.vo.Member;
import com.kh.dep.member.model.vo.MemberSelect;

@Controller
public class AddressBookController {
	
	@Autowired
	private AddressBookService abs;
	
	@RequestMapping("addressBook.ad")
	public String showAddressBookView(Model model){
		
		List<AddressBook> list = abs.selectAddList();
		
		model.addAttribute("list", list);
		
		return "addressBook/addressBook";
	}
	
	//주소록 회원 검색
	@RequestMapping("searchAddressBookName.ad")
	@ResponseBody 
	public Object searchAddressBook(String searchN, HttpServletRequest request, Map<String, Object> map){
		
		List<AddressBook> list = abs.selectAddList();
		
		List<Member> list2 = abs.searchAdd(searchN);
		
		Map<String, Object> ret = new HashMap<String, Object>();
	    
		ret.put("list", list);
	    ret.put("addressBookList", list2);
		
		return ret;
		
	}
	
	//주소록 테이블에 추가
	@RequestMapping("insertAddressBook.ad")
	@ResponseBody 
	public Object insertAddressBook(int empNo, int loginNo, HttpServletResponse response, Map<String, Object> map) {
		ObjectMapper mapper = new ObjectMapper();
		
		
		AddressBook ab = new AddressBook();
		ab.setEmpNo(empNo);
		ab.setLoginNo(loginNo);
		
		AddressBook ab2 = abs.insertAdd(ab);
		
		Map<String, Object> ret = new HashMap<String, Object>();
	    
	    ret.put("ab2", ab2);
	    
	    return ret;
	}
	
	//주소록 테이블에 출력
	@RequestMapping("selectAdd.ad")
	public String selectAddressBook(HttpServletRequest request, Model model) {
		
		List<AddressBook> list = abs.selectAddList();
		
		model.addAttribute("list", list);
		
		return "addressBook/addressBook";
	}
	
	//주소록에서 삭제
	@RequestMapping("deleteAddressBook.ad")
	@ResponseBody
	public Object deleteAddressBook(int empNo, int loginNo, HttpServletRequest request, Map<String, Object> map) {
		
		AddressBook ab = new AddressBook();
		ab.setEmpNo(empNo);
		ab.setLoginNo(loginNo);
		
		AddressBook ab2 = abs.deleteAddressBook(ab);
		
		List<AddressBook> list22 = abs.selectAddList2(ab);
		
		Map<String, Object> ret = new HashMap<String, Object>();
	    
		ret.put("list22", list22);
	    ret.put("ab2", ab2);
	    
	    return ret;
		
	}
	
	@RequestMapping(value = "facing.ad",method=RequestMethod.POST)
	public void facing(@RequestParam int loginUser, @RequestParam int empNo, Model model, HttpServletRequest request, HttpServletResponse response) {

		AddressBook ab = new AddressBook();
		ab.setEmpNo(empNo);
		ab.setLoginNo(loginUser);
	    
	    model.addAttribute("ab", ab);
	    
	}
	
	
	
}







