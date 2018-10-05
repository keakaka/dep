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
														<th style="width:50px;"></th>
														<th class="column-title">부서명</th>
														<th class="column-title">이름</th>
														<th class="column-title">직위</th>
														<th class="column-title">직책</th>
														<th class="column-title">전화번호</th>
														<th class="column-title">메일 주소</th>
													</tr>
												</thead>
												
												<tbody>
													<c:forEach var="list" items="${addressBookList}" varStatus = 'status'>
														<td class="a-center" style="width:50px;">
														<input type="checkbox" name="check" class="flat" value="${list.empNo}"></td>
														<td>${list.depName}</td>
														<td>${list.empName}</td>
														<td>${list.jobName}</td>
														<td>${list.positionName}</td>
														<td>${list.phone}</td>
														<td>${list.email}</td>
													</c:forEach>
												</tbody>

											</table>
											<div>
												 <button type="button" class="btn btn-info btn-sm" onclick="checkboxArr();">주소록에 추가하기</button>
											</div>
										</div>
									</div>
								</div>
							</div>
							<script>
							function checkboxArr(){
								console.log("주소록 추가하기 버튼");
								
								$("input[name='check']:checked").each(function(i){
									empNo = $("input[name='check']:checked").val();
									
								});
								
								$.ajax({
									url:"insertAddressBook.ad",
									type:'post',
									data:{empNo:empNo},
									success:function(data){
										
									},
									error:function(data){
										
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
													</tr>
												</thead>
												
												<tbody>
													
												</tbody>

											</table>
											
										</div>
									</div>
								</div>
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
				--%>


				<!-- /footer content -->
				
</body>
</html>



