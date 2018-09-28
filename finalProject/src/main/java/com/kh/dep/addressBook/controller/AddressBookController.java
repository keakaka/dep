package com.kh.dep.addressBook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddressBookController {
	
	@RequestMapping(value="addressBook.ad")
	public String showAddressBookView(){
		return "addressBook/addressBook";
	}
	
}
