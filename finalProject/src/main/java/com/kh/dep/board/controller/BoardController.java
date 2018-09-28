package com.kh.dep.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.kh.dep.common.CommonUtils;



@Controller
public class BoardController {
	
	
	@RequestMapping("boardList.bo")
	public String selectBoardList(){
		
		
		return "board/boardList";	
	}
	
	
	
	@RequestMapping("insertBoard.bo")
	public String insertBoard(){
		
		
		return "board/insertBoard";	
	}
	
	//summerNote image Upload method
/*	@PostMapping("imgUpload.bo")
    @ResponseBody
    public void handleFileUpload(HttpServletResponse response, HttpServletRequest request,
    							@RequestParam("uploadFile") MultipartFile file) {
		request.setCharacterEncoding("UTF-8");
		 String realFolder = "";
		 String filename1 = "";
		 int maxSize = 1024*1024*5;
		 String encType = "UTF-8";
		 String savefile = "upload_img";
		 realFolder = request.getSession().getServletContext().getRealPath(savefile);
		 
		 String root = request.getSession().getServletContext().getRealPath("resources");
			
			String filePath = root + "\\uploadFiles"; // 파일저장경로 설정
			
			System.out.println("filePath : " + filePath);
			
			String originFileName = file.getOriginalFilename();
			String ext = originFileName.substring(originFileName.lastIndexOf("."));
			String changeName = CommonUtils.getRandomString();
		 
			try {
				file.transferTo(new File(filePath + "\\" + changeName + ext) );
				
				 
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		 
		 
			 String fullpath = filePath + "\\" + changeName + ext;

		// System.out.println("경로 : " +fullpath);
		 
		 System.out.println("경로 : " + filePath);
		 System.out.println("경로2 : " + request.getContextPath()+"/upload_img/" + filename1);
		 String path2 = request.getContextPath()+"/upload_img/" + filename1;
		 System.out.println("filename : " + filename1);
		 
		 JSONObject jsonObj = new JSONObject();
		 jsonObj.put("url", fullpath);
			
			String data = jsonObj.toString();
			System.out.println("url : " + data);
			
			JSONParser parser = new JSONParser();
			
			
			try {
				jsonObj = (JSONObject) parser.parse(data);
				PrintWriter out = response.getWriter();
				out.print(jsonObj);
				out.flush();
				out.close();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		


			
			response.setContentType("application/json"); // 데이터 타입을 json으로 설정하기 위한 세팅
			response.setCharacterEncoding("UTF-8");
			
			

			
			 * String root = request.getSession().getServletContext().getRealPath("resources");
		
		String filePath = root + "\\uploadFiles"; // 파일저장경로 설정
		
		String originFileName = photo.getOriginalFilename();
		String ext = originFileName.substring(originFileName.lastIndexOf("."));
		String changeName = CommonUtils.getRandomString(); // commonutils 클래스 생성
		
		try {
			photo.transferTo(new File(filePath + "\\" + changeName + ext) );
			
			m.setUserPwd(passwordEncoder.encode(m.getUserPwd()));
			
			if(m.getGender().equals("1") || m.getGender().equals("3")){
				m.setGender("M");
			}else{
				m.setGender("F");
			}
			
			ms.insertMember(m);
			
			return "main/main";
			
		}
			 * 
			
	}*/

	
	
	


	


	
}
