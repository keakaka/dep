<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Gentallela Alela! |</title>

<!-- Bootstrap core CSS -->

<link href="${contextPath }/resources/css/bootstrap.min.css"
	rel="stylesheet">

<link href="${contextPath }/resources/fonts/css/font-awesome.min.css"
	rel="stylesheet">
<link href="${contextPath }/resources/css/animate.min.css"
	rel="stylesheet">

<!-- Custom styling plus plugins -->
<link href="${contextPath }/resources/css/custom.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${contextPath }/resources/css/maps/jquery-jvectormap-2.0.3.css" />
<link href="${contextPath }/resources/css/icheck/flat/green.css"
	rel="stylesheet" />
<link href="${contextPath }/resources/css/floatexamples.css"
	rel="stylesheet" type="text/css" />
<link href="${contextPath }/resources/css/calendar/fullcalendar.css"
	rel="stylesheet">
<link
	href="${contextPath }/resources/css/calendar/fullcalendar.print.css"
	rel="stylesheet" media="print">
<script src="${contextPath }/resources/js/jquery.min.js"></script>
<script src="${contextPath }/resources/js/nprogress.js"></script>

<!--[if lt IE 9]>
	<script src="../assets/js/ie8-responsive-file-warning.js"></script>
	<![endif]-->

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->

</head>
<style>
/* #info1 {<!--
	padding-left: 20px;
	padding-top: 10px;
	padding-bottom: 10px; -->
	background: #ccc;
} */

#image{
    margin-left: 150px;
    margin-top: 50px;
}

#updateImg{
	text-align: center;
    width: 273px;
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
								<div class="dashboard_graph">

									<div class="row x_title">
										<div class="col-md-6" style="width:30%;">
											<h3>
												마이페이지 <small>내 정보</small>
											</h3>

											<!-- <div id="content"> -->
											<!-- 이미지 변경 -->
											<div id="image">
												<img src="${contextPath }/resources/images/userImage.png">
												<div id="updateImg"><a href="#">이미지 변경</a></div>
											</div>

										</div>
										<div class="col-md-6">


											<div id="normalInfo">


												<form class="form-horizontal form-label-left">
													<div id="info1">
														<h4 style="color: #34495E;"></h4>
														<div class="form-group">
															<label class="control-label col-md-3 col-sm-3 col-xs-12"
																for="userId">아이디</label>
															<div class="col-md-6 col-sm-6 col-xs-12">
																<input type="text" id="userId" value="1004" readonly
																	class="form-control col-md-7 col-xs-12">
															</div>
														</div>
														<div class="form-group">
															<label class="control-label col-md-3 col-sm-3 col-xs-12"
																for="userPw">비밀번호 </label>
															<div class="col-md-6 col-sm-6 col-xs-12">
																<input type="password" id="userPw" name="userPw"
																	value="*******" readonly
																	class="form-control col-md-7 col-xs-12">
															</div>
														</div>

														<div class="form-group">
															<label class="control-label col-md-3 col-sm-3 col-xs-12"
																for="userName">이름</label>
															<div class="col-md-6 col-sm-6 col-xs-12">
																<input type="text" id="userName" required="required"
																	class="form-control col-md-7 col-xs-12">
															</div>
														</div>

														<div class="form-group">
															<label class="control-label col-md-3 col-sm-3 col-xs-12"
																for="phone">연락처(휴대폰) </label>
															<div class="col-md-6 col-sm-6 col-xs-12">
																<input type="text" id="phone" name="phone"
																	required="required"
																	class="form-control col-md-7 col-xs-12">
																<!-- 핸드폰 번호 공개여부 설정 -->
																공개<input type="checkbox" size="5"></input>
															</div>
														</div>



														<div class="form-group">
															<label class="control-label col-md-3 col-sm-3 col-xs-12"
																for="phone2">비상연락처 </label>
															<div class="col-md-6 col-sm-6 col-xs-12">
																<input type="text" id="phone2" name="phone2"
																	required="required"
																	class="form-control col-md-7 col-xs-12">
															</div>
														</div>

														<div class="form-group">
															<label class="control-label col-md-3 col-sm-3 col-xs-12"
																for="address">주소 </label>
															<div class="col-md-6 col-sm-6 col-xs-12">
																<input type="text" id="address" name="address"
																	required="required"
																	class="form-control col-md-7 col-xs-12">
															</div>
														</div>

														<div class="form-group">
															<label for="hireDate"
																class="control-label col-md-3 col-sm-3 col-xs-12">입사일</label>
															<div class="col-md-6 col-sm-6 col-xs-12">
																<input id="hireDate"
																	class="form-control col-md-7 col-xs-12" type="text"
																	value="2018-09-20" readonly name="hireDate">
															</div>
														</div>

														<div class="form-group">
															<label for="email"
																class="control-label col-md-3 col-sm-3 col-xs-12">
																이메일 </label>
															<div class="col-md-6 col-sm-6 col-xs-12">
																<input id="email"
																	class="form-control col-md-7 col-xs-12" type="email"
																	name="email">
															</div>
														</div>

														<div class="form-group">
															<label for="position"
																class="control-label col-md-3 col-sm-3 col-xs-12">직급</label>
															<div class="col-md-6 col-sm-6 col-xs-12">
																<input id="position"
																	class="form-control col-md-7 col-xs-12" type="text"
																	name="position" value="대리" readonly>
															</div>
														</div>

														<div class="form-group">
															<label for="department"
																class="control-label col-md-3 col-sm-3 col-xs-12">
																부서 </label>
															<div class="col-md-6 col-sm-6 col-xs-12">
																<input id="department"
																	class="form-control col-md-7 col-xs-12" type="text"
																	name="department">
															</div>
														</div>
													</div>

													<button type="submit">수정하기</button>
												</form>
											</div>
										</div>
									</div>

									<div class="col-md-12 col-sm-12 col-xs-12">
										<div id='calendar'></div>
									</div>

									<div class="clearfix"></div>
								</div>
							</div>

						</div>
						<br />
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
					</div>
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

			<script src="${contextPath }/resources/js/bootstrap.min.js"></script>
			<script src="${contextPath }/resources/js/moment/moment.min.js"></script>
			<script
				src="${contextPath }/resources/js/calendar/fullcalendar.min.js"></script>
			<!-- gauge js -->
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
