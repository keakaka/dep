package com.kh.dep.facing.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kh.dep.addressBook.model.service.AddressBookService;
import com.kh.dep.addressBook.model.vo.AddressBook;
import com.kh.dep.attachment.model.service.AttachService;
import com.kh.dep.attachment.model.vo.Attachment;
import com.kh.dep.common.CommonUtils;
import com.kh.dep.facing.model.exception.FacingSelectListException;
import com.kh.dep.facing.model.facingService.FacingService;
import com.kh.dep.facing.model.vo.Alram;
import com.kh.dep.facing.model.vo.Facing;
import com.kh.dep.facing.model.vo.FacingInsert;
import com.kh.dep.facing.model.vo.FacingInsertR;
import com.kh.dep.facing.model.vo.WorkingQr;
import com.kh.dep.member.model.service.MemberService;
import com.kh.dep.member.model.vo.MemberSelect;

@Controller
public class FacingController {
	
	@Autowired
	private FacingService fs;
	 @Autowired
	private MemberService ms;
	 @Autowired
	private AttachService as;
	 @Autowired
	private AddressBookService abs;
	 
	@RequestMapping("facinglist.ms")
	public String selectFacingList(Model model , @RequestParam String loginUser ){
		ArrayList<Facing> FacingList;
		ArrayList<MemberSelect> mlist = ms.selectAllMember();
		
			try {
				FacingList = fs.selectFacingList(Integer.parseInt(loginUser));
				for(int j = 0; j<FacingList.size(); j++)
				{
				for(int i = 0; i<mlist.size(); i++)
				{
					if(mlist.get(i).getEmpNo() == FacingList.get(j).getReceiver())
					{
						FacingList.get(j).setEmpName(mlist.get(i).getEmpName());
					}
					break;
					}
					
			}
				model.addAttribute("FacingList" , FacingList);
			
				return "facing/facingList";
				
			} catch (FacingSelectListException e) {
				model.addAttribute("msg", e.getMessage());
				
				return "common/errorPage";
			}
			
			
	}
	
	@RequestMapping("facingReceiveList.ms")
	public String selectReceiveList(Model model , @RequestParam(name="loginUser")String loginUser){
		
		int empNo = Integer.parseInt(loginUser);
		System.out.println("삭제 후 수신함 : " + loginUser);
		ArrayList<MemberSelect> mlist = ms.selectAllMember();
		
		try {
			ArrayList<Facing> FacingReciverList = fs.selectReciveList(empNo);
			
			model.addAttribute("FacingReciverList" , FacingReciverList);
			
			return "facing/facingReceive";
			
		} catch (FacingSelectListException e) {
			model.addAttribute("msg", e.getMessage());
			
			return "common/errorPage";
		}
		
	
	}
	
	@RequestMapping("facinginsertSelect.ms")
	public String insertFacingSelect(Model model , @RequestParam(name="loginUser") String loginUser)
	{
		int empNo = Integer.parseInt(loginUser);
		
		return "facing/facingTest";
	}
	
	
	
	
	@RequestMapping("facingInsert.ms")
	public String insertFacing(Model model , @RequestParam String loginUser ,@RequestParam String receive , @RequestParam  String title
			,@RequestParam String mailContent,MultipartHttpServletRequest mtfRequest, HttpServletRequest request)
	{
		List<MultipartFile> fileList = mtfRequest.getFiles("file");

		String root = request.getSession().getServletContext().getRealPath("resources");
		String filePath = root + "\\uploadTest";
		
		//=============================Facing 인설트 ======================
		int empNo = Integer.parseInt(loginUser);
		
		
		//여러명일때 여러번 인설트
		ArrayList<String> list = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(receive,",");
			
		if(receive.length() > 5 )
		{
			FacingInsert fi = new FacingInsert();
			
			fi.setFacingTitle(title);
			fi.setFacingContents(mailContent);
			fi.setEmpNo(empNo);
			
			
			  int tokensize = 0;
			  tokensize=st.countTokens();
				
				while (st.hasMoreTokens()){
					list.add(st.nextToken());
				}
			for(int j = 0; j < list.size(); j++)
			{
						int result = 0;
				
						 result = fs.insertFacing(fi);
						
						ArrayList<MemberSelect> mlist = ms.selectAllMember();
						
						for(int i1 = 0; i1<mlist.size(); i1++)
						{	
							//방금 인설트한 쪽지번호 가져오기 
							Facing nowFacing = fs.selectNowFacing(empNo);
						
						if(mlist.get(i1).getEmpName().equals(list.get(j)))
								{	
									FacingInsertR fir = new FacingInsertR();
									Alram al = new Alram();
									int receiveNo = mlist.get(i1).getEmpNo(); //이름 받아오기
									int nFacingNo = nowFacing.getFacingNo(); //쪽지 번호받아오기
									
									fir.setFacingNo(nFacingNo);
									fir.setReceiver(receiveNo);
									int resultR = fs.insertReceiver(fir);
									//받는사람,제목 
									al.setAlramContents(title);
									al.setEmpNo(receiveNo);
									al.setFacingNo(nFacingNo);
									int alram = fs.insertAlram(al);
									
									for(MultipartFile f : fileList){
							             
							             String originFileName = f.getOriginalFilename();
							             String ext = originFileName.substring(originFileName.lastIndexOf("."));
							             String changeName = CommonUtils.getRandomString();
							             
							          try {
							                f.transferTo(new File(filePath + "\\" + changeName + ext));
							                
							                
							                
							                
							                Attachment file = new Attachment();
							                
							                file.setEmailNo(nowFacing.getFacingNo());
							                file.setEmpNo(empNo);
							                file.setModiFileName(changeName + ext);
							                file.setOriFileName(originFileName);
							                
							                int resultA = as.insertFacingAttach(file);
							                if(resultA>0){
							                }
							          
							             } catch (Exception e) {
							             
							                new File(filePath + "\\" + changeName + ext).delete();
							                
							             } 
									 }break;
								}
						}
					}
		}else{
			FacingInsert fi = new FacingInsert();
			FacingInsertR fir = new FacingInsertR();
			Alram al = new Alram();
			int result = 0;
			
			fi.setFacingTitle(title);
			fi.setFacingContents(mailContent);
			fi.setEmpNo(empNo);
			
		result = fs.insertFacing(fi);
		
		
		
	
		ArrayList<MemberSelect> mlist = ms.selectAllMember();
		//방금 인설트한 쪽지번호 가져오기 
		Facing nowFacing = fs.selectNowFacing(empNo);

		for(MultipartFile f : fileList){
             
             String originFileName = f.getOriginalFilename();
             String ext = originFileName.substring(originFileName.lastIndexOf("."));
             String changeName = CommonUtils.getRandomString();
             
          try {
                f.transferTo(new File(filePath + "\\" + changeName + ext));
                
                Attachment file = new Attachment();
                
                file.setEmailNo(nowFacing.getFacingNo());
                file.setEmpNo(empNo);
                file.setModiFileName(changeName + ext);
                file.setOriFileName(originFileName);
                
                int resultA = as.insertFacingAttach(file);
                if(resultA>0){
                }
          
             } catch (Exception e) {
             
                new File(filePath + "\\" + changeName + ext).delete();
                
             }  
 
		 }
	
		for(int i = 0; i<mlist.size(); i++)
		{	
		if(mlist.get(i).getEmpName().equals(receive))
		{	
			int receiveNo = mlist.get(i).getEmpNo();
			int nFacingNo = nowFacing.getFacingNo();
		
			fir.setFacingNo(nFacingNo);
			fir.setReceiver(receiveNo);
		
			int resultR = fs.insertReceiver(fir);
			al.setAlramContents(title);
			al.setEmpNo(receiveNo);
			al.setFacingNo(nFacingNo);
			int alram = fs.insertAlram(al);
			
			/*알람카운트 업데이트 부분(은비)*/
            int receiverEmpNo = mlist.get(i).getEmpNo();
            int alarmCount = fs.selectAlarmCount(receiverEmpNo);
             mlist.get(i).setMyAlarmCount(alarmCount);
            MemberSelect m=(MemberSelect) request.getSession().getAttribute("loginUser");
            m.setMyAlarmCount(mlist.get(i).getMyAlarmCount());
			
			break;
	}
		
}
		}

		return "facing/facingTest";
		
	}
	
	@RequestMapping("facingSelectOne.ms")
	public @ResponseBody Facing SelectOneFacing(Model model , @RequestParam(name="facingNo") String facingNo)
	{
		
		int fNo = Integer.parseInt(facingNo);
		
		Facing f;
		
		try {
			f = fs.selectOneFacing(fNo);
			model.addAttribute("f" , f);
			return f;
			/*return "facing/facingSelectOneTs1";*/
		} catch (FacingSelectListException e) {
			// TODO Auto-generated catch block
			model.addAttribute("msg", e.getMessage());
			return null;
			/*return "common/errorPage";*/
		}
	}
	
	@RequestMapping(value="updateFacing.ms")
	public void updateFacing(Model model , @RequestParam String facingNo ,@RequestParam String userNo, HttpServletResponse response)
	{
		
		int fNo = Integer.parseInt(facingNo);
		int fUo = Integer.parseInt(userNo);
		try {
			ObjectMapper mapper = new ObjectMapper();
			int result = fs.updateFacing(fNo);
			response.getWriter().print(mapper.writeValueAsString(result));
			int deleteAlarm = fs.deleteAlarm(fNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		
	}
	@RequestMapping(value="qrInsert.ms")
	public String qrInsert()
	{
		
		return "qr/qrCode";
	}

	@RequestMapping(value="qrInsertdb.ms")
	public String Insertqr(Model model,@RequestParam String loginUser )
	{
		
		int empNo = Integer.parseInt(loginUser);
		
		int result = fs.InsertWorking(empNo);
		
		ArrayList<WorkingQr> qrList = fs.selectWorking(empNo);
		
		
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("MM-dd");
		String todayF = date.format(today).substring(0,2);
		
		for(int i = 0; i<qrList.size(); i++)
		{
			String sysdate = qrList.get(i).getHours();
			String sys = sysdate.substring(0,2);
			
			int siint = Integer.parseInt(sys);
			String jigak ="지각" ;
			String chul ="정상출근";
			String offWork = "퇴근";
			
			
		if(qrList.get(i).getToday().equals(todayF))
		{
			if( siint > 10 && siint <=17 )
			{
				qrList.get(i).setState(jigak);;
				System.out.println("리스트 출력1 :" + qrList);
			}else if(siint > 7 &&siint <= 10)
			{
				
		
				qrList.get(i).setState(chul);
				
			}else if(siint >= 17)
			{	
				
				qrList.get(i).setState(offWork);
				
				if(siint > 17 && siint < 24 )
				{
					
						
						int cho = 0;
						cho = siint - 17;	
						
						qrList.get(i).setPlusWork(cho);
						
				}
				
			}
			
			
		
		}
		
		}
		
		model.addAttribute("qrList" , qrList);

		return "qr/qrqr";
	}
	
	@RequestMapping("replyFacing.ms")
	public String replyFacing(Model model, @RequestParam String empNo )
	{
		Facing f = new Facing();
		int e = Integer.parseInt(empNo);
		
		
		ArrayList<MemberSelect> mlist = ms.selectAllMember();
		
		for(int i = 0; i < mlist.size(); i++)
		{
			if(mlist.get(i).getEmpNo() == e)
			{
				String reply = mlist.get(i).getEmpName();
				f.setEmpName(reply);
			}
		}
		
		model.addAttribute("f" , f);

		
		return "facing/facingReply";
	}
	

	@RequestMapping("facingInsert2.ms")
	public String insertFacing2(Model model , @RequestParam String loginUser ,@RequestParam String receive , @RequestParam  String title
			,@RequestParam String mailContent,MultipartHttpServletRequest mtfRequest, HttpServletRequest request)
	{
		List<MultipartFile> fileList = mtfRequest.getFiles("file");

		String root = request.getSession().getServletContext().getRealPath("resources");
		String filePath = root + "\\uploadTest";

		//=============================Facing 인설트 ======================
		int empNo = Integer.parseInt(loginUser);
		
		FacingInsert fi = new FacingInsert();
		FacingInsertR fir = new FacingInsertR();
		Alram al = new Alram();
		
		fi.setFacingTitle(title);
		fi.setFacingContents(mailContent);
		fi.setEmpNo(empNo);
		
		
		int result = fs.insertFacing(fi);
		
		ArrayList<MemberSelect> mlist = ms.selectAllMember();
		Facing nowFacing = fs.selectNowFacing(empNo);
		
		//==================수신자 ,알람 인설트==================
		if(result > 0  && receive.length() > 6 )
		{
			StringTokenizer st = new StringTokenizer(receive,",");
			ArrayList<String> list = new ArrayList<String>();
			
			while (st.hasMoreTokens()){
				list.add(st.nextToken());
			}

			for(int j = 0; j < list.size(); j++)
			{
				
				for(int i = 0; i<mlist.size(); i++)
				{	
					if(mlist.get(i).getEmpName().equals(list.get(j)))
							{	
						
								int receiveNo = mlist.get(i).getEmpNo(); //이름 받아오기
								int nFacingNo = nowFacing.getFacingNo(); //쪽지 번호받아오기
					
								fir.setFacingNo(nFacingNo);
								fir.setReceiver(receiveNo);
					
								int resultR = fs.insertReceiver(fir);
								//받는사람,제목 
								al.setAlramContents(title);
								al.setEmpNo(receiveNo);
								al.setFacingNo(nFacingNo);
								int alram = fs.insertAlram(al);
								break;
						
					}
				}
			}
		}
						
			
			else if(result > 0 && receive.length() < 6 )
			{
				for(int i = 0; i<mlist.size(); i++)
				{	
				if(mlist.get(i).getEmpName().equals(receive))
				{	
					int receiveNo = mlist.get(i).getEmpNo();
					int nFacingNo = nowFacing.getFacingNo();
				
					fir.setFacingNo(nFacingNo);
					fir.setReceiver(receiveNo);
				
					int resultR = fs.insertReceiver(fir);
					al.setAlramContents(title);
					al.setEmpNo(receiveNo);
					al.setFacingNo(nFacingNo);
					int alram = fs.insertAlram(al);
					break;
				
			}
				
		}
		}
		
		
		//==================어태치 먼트 =========================

		for(MultipartFile f : fileList){
             
             String originFileName = f.getOriginalFilename();
             String ext = originFileName.substring(originFileName.lastIndexOf("."));
             String changeName = CommonUtils.getRandomString();
             
          try {
                f.transferTo(new File(filePath + "\\" + changeName + ext));
                
                
                Attachment file = new Attachment();
                
                file.setEmailNo(nowFacing.getFacingNo());
                file.setEmpNo(empNo);
                file.setModiFileName(changeName + ext);
                file.setOriFileName(originFileName);
                
                int resultA = as.insertFacingAttach(file);
          
             } catch (Exception e) {
             
                new File(filePath + "\\" + changeName + ext).delete();
                
             }  
 
		 }
		
		List<AddressBook> list = abs.selectAddList();
		
		model.addAttribute("list", list);

		return "addressBook/addressBook";
		
	}

	
	@RequestMapping(value="facingDown.ms")
	public @ResponseBody void signFileDownload(HttpServletRequest request, HttpServletResponse response, String oriName, String modiName){
		
		String root = request.getSession().getServletContext().getRealPath("resources");
		String filePath = root + "\\uploadTest";
		
	    
		String fileName;
	    
		try {
			File file = new File(filePath, modiName);
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
			
			fileName = new String(oriName.getBytes("UTF-8"), "iso-8859-1");
			
		    response.setContentType("application/octet-stream");


		    //다운로드와 다운로드될 파일이름
		    response.setHeader("Content-Disposition", "attachment; filename=\""+ fileName + "\"");
		    //파일복사
		    FileCopyUtils.copy(in, response.getOutputStream());
		    in.close();
		    response.getOutputStream().flush();
		    response.getOutputStream().close();
			
		    
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
	}
	
	
	
}}