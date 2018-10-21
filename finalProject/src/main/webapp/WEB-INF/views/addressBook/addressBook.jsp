<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>주소록</title>
<!-- Bootstrap core CSS -->

<link href="${contextPath }/resources/css/bootstrap.min.css"
	rel="stylesheet">

<link href="${contextPath }/resources/fonts/css/font-awesome.min.css"
	rel="stylesheet">
<link href="${contextPath }/resources/css/animate.min.css"
	rel="stylesheet">

<!-- Custom styling plus plugins -->
<link href="${contextPath }/resources/css/custom.css" rel="stylesheet">
<link href="${contextPath }/resources/css/icheck/flat/green.css"
	rel="stylesheet">

<script src="${contextPath }/resources/js/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
	a:hover{
		cursor:pointer;
	}
</style>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">

					<jsp:include page="../common/sidebar.jsp" />


					<!-- page content -->
					<div class="right_col" role="main">

						<div class="row">
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="x_panel">
									
									<div class="form-group">
										<div class="col-sm-9" style="width: 30%;">
											<div class="input-group" >
											
												<form action="searchAddressBookName.ad" method="post">
													<span class="input-group-btn">
														<input type="text" name="name" class="form-control">
														<input type="submit" class="btn btn-info" value="검색">
													</span>
												</form>
												
											</div>
										</div>



										
										<div class="x_content">
											<table id="addressBookTable"
												class="table table-striped responsive-utilities jambo_table bulk_action">
												<thead>
													<tr class="headings">
														<th></th>
														<th class="column-title">부서명</th>
														<th class="column-title">이름</th>
														<th class="column-title">직위</th>
														<th class="column-title">직책</th>
														<th class="column-title">전화번호</th>
														<th class="column-title">메일 주소</th>
														<th></th>
														
													</tr>
												</thead>
												
												<tbody>
													<c:forEach var="list" items="${addressBookList}" varStatus = 'status'>
														<tr class="even pointer" id="tableBody">
															<td class="a-center" style="width:85px;" align="center">
															<%-- <input type="checkbox" name="check" class="flat" value="${list.empNo}"></td> --%>
															<!-- <button type="button" class="btn btn-info btn-xs" onclick="checkboxArr();">주소록에 추가하기</button> -->
															<a onclick="checkboxArr();"><i class="fa fa-sign-in fa-lg"></i></a></td>
															<input type="hidden" id="loginNo" name="loginNo" value="${ loginUser.empNo }">
															<input type="hidden" id="empNo" name="empNo" value="${list.empNo}">
															<td width="254">${list.depName}</td>
															<td width="200">${list.empName}</td>
															<td width="190">${list.jobName}</td>
															<td width="200">${list.positionName}</td>
															<td width="320">${list.phone}</td>
															<td>${list.email}</td>
															<td><a href="#/comments-o"><i class="fa fa-comments-o fa-lg"></i></a></td>
															
														</tr>
													</c:forEach>
												</tbody>

											</table>
											<!-- <div>
												 <button type="button" class="btn btn-info btn-sm" onclick="checkboxArr();">주소록에 추가하기</button>
											</div> -->
										</div>
									</div>
								</div>
							</div>
							<script>
							function checkboxArr(){
								console.log("주소록 추가하기 버튼");
								
								
								var empNo = $("#empNo").val();
								var loginNo = $("#loginNo").val();
								console.log(empNo);
								console.log(loginNo);
								
								$.ajax({
									url:"insertAddressBook.ad",
									type:'post',
									data:{empNo:empNo,
										  loginNo:loginNo},
									success:function(data){
										window.location = "selectAdd.ad";
										
										
									},
									error:function(data){
										console.log("error");
									},
									
								});
								
							}
							</script>
							
							<!-- 주소록 테이블 -->
							<div align="center">
							<div class="x_panel" style="margin-top:100px; width:99%;">
									<div align="left" style="margin-left:10px;"><h3>주소록</h3></div>
									<div class="form-group">

										<div class="x_content">
											<table id="addressBookTable"
												class="table table-striped responsive-utilities jambo_table bulk_action">
												<thead>
													<tr class="headings">
														<th></th>
														<th class="column-title">부서명</th>
														<th class="column-title">이름</th>
														<th class="column-title">직위</th>
														<th class="column-title">직책</th>
														<th class="column-title">전화번호</th>
														<th class="column-title">메일 주소</th>
														<th></th>
														<th></th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="list" items="${list}" varStatus = 'status'>
													<c:if test="${list.loginNo == sessionScope.loginUser.empNo }">
														<tr class="even pointer">
															<input type="hidden" id="empNo2" name="empNo2" value="${list.empNo}">
															<input type="hidden" id="loginNo2" name="loginNo2" value="${loginUser.empNo}">
															<td class="a-center" style="width:85px;"></td>
															<td width="254">${list.depName}</td>
															<td width="180">${list.empName}</td>
															<td width="190">${list.jobName}</td>
															<td width="190">${list.positionName}</td>
															<td width="320">${list.phone}</td>
															<td>${list.email}</td>
															<td><a data-toggle="modal" data-target="#myModal22"><i class="fa fa-envelope fa-lg"></i></a></td>
															<%-- <td><a onclick="facing(${list.empNo});"><i class="fa fa-envelope fa-lg"></i></a></td> --%>
															<td><a onclick="deleteAdd(${list.empNo});"><i class="fa fa-trash fa-lg"></i></a></td>
														</tr>
														</c:if>
													</c:forEach>
												</tbody>
											</table>
											<!-- <script type="text/javascript">
											function facing(empNo){
												console.log(empNo);
												
												$("#myModal22").show();
												
											}
											</script> -->
											
											
											
											<div class="modal fade" id="myModal22" role="dialog">
												<div class="modal-dialog">

													<!-- Modal content-->
													<div class="modal-content">
														<div class="modal-header" align="left">
															<button type="button" class="close" data-dismiss="modal">&times;</button>
															<h5 class="modal-title"><i class="fa fa-envelope fa-lg"></i> 메일</h5>
														</div>
														<div class="modal-body">

                     <!-- start form for validation -->
                  <form id="demo-form" data-parsley-validate action="facingInsert.ms?loginUser=${sessionScope.loginUser.empNo}" method="post" enctype="multipart/form-data" autocomplete="off">
                  
                    <!-- <label for="price">보내는사람 * :</label>
                    <input type="text" id="price" class="form-control" name="price" data-parsley-trigger="change" required /><br>
                     -->
					<label for="count" >받는사람 * :</label>
                    <input style="width:200px"type="text" id="count" class="form-control" name="receive" value=''/><br>
                    <label>제목</label><br>
                    <div class="well">
                    	 <fieldset>
	                        <div class="control-group">
	                          <div class="controls">
	                            <div class="col-md-11 xdisplay_inputx form-group has-feedback">
	                              <input type="text" class="form-control has-feedback-left" name="title" id="single_cal1" placeholder="First Name" aria-describedby="inputSuccess2Status" >
	                              <span class="fa fa-calendar-o form-control-feedback left" aria-hidden="true"></span>
	                              <span id="inputSuccess2Status" class="sr-only">(success)</span>
	                            </div>
	                          </div>
	                        </div>
	                      </fieldset>
	                    </div>
						<label>내용</label>
						<textarea id="summernote" name="mailContent" required>
							
						</textarea>
						<input type="hidden" id='memberNo' name="memberNo" value="">
	                  	<label>썸네일 : &nbsp; </label><input id='thumbnail' multiple="multiple" type="file" name="file" size=40>
	                  	<br><br>
	                  	
	                  	<button type="submit" id='Enrollment' class="btn btn-primary" style="border:none; width:400px;">보내기</button>
                        <br/>
                        <input type='hidden' id='hid' name='hid' value=''>	<!-- 유저 아이디 -->
						<input type='hidden' id='read' name='attachNo' value='food'>			<!-- Attach id 번호 -->
						<script type="text/javascript">
      
						/* summernote에서 이미지 업로드시 실행할 함수 */
        function sendFile(file, editor) {
            // 파일 전송을 위한 폼생성
          data = new FormData();
           data.append("uploadFile", file);
           
          //console.log(data);
             $.ajax({ // ajax를 통해 파일 업로드 처리
               data : data,
               type : "POST",
               url : "imgUpload.bo",
               cache : false,
               contentType : false,
               enctype: 'multipart/form-data',
               processData : false,
               success : function(data) { // 처리가 성공할 경우
                    // 에디터에 이미지 출력
                    console.log(data);
                 // $(editor).summernote('editor.insertImage', data);
                  $(editor).summernote('editor.insertImage', "/dep/resources/uploadFiles/"+ data);
               },
               error:function(request,status,error){
                  alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                
               
               }

           }); 
       }
       
       
       function deleteFile(src) {
         
           $.ajax({
               data: {src : src},
               type: "POST",
               url: "imgDelete.bo", // replace with your url
               cache: false,
               success: function(data) {
                   console.log(data);
                   alert('삭제완료');
               }
           });
           
       }
   </script>

      <script>
             $(document).ready(function() {
                  var fileExtension = ['.jpg', '.png', '.jpeg', '.gif',];
                $('#summernote').summernote({ // summernote를 사용하기 위한 선언
                    height: 300,
                    lang: 'ko-KR',
                    toolbar: [
                        // [groupName, [list of button]]
                        ['style', ['bold', 'italic', 'underline', 'clear']],
                        ['font', ['strikethrough', 'superscript', 'subscript']],
                        ['fontsize', ['fontname', 'fontsize']],
                        ['color', ['color']],
                        ['para', ['ul', 'ol', 'paragraph']],
                        ['height', ['height']],
                        ['insert', ['picture', 'link', 'video', 'table', 'hr']]
                      ],
                   callbacks: { // 콜백을 사용
                        // 이미지를 업로드할 경우 이벤트를 발생
                   onImageUpload: function(files, editor, welEditable) {
                       //console.log(files);
                         
                         for (var i = files.length - 1; i >= 0; i--) {
                            
                            for(var j = 0; j < fileExtension.length; j++){
                               var extleng = files[i].name.length;
                               var extdot = files[i].name.lastIndexOf('.');
                               var ext = files[i].name.substring(extdot, extleng).toLowerCase();

                               //console.log(ext + ' / ' + fileExtension[j]) 
                            if(ext == fileExtension[j]){
                             sendFile(files[i], this); 
                            }
                            }
                         }
                  },
                  
                  onMediaDelete : function(target) {
                      alert(target[0].src);
                      deleteFile(target[0].src);
                      console.log(target[0].src)
               }
                
                
            }});
         }); 


      </script>
                        <script type="text/javascript">
                        
						
						</script>
						
                  </form>
                  <br>
                  <!-- end form for validations -->
                 

														</div>
													</div>

												</div>
											</div>

										</div>
									</div>
								</div>
								
								<script>
								/* function facing(empNo){
									var loginUser = $("#loginNo2").val();
									
									$.ajax({
										url:"facing.ad",
										type:'post',
										data:{empNo:empNo,
											  loginUser:loginUser},
										success:function(data){
											var data22 = data;
											console.log("data22 : " + data22);
										},
										error:function(data){
											console.log("error");
										},
										
									});
									
								} */
								
								
							function deleteAdd(empNo){
								var empNo = empNo;
								var loginNo = $("#loginNo2").val();
								
								console.log(empNo);
								console.log(loginNo);
								$.ajax({
									url:"deleteAddressBook.ad",
									type:'post',
									data:{empNo:empNo,
										  loginNo:loginNo},
									success:function(data){
										window.location = "selectAdd.ad";
									},
									error:function(data){
										console.log("error");
									},
									
								});
								
							}
							</script>
							</div>
							<br />
						</div>
						<!-- footer content -->

							<footer>
							<div class="copyright-info">
								<p class="pull-right">
									Gentelella - Bootstrap Admin Template by <a
										href="https://colorlib.com">Colorlib</a>
								</p>
							</div>
							<div class="clearfix"></div>
							</footer>
							<!-- /footer content -->
						<!-- /page content -->

					</div>

				</div>

				<div id="custom_notifications" class="custom-notifications dsp_none">
					<ul class="list-unstyled notifications clearfix"
						data-tabbed_notifications="notif-group">
					</ul>
					<div class="clearfix"></div>
					<div id="notif-group" class="tabbed_notifications"></div>
				</div>


				<script type="text/javascript"
					src="${contextPath }/resources/js/gauge/gauge.min.js"></script>
				<script type="text/javascript"
					src="${contextPath }/resources/js/gauge/gauge_demo.js"></script>
				<!-- chart js -->
				<script src="${contextPath }/resources/js/chartjs/chart.min.js"></script>
				<!-- bootstrap progress js -->
				<script
					src="${contextPath }/resources/js/progressbar/bootstrap-progressbar.min.js"></script>
				<script
					src="${contextPath }/resources/js/nicescroll/jquery.nicescroll.min.js"></script>
				<!-- icheck -->
				<script src="${contextPath }/resources/js/icheck/icheck.min.js"></script>
				<!-- daterangepicker -->
				<script type="text/javascript"
					src="${contextPath }/resources/js/moment/moment.min.js"></script>
				<script type="text/javascript"
					src="${contextPath }/resources/js/datepicker/daterangepicker.js"></script>

				<script src="${contextPath }/resources/js/custom.js"></script>
				
				<link href="${contextPath }/resources/css/summernote.css" rel="stylesheet">
				<script src="${contextPath }/resources/js/summernote.js"></script>
				


				<!-- /footer content --><script type="text/javascript">
        /* summernote에서 이미지 업로드시 실행할 함수 */
        function sendFile(file, editor) {
            // 파일 전송을 위한 폼생성
          data = new FormData();
           data.append("uploadFile", file);
           
	       console.log(data);
            $.ajax({ // ajax를 통해 파일 업로드 처리
               data : data,
               type : "POST",
               url : "imgUpload.bo",
               cache : false,
               contentType : false,
               enctype: 'multipart/form-data',
               processData : false,
               success : function(data) { // 처리가 성공할 경우
                    // 에디터에 이미지 출력
                    console.log(data);
                  $(editor).summernote('editor.insertImage', data);
               },
               error:function(request,status,error){
                  alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                
               
               }

           }); 
       }
       
       
       function deleteFile(src) {
			
    	    $.ajax({
    	        data: {src : src},
    	        type: "POST",
    	        url: "", // replace with your url
    	        cache: false,
    	        success: function(data) {
    	            console.log(data);
    	            alert('삭제완료');
    	        }
    	    });
    	    
    	}
   </script>

		<script>
             $(document).ready(function() {
         	  	 var fileExtension = ['.jpg', '.png', '.jpeg', '.gif',];
                $('#summernote').summernote({ // summernote를 사용하기 위한 선언
                    height: 300,
                    lang: 'ko-KR',
                    toolbar: [
                        // [groupName, [list of button]]
                        ['style', ['bold', 'italic', 'underline', 'clear']],
                        ['font', ['strikethrough', 'superscript', 'subscript']],
                        ['fontsize', ['fontname', 'fontsize']],
                        ['color', ['color']],
                        ['para', ['ul', 'ol', 'paragraph']],
                        ['height', ['height']],
                        ['insert', ['picture', 'link', 'video', 'table', 'hr']]
                      ],
	                callbacks: { // 콜백을 사용
                        // 이미지를 업로드할 경우 이벤트를 발생
                   onImageUpload: function(files, editor, welEditable) {
                       console.log(files);
                         
                         for (var i = files.length - 1; i >= 0; i--) {
                        	 
                         	for(var j = 0; j < fileExtension.length; j++){
                         		var extleng = files[i].name.length;
                         		var extdot = files[i].name.lastIndexOf('.');
                         		var ext = files[i].name.substring(extdot, extleng).toLowerCase();

                        		 console.log(ext + ' / ' + fileExtension[j]) 
                        	 if(ext == fileExtension[j]){
                     		  sendFile(files[i], this); 
                         	}
                            }
                         }
                  },
                  
                  onMediaDelete : function(target) {
                      alert(target[0].src);
                      deleteFile(target[0].src);
                      console.log(target[0].src)
               }
                
                
            }});
         }); 


      </script>
				
</body>
</html>



