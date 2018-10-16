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

<!-- <link href="js/datatables/jquery.dataTables.min.css" rel="stylesheet"
	type="text/css" />
<link href="js/datatables/buttons.bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="js/datatables/fixedHeader.bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="js/datatables/responsive.bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="js/datatables/scroller.bootstrap.min.css" rel="stylesheet"
	type="text/css" /> -->

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

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.2/jquery.form.min.js" integrity="sha384-FzT3vTVGXqf7wRfy8k4BiyzvbNfeYjK+frTVqZeNDFl8woCbF0CYG6g2fMEFFo/i" crossorigin="anonymous"></script>

</head>


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


										<div class="col-md-6" style="width: 100%;">

											<div class="col-md-12 col-sm-12 col-xs-12">
												<div class="x_panel">
													<div class="x_title">
														<h2>
															급여이력조회 <small>인사담당자</small>
														</h2>

														<div class="clearfix"></div>
													</div>


													<div id="search-select">
														<select id="departmentType">
															<option id="web-font">부서명</option>
															<option id="web-font">인사부</option>
															<option id="web-font">영업부</option>
															<option id="web-font">회계부</option>
														</select> <select id="jobType">
															<option id="web-font">직급</option>
															<option id="web-font">대리</option>
															<option id="web-font">과장</option>
															<option id="web-font">대표</option>
														</select> <select id="nameType">
															<option id="web-font">사원이름</option>
															<option id="web-font">뚜비</option>
															<option id="web-font">나나</option>
															<option id="web-font">뽀</option>
														</select> <select id="dateType">
															<option id="web-font">날짜</option>
															<option id="web-font">2018</option>
															<option id="web-font">2017</option>
															<option id="web-font">2016</option>
														</select>

														<button onclick="#">검색</button>

													</div>


													<div class="x_content">

														<table id="datatable"
															class="table table-striped table-bordered">
															<thead>
																<tr>
																	<th>부서명</th>
																	<th>직급</th>
																	<th>사원명</th>
																	<th>기본급<br>불러오기</th>
																	<th>입금월</th>
																	<th>기본급</th>
																	<th>정기상여금</th>
																	<th>비과세수당</th>
																	<th>휴일수당</th>
																	<th>야근수당</th>
																	<th>자격수당</th>
																	<th>국민연금</th>
																	<th>건강보험</th>
																	<th>고용보험</th>
																	<th>산재보험</th>
																	<th>실지급액</th>
																</tr>
															</thead>


															<tbody>
																<tr>
																	<td>영업부</td>
																	<td>대리</td>
																	<td>폴킴</td>
																	<td><input type="button" value="불러오기"/></td>
																	<td>날짜</td>
																	<td>Tiger Nixon</td>
																	<td>System Architect</td>
																	<td>Edinburgh</td>
																	<td>61</td>
																	<td>2011/04/25</td>
																	<td>$320,800</td>
																	<td>ㄴㄻㄴㄹ</td>
																	<td>ㄴㄻㄴㅇㄹ</td>
																	<td>ㄴㅁㅇㄹㄴㅇㅁ</td>
																	<td>ㄴㅇㄹㄴㅇ</td>
																	<td>ㄴㅁㅇㄹㄴㅁㅇ</td>
																</tr>
																<tr>
																	<td>영업부</td>
																	<td>대리</td>
																	<td>폴킴</td>
																	<td><input type="button" value="불러오기"/></td>
																	<td>날짜</td>
																	<td>Garrett Winters</td>
																	<td>Accountant</td>
																	<td>Tokyo</td>
																	<td>63</td>
																	<td>2011/07/25</td>
																	<td>$170,750</td>
																	<td>ㄴㄻㄴㄹ</td>
																	<td>ㄴㄻㄴㅇㄹ</td>
																	<td>ㄴㅁㅇㄹㄴㅇㅁ</td>
																	<td>ㄴㅇㄹㄴㅇ</td>
																	<td>ㄴㅁㅇㄹㄴㅁㅇ</td>
																</tr>
																<tr>
																	<td>영업부</td>
																	<td>대리</td>
																	<td>폴킴</td>
																	<td><input type="button" value="불러오기"/></td>
																	<td>날짜</td>
																	<td>Ashton Cox</td>
																	<td>Junior Technical Author</td>
																	<td>San Francisco</td>
																	<td>66</td>
																	<td>2009/01/12</td>
																	<td>$86,000</td>
																	<td>ㄴㄻㄴㄹ</td>
																	<td>ㄴㄻㄴㅇㄹ</td>
																	<td>ㄴㅁㅇㄹㄴㅇㅁ</td>
																	<td>ㄴㅇㄹㄴㅇ</td>
																	<td>ㄴㅁㅇㄹㄴㅁㅇ</td>
																</tr>
																<tr>
																	<td>영업부</td>
																	<td>대리</td>
																	<td>폴킴</td>
																	<td><input type="button" value="불러오기"/></td>
																	<td>날짜</td>
																	<td>Cedric Kelly</td>
																	<td>Senior Javascript Developer</td>
																	<td>Edinburgh</td>
																	<td>22</td>
																	<td>2012/03/29</td>
																	<td>$433,060</td>
																	<td>ㄴㄻㄴㄹ</td>
																	<td>ㄴㄻㄴㅇㄹ</td>
																	<td>ㄴㅁㅇㄹㄴㅇㅁ</td>
																	<td>ㄴㅇㄹㄴㅇ</td>
																	<td>ㄴㅁㅇㄹㄴㅁㅇ</td>
																</tr>
																<tr>
																	<td>영업부</td>
																	<td>대리</td>
																	<td>폴킴</td>
																	<td><input type="button" value="불러오기"/></td>
																	<td>날짜</td>
																	<td>Airi Satou</td>
																	<td>Accountant</td>
																	<td>Tokyo</td>
																	<td>33</td>
																	<td>2008/11/28</td>
																	<td>$162,700</td>
																	<td>ㄴㄻㄴㄹ</td>
																	<td>ㄴㄻㄴㅇㄹ</td>
																	<td>ㄴㅁㅇㄹㄴㅇㅁ</td>
																	<td>ㄴㅇㄹㄴㅇ</td>
																	<td>ㄴㅁㅇㄹㄴㅁㅇ</td>
																</tr>

															</tbody>
														</table>
													</div>
												</div>

												<form id="excelUploadForm" name="excelUploadForm"
													enctype="multipart/form-data" method="post"
													action="" >

													<div class="contents">
														<div>첨부파일은 한개만 등록 가능합니다.</div>

														<dl class="vm_name">
															<dt class="down w90">첨부 파일</dt>
															<dd>
																<input type="file" id="excelFile" name="excelFile" />
															</dd>
														</dl>
													</div>

													<div class="bottom">
														<button type="button" id="excelImportBtn" class="btn"
															onclick="check()">
															<span>추가</span>
														</button>
														<!-- <input type="submit" value="업로드"/> -->
													</div>
												</form>
												<script>
												function checkFileType(filePath) {
									                var fileFormat = filePath.split(".");
									                if(fileFormat.indexOf("xls") > -1){
									                	return true;
									                }
									                else if (fileFormat.indexOf("xlsx") > -1) {
									                    return true;
									                } else {
									                    return false;
									                }
									 
									            }

												function check() {
									                var file = $("#excelFile").val();
									                if (file == "" || file == null) {
									                    alert("파일을 선택해주세요.");
									                    return false;
									                } else if (!checkFileType(file)) {
									                    alert("엑셀 파일만 업로드 가능합니다.");
									                    return false;
									                }
									                
									                var fileFormat = file.split(".");
									                var fileType = fileFormat[1];
									 
									                if(confirm("업로드 하시겠습니까?")) {
									                	$("#excelUploadForm").attr("action","excelUploadAjax");
									                    var options = {
									                        success : function(data) {
									                            alert("업로드가 완료되었습니다.");
									                        },
									                        type : "POST",
									                        data : {"excelType" : fileType}
									                    };
									                    $("form").ajaxSubmit(options);
									    
									                }
									            }
												</script>


											</div>
										</div>
									</div>
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


			<!-- <!-- Datatables
			<script src="js/datatables/jquery.dataTables.min.js"></script>
			<script src="js/datatables/dataTables.bootstrap.js"></script>
			<script src="js/datatables/dataTables.buttons.min.js"></script>
			<script src="js/datatables/buttons.bootstrap.min.js"></script>
			<script src="js/datatables/jszip.min.js"></script>
			<script src="js/datatables/pdfmake.min.js"></script>
			<script src="js/datatables/vfs_fonts.js"></script>
			<script src="js/datatables/buttons.html5.min.js"></script>
			<script src="js/datatables/buttons.print.min.js"></script>
			<script src="js/datatables/dataTables.fixedHeader.min.js"></script>
			<script src="js/datatables/dataTables.keyTable.min.js"></script>
			<script src="js/datatables/dataTables.responsive.min.js"></script>
			<script src="js/datatables/responsive.bootstrap.min.js"></script>
			<script src="js/datatables/dataTables.scroller.min.js"></script>

			pace
			<script src="js/pace/pace.min.js"></script>
			<script>
				var handleDataTableButtons = function() {
					"use strict";
					0 !== $("#datatable-buttons").length
							&& $("#datatable-buttons").DataTable({
								dom : "Bfrtip",
								buttons : [ {
									extend : "copy",
									className : "btn-sm"
								}, {
									extend : "csv",
									className : "btn-sm"
								}, {
									extend : "excel",
									className : "btn-sm"
								}, {
									extend : "pdf",
									className : "btn-sm"
								}, {
									extend : "print",
									className : "btn-sm"
								} ],
								responsive : !0
							})
				}, TableManageButtons = function() {
					"use strict";
					return {
						init : function() {
							handleDataTableButtons()
						}
					}
				}();
			</script>
			<script type="text/javascript">
				$(document).ready(function() {
					$('#datatable').dataTable();
					$('#datatable-keytable').DataTable({
						keys : true
					});
					$('#datatable-responsive').DataTable();
					$('#datatable-scroller').DataTable({
						ajax : "js/datatables/json/scroller-demo.json",
						deferRender : true,
						scrollY : 380,
						scrollCollapse : true,
						scroller : true
					});
					var table = $('#datatable-fixed-header').DataTable({
						fixedHeader : true
					});
				});
				TableManageButtons.init();
			</script> -->
</body>

</html>
