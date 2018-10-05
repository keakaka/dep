package com.kh.dep.addressBook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.dep.addressBook.model.service.AddressBookService;
import com.kh.dep.addressBook.model.vo.AddressBook;
import com.kh.dep.member.model.vo.Member;

@Controller
public class AddressBookController {
	
	@Autowired
	private AddressBookService abs;
	
	@RequestMapping("addressBook.ad")
	public String showAddressBookView(){
		System.out.println("주소록 들어옴");
		return "addressBook/addressBook";
	}
	
	
	@RequestMapping("searchAddressBookName.ad")
	public String searchAddressBook(HttpServletRequest request, Model model){
		System.out.println("주소록 controller");
		
		String param = request.getParameter("name");
		System.out.println(param);
		
		List<Member> list = abs.listAll(param);
		
		model.addAttribute("addressBookList", list);
		System.out.println("주소록 : " + list);
		
		return "addressBook/addressBook";
	}
	
	@RequestMapping("insertAddressBook.ad")
	public void insertAddressBook(int empNo, HttpServletResponse response) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		AddressBook ab = abs.selectAdd(empNo);
		System.out.println("insert " + ab);
		
	}
	
}







