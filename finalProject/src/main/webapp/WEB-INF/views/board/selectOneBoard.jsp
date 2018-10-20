<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Meta, title, CSS, favicons, etc. -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>final project</title>

	<!-- Bootstrap core CSS -->

	<link href="${contextPath }/resources/css/bootstrap.min.css" rel="stylesheet">

	<link href="${contextPath }/resources/fonts/css/font-awesome.min.css" rel="stylesheet">
	<link href="${contextPath }/resources/css/animate.min.css" rel="stylesheet">

	<!-- Custom styling plus plugins -->
	<link href="${contextPath }/resources/css/custom.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${contextPath }/resources/css/maps/jquery-jvectormap-2.0.3.css" />
	<link href="${contextPath }/resources/css/icheck/flat/green.css" rel="stylesheet" />
	<link href="${contextPath }/resources/css/floatexamples.css" rel="stylesheet" type="text/css" />
	<link href="${contextPath }/resources/css/calendar/fullcalendar.css" rel="stylesheet">
  	<link href="${contextPath }/resources/css/calendar/fullcalendar.print.css" rel="stylesheet" media="print">
	<script src="${contextPath }/resources/js/jquery.min.js"></script>
	<script src="${contextPath }/resources/js/nprogress.js"></script>
	
	
	<!-- summernote -->
	<link href="${contextPath }/resources/css/summernote.css" rel="stylesheet">
	<script src="${contextPath }/resources/js/summernote.js"></script>


	<!-- 추가  -->
	

	<link href="${contextPath }/resources/fonts/css/font-awesome.min.css" rel="stylesheet">
	<link href="${contextPath }/resources/css/editor/external/google-code-prettify/prettify.css" rel="stylesheet">
	<link href="${contextPath }/resources/css/editor/index.css" rel="stylesheet">
	<!-- select2 -->
  	<link href="${contextPath }/resources/css/select/select2.min.css" rel="stylesheet">
	
	
	


	

</head>


<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">

					<jsp:include page="../common/sidebar.jsp"/>


			<!-- page content -->
			<div class="right_col" role="main">

				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="dashboard_graph">

							<div class="row x_title">
								<div class="col-md-6">
									<h3>부서 게시판</h3>
								</div>
								<div class="col-md-6">

								</div>
							</div>

							<div class="col-md-12 col-sm-12 col-xs-12">
								<div id='calendar'></div>
							</div>

							<div class="clearfix">
							<!-- 시작 -->
						  <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
              <div class="x_panel">
                <div class="x_title">
                  <h2>${sessionScope.loginUser.depName}  <small>${sessionScope.loginUser.empName}  ${sessionScope.loginUser.jobName}</small></h2>
                  
                  <div class="clearfix"></div>
                </div>
                <div class="x_content">

                     <!-- start form for validation -->
                  <form id="demo-form" data-parsley-validate action="" method="post" enctype="multipart/form-data">
                    <label for="fullname">제목 :</label>
                    <input type="text" id="boardTitle" class="form-control" name="boardTitle" readonly value="${b.boardTitle}" /><br>
                	
                	<label for="fullname">작성자 :</label>
                    <input type="text" id="boardTitle" class="form-control" name="boardTitle" readonly value="${b.empName} ${b.jobName}" /><br>
                    
                    <label for="fullname">작성일 :</label>
                    <input type="text" id="boardDate" class="form-control" name="boardDate" readonly value="${b.boardDate}" /><br>
                    
	                <label>첨부파일 : &nbsp; </label>
	                <c:forEach var="at" items="${atlist}">
	                <a href="fileDown.bo?fileName=${at.modiFileName}&orifileName=${at.oriFileName}">${at.oriFileName}</a>&nbsp;&nbsp;
	                </c:forEach>
         
						<br><br>
						<textarea id="summernote" name="boardContent">
							${b.boardContent} 
						</textarea>
						
	                  	<br><br>
	              
	                  	<c:if test="${sessionScope.loginUser.empNo eq b.empNo}"> 
	                  	<button type="button" onclick="moveUpdate(${b.boardNo})" id='Enrollment' class="btn btn-primary" style="width:400px; float:right;">게시글 수정</button>
	                  	</c:if>
                        <br/>
                        <script>
                        	function moveUpdate(bnum){
                        		location.href="updateBoard.bo?boardNo=" + bnum;
                        	}
                        </script>
						
                        
						
                  </form>
                  <br>
                  <!-- end form for validations -->
                 

                </div>
              </div>
            </div>
          </div>
        </div>
        
							
							
							<!-- 끝 -->
							</div>
						</div>
					</div>

				</div>
				<br />
				<!-- footer content -->

				<footer>
					<div class="copyright-info">
						<p class="pull-right">Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>		
						</p>
					</div>
					<div class="clearfix"></div>
				</footer>
				/footer content
			</div>
			<!-- /page content -->

		</div>

	</div>

	<div id="custom_notifications" class="custom-notifications dsp_none">
		<ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group">
		</ul>
		<div class="clearfix"></div>
		<div id="notif-group" class="tabbed_notifications"></div>
	</div>

	<script src="${contextPath }/resources/js/bootstrap.min.js"></script>
	<script src="${contextPath }/resources/js/moment/moment.min.js"></script>
	<script src="${contextPath }/resources/js/calendar/fullcalendar.min.js"></script>
	<!-- gauge js -->
	<%-- <script type="text/javascript" src="${contextPath }/resources/js/gauge/gauge.min.js"></script>
	<script type="text/javascript" src="${contextPath }/resources/js/gauge/gauge_demo.js"></script> --%>
	<!-- chart js -->
	<script src="${contextPath }/resources/js/chartjs/chart.min.js"></script>
	<!-- bootstrap progress js -->
	<script src="${contextPath }/resources/js/progressbar/bootstrap-progressbar.min.js"></script>
	<script src="${contextPath }/resources/js/nicescroll/jquery.nicescroll.min.js"></script>
	<!-- icheck -->
	<script src="${contextPath }/resources/js/icheck/icheck.min.js"></script>
	<!-- daterangepicker -->
	<script type="text/javascript" src="${contextPath }/resources/js/moment/moment.min.js"></script>
	<script type="text/javascript" src="${contextPath }/resources/js/datepicker/daterangepicker.js"></script>

	<script src="${contextPath }/resources/js/custom.js"></script>

	<!-- 추가  -->
	
 
 
  <!-- pace -->
  <script src="${contextPath }/resources/js/pace/pace.min.js"></script>
  
  <!-- form validation -->
  <script src="${contextPath }/resources/js/validator/validator.js"></script>



		<script>
             $(document).ready(function() {
         	  	 var fileExtension = ['.jpg', '.png', '.jpeg', '.gif',];
                $('#summernote').summernote('disable');
         }); 


      </script>
</body>

</html>