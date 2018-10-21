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
		System.out.println("selectAdd list : " + list);
		
		model.addAttribute("list", list);
		
		return "addressBook/addressBook";
	}
	
	//주소록 회원 검색
	@RequestMapping("searchAddressBookName.ad")
	public String searchAddressBook(HttpServletRequest request, Model model){
		System.out.println("주소록 controller");
		
		List<AddressBook> list = abs.selectAddList();
		System.out.println("selectAdd list : " + list);
		
		model.addAttribute("list", list);
		
		
		String param = request.getParameter("name");
		System.out.println(param);
		
		List<Member> list2 = abs.searchAdd(param);
		
		model.addAttribute("addressBookList", list2);
		System.out.println("주소록 : " + list);
		
		
		return "addressBook/addressBook";
	}
	
	//주소록 테이블에 추가
	@RequestMapping("insertAddressBook.ad")
	public void insertAddressBook(int empNo, int loginNo, HttpServletResponse response, Model model) {
		System.out.println("loginNo : " + loginNo);
		ObjectMapper mapper = new ObjectMapper();
		
		
		AddressBook ab = new AddressBook();
		ab.setEmpNo(empNo);
		ab.setLoginNo(loginNo);
		
		AddressBook ab2 = abs.insertAdd(ab);
		
		model.addAttribute("item", ab2);
	}
	
	//주소록 테이블에 출력
	@RequestMapping("selectAdd.ad")
	public String selectAddressBook(HttpServletRequest request, Model model) {
		System.out.println("selectAddressBook controller");
		
		List<AddressBook> list = abs.selectAddList();
		System.out.println("selectAdd list : " + list);
		
		model.addAttribute("list", list);
		
		return "addressBook/addressBook";
	}
	
	//주소록에서 삭제
	@RequestMapping("deleteAddressBook.ad")
	public void deleteAddressBook(int empNo, int loginNo, HttpServletResponse response) {
		System.out.println("deleteAddressBook empNo : " + empNo);
		System.out.println("deleteAddressBook loginNo : " + loginNo);
		AddressBook ab = new AddressBook();
		ab.setEmpNo(empNo);
		ab.setLoginNo(loginNo);
		
		AddressBook ab2 = abs.deleteAddressBook(ab);
	}
	
	@RequestMapping(value = "facing.ad",method=RequestMethod.POST)
	public void facing(@RequestParam int loginUser, @RequestParam int empNo, Model model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("facing.ad로 넘어옴");
		System.out.println("facing.ad empNo : " + empNo);
		System.out.println("facing.ad loginUser : " + loginUser);

		AddressBook ab = new AddressBook();
		ab.setEmpNo(empNo);
		ab.setLoginNo(loginUser);
	    
	    model.addAttribute("ab", ab);
	    
	}
	
	
	
}







