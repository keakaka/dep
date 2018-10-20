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
											<table
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
											<table
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
														<tr id="listArea" class="even pointer">
															<input type="hidden" id="empNo2" name="empNo2" value="${list.empNo}">
															<input type="hidden" id="loginNo2" name="loginNo2" value="${loginUser.empNo}">
															<td class="a-center" style="width:85px;"></td>
															<td width="254">${list.depName}</td>
															<td width="180">${list.empName}</td>
															<td width="190">${list.jobName}</td>
															<td width="190">${list.positionName}</td>
															<td width="320">${list.phone}</td>
															<td>${list.email}</td>
															<td><a id="facing"><i class="fa fa-comments-o fa-lg"></i></td>
															<td><a onclick="deleteAdd();"><i class="fa fa-trash fa-lg"></i></a></td>
														</tr>
														</c:if>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<script>
								$(function(){
									$("#facing").click(function(){
										var empNo22 = $(this).parent().parent().children("#empNo2").val();
										console.log(empNo22);
									});
								});
								/* function facing(){
									var empNo22 = $("#listArea").children("input[id=empNo2]").val();
									console.log(empNo22);
								} */
								
							function deleteAdd(){
								
								var empNo = $("#empNo2").val();
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
				


				<!-- /footer content -->
				
</body>
</html>



