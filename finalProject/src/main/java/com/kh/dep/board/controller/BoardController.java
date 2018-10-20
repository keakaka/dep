package com.kh.dep.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import com.kh.dep.board.exception.BoardException;
import com.kh.dep.board.model.service.BoardService;
import com.kh.dep.board.model.vo.Board;
import com.kh.dep.common.CommonUtils;
import com.kh.dep.member.model.vo.MemberSelect;



@Controller
public class BoardController {


	@Autowired
	private BoardService bs;

	@RequestMapping("boardList.bo")
	public String selectBoardList(Model model){



		try {
			ArrayList<Board>blist = bs.selectBoardList();

			model.addAttribute("blist", blist);

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}


		return "board/boardList";	
	}


	
	@RequestMapping("selectOneBoard.bo")
	public String selectOneBoard(@RequestParam String bid){
		
		
		Board b = bs.selectOneBoard(Integer.parseInt(bid));
		
		System.out.println("Cont b출력 : " + b);
		

		return "board/boardList";
	}

	@RequestMapping("insertBoard.bo")
	public String insertBoard(){


		return "board/insertBoard";	
	}

	@RequestMapping("writeBoard.bo")
	public String insertWriteBoard(Board b, MultipartHttpServletRequest mtfRequest, HttpServletRequest request){
		
		List<MultipartFile> fileList = mtfRequest.getFiles("file");

		String root = request.getSession().getServletContext().getRealPath("resources");
		String filePath = root + "\\uploadTest";
		
		
		
		for(MultipartFile f : fileList){
			
	
			System.out.println("동작확인");
			String originFileName = f.getOriginalFilename();
			String ext = originFileName.substring(originFileName.lastIndexOf("."));
			String changeName = CommonUtils.getRandomString();
			
			 
			
			try {
				f.transferTo(new File(filePath + "\\" + changeName + ext));
				System.out.println("성공");
			} catch (Exception e) {
			
				new File(filePath + "\\" + changeName + ext).delete();
				System.out.println("실패");
			}
			
		}
		
		System.out.println(b);
		
		
		return "board/insertBoard";
	}
	
	//summerNote image Upload method
	@RequestMapping("imgUpload.bo")
	@ResponseBody
    public void handleFileUpload(HttpServletResponse response, HttpServletRequest request,
    							@RequestParam("uploadFile") MultipartFile file) {
		
		String root = request.getSession().getServletContext().getRealPath("resources");
		String filePath = root + "\\uploadFiles";

		String originFileName = file.getOriginalFilename();
		
		String ext = originFileName.substring(originFileName.lastIndexOf("."));
		
		String changeName = CommonUtils.getRandomString();
		
		
		
		
		try {
			
			file.transferTo(new File(filePath + "\\" + changeName + ext) );


				PrintWriter out = response.getWriter();
				out.println(changeName + ext);

				out.flush();
				out.close();

				JSONObject json = new JSONObject();
				json.put("data", changeName + ext);


				System.out.println(json.toString());
			

		} catch (Exception e) {
			
			new File(filePath + "\\" + changeName + ext).delete();
		}
		


	}


	// summerNote 이미지 삭제
	@RequestMapping("imgDelete.bo")
	public 	@ResponseBody int imgDelete(HttpServletRequest request,HttpServletResponse response, @RequestParam("src")String src){
		
		String root = request.getSession().getServletContext().getRealPath("resources");
		String filePath = root + "//uploadFiles";
		
		String fileName = src.substring(src.lastIndexOf("/") + 1);
		
		String fullPath = filePath +"//" + fileName;
		
		boolean istrue = new File(fullPath).delete();		
		
		if(istrue == true){
			
			return 1;
			
		}
		
		return 0;
		
	}








}
