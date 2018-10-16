package com.kh.dep.personManagement.model.pmService;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.kh.dep.personManagement.model.vo.Working;


public interface PmService {

	ArrayList<Working> depMgtList(String depName);

	ArrayList<Working> depMgtdayList(String day);
	
	
	

}
