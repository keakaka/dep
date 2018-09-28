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

<title>일정 관리</title>

<link href="${contextPath }/resources/css/bootstrap.min.css"
	rel="stylesheet">

<link href="${contextPath }/resources/fonts/css/font-awesome.min.css"
	rel="stylesheet">
<link href="${contextPath }/resources/css/animate.min.css"
	rel="stylesheet">

<link href="${contextPath }/resources/css/custom.css" rel="stylesheet">
<link href="${contextPath }/resources/css/icheck/flat/green.css"
	rel="stylesheet">

<link href="${contextPath }/resources/css/calendar/fullcalendar.css"
	rel="stylesheet">
<link
	href="${contextPath }/resources/css/calendar/fullcalendar.print.css"
	rel="stylesheet" media="print">

<script src="${contextPath }/resources/js/jquery.min.js"></script>
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
#attSearch {
	width: 500px;
}

#attSearchDiv {
	margin-left: 140px;
}

#attSearchDiv2 {
	margin-top: 7px;
}

#modal-dialog {
	width: 550px;
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
										<div class="col-md-6">
											<h3>Calendar</h3>
										</div>
										<div class="col-md-6"></div>
									</div>
									<div class="" role="tabpanel" data-example-id="togglable-tabs">
										<div class="col-md-12 col-sm-12 col-xs-12">
											<div class="" role="tabpanel"
												data-example-id="togglable-tabs">
												<ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
													<li role="presentation" class="active"><a
														href="#tab_content1" id="home-tab" role="tab"
														data-toggle="tab" aria-expanded="true">내 일정</a></li>
													<li role="presentation" class=""><a
														href="#tab_content2" role="tab" id="profile-tab"
														data-toggle="tab" aria-expanded="false">내 부서 일정</a></li>
													
												</ul>


												<div id="myTabContent" class="tab-content">
													<div role="tabpanel" class="tab-pane fade active in"
														id="tab_content1" aria-labelledby="home-tab">
														내 일정탭으로 들어왔당
														<div id='calendar'></div>
													</div>
													<div role="tabpanel" class="tab-pane fade"
														id="tab_content2" aria-labelledby="profile-tab">
														내 부서 일정탭으로 들어왔당
														<div id='calendar'></div>
													</div>
													
												</div>
											</div>
											<!-- <div class="btn-group" role="group"
											aria-label="Button group with nested dropdown">
											<a href="#tab_content1" type="button" class="btn btn-default">내 일정</a>
											<a href="#tab_content2"type="button" class="btn btn-default">내 부서
												일정</a>
											<div class="btn-group" role="group">
												<div class="dropdown">
													<button class="btn btn-default dropdown-toggle"
														type="button" data-toggle="dropdown">
														부서 일정 <span class="caret"></span>
													</button>
													<ul class="dropdown-menu">
														<li><a href="#">영업부</a></li>
														<li><a href="#">회계부</a></li>
													</ul>
												</div>
											</div>
										</div> -->
											<!-- <div id="myTabContent"  class="tab-content">
											<div id="tab_conten1"style="padding: 10px;"></div>
											내 일정탭으로 들어왔당
											<div id='calendar'></div>
											<div id="tab_content2" style="padding: 10px;"></div>
											내 부서 일정탭으로 들어왔당
											<div id='calendar'></div>
										</div> -->
										</div>

										<div class="clearfix"></div>
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

			<!-- Start Calender modal -->
			<div id="CalenderModalNew" class="modal fade" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">

						<div id="modal-header" class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								<input type="text" style="width: 100%; border-style: none;"
									placeholder="일정 제목을 입력하세요.">
							</h4>
						</div>
						<div class="modal-body">
							<div id="testmodal" style="padding: 5px 20px;">
								<form id="antoform" class="form-horizontal calender" role="form">

									<div class="form-group">
										<label class="col-sm-3 control-label">날짜 </label>
										<div class="col-sm-9"
											style="height: 30px; display: flex; align-items: center; justify-content: left;">
											ex)208년 09월 20일</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">게시자 </label>
										<div class="col-sm-9"
											style="height: 30px; display: flex; align-items: center; justify-content: left;">
											ex)지은경</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">참석자 </label>
										<div class="col-sm-9"
											style="height: 33px; display: flex; align-items: center; justify-content: left;">
											<button id="attBtn" type="button"
												class="btn btn-success btn-xs"
												style="margin-top: auto; margin-bottom: auto;"
												data-toggle="modal" data-target="#myModal">참석자 검색</button>
										</div>

										<div class="modal fade" id="myModal" role="dialog"
											data-backdrop="static">
											<div class="modal-dialog" id="modal-dialog">

												<!-- Modal content-->
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal">&times;</button>
														<h4 class="modal-title">검색</h4>

													</div>
													<div class="modal-body">
														<div class="row">
															<div class="col-md-12 col-sm-12 col-xs-12">
																<div class="x_content">
																	<br />
																	<div class="col-md-12 col-sm-12 col-xs-12">
																		<div class="x_content">
																			<div class="input-group" style="width: 200px;">
																				<input type="text" class="form-control btn-round">
																				<span class="input-group-btn">
																					<button type="button"
																						class="btn btn-round btn-info" data-toggle="modal"
																						data-target="#myModal">검색</button>
																				</span>
																			</div>
																			<table
																				class="table table-striped responsive-utilities jambo_table bulk_action">
																				<thead>
																					<tr class="headings">
																						<th class="column-title">추가</th>
																						<th class="column-title">부서명</th>
																						<th class="column-title">이름</th>
																						<th class="column-title">직위</th>
																						<th class="column-title">직책</th>
																						<th class="column-title">전화번호</th>
																						<th class="column-title">메일 주소</th>

																						<th class="bulk-actions" colspan="7"><a
																							class="antoo"
																							style="color: #fff; font-weight: 500;">Bulk
																								Actions ( <span class="action-cnt"> </span> ) <i
																								class="fa fa-chevron-down"></i>
																						</a></th>
																					</tr>
																				</thead>

																				<tbody>
																					<tr class="odd pointer">
																						<td class="a-center "><input type="checkbox"
																							class="flat" name="table_records"></td>
																						<td class=" ">개발1팀</td>
																						<td class=" ">채은비</td>
																						<td class=" ">대리</td>
																						<td class=" "></td>
																						<td class=" ">010-1234-1234</td>
																						<td class="a-right a-right ">eb0916@kh.com</td>
																					</tr>
																				</tbody>

																			</table>
																		</div>
																	</div>
																</div>

															</div>
														</div>
													</div>
													<div align="right">
														<button type="button" class="btn btn-primary">참석자에
															추가하기</button>
														<button type="button" class="btn btn-default"
															data-toggle="modal" data-target="#myModal">취소</button>
													</div>
												</div>

											</div>

										</div>


									</div>
									<div class="form-group" id="attSearch">
										<div id="attSearchDiv" class="col-sm-9"
											style="width: 300px; height: 120px;"></div>
									</div>


									<div class="form-group">
										<label class="col-sm-3 control-label">메모</label>
										<div class="col-sm-9">
											<textarea id="content" name="content"
												style="min-height: 120px; width: 300px;"></textarea>
										</div>
									</div>

								</form>
							</div>
						</div>
						<hr />
						<div align="right">
							<button type="button" class="btn btn-primary"
								data-dismiss="modal">일정 추가</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">취소</button>
						</div>
					</div>
				</div>
			</div>
			<div id="CalenderModalEdit" class="modal fade" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">

						<div class="modal-header">
							<div style="width: 100%" align="right">
								<a style="margin-right: 7px; margin-top: 2px;"><i
									class="fa fa-edit fa-lg"></i></a> <a style="margin-right: 10px;"><i
									class="fa fa-trash fa-lg"></i></a>
							</div>
							<h4 class="modal-title" id="myModalLabel2">일정 제목</h4>
						</div>

						<div class="modal-body">
							<div class="modal-body">
								<div id="testmodal" style="padding: 5px 20px;">
									<form id="antoform" class="form-horizontal calender"
										role="form">

										<div class="form-group">
											<label class="col-sm-3 control-label">날짜 </label>
											<div class="col-sm-9"
												style="height: 30px; display: flex; align-items: center; justify-content: left;">
												ex)208년 09월 20일 9:00 ~ 11:00</div>
										</div>

										<div class="form-group">
											<label class="col-sm-3 control-label">게시자 </label>
											<div class="col-sm-9"
												style="height: 30px; display: flex; align-items: center; justify-content: left;">
												ex)지은경</div>
										</div>

										<div class="form-group">
											<label class="col-sm-3 control-label">참석자 </label>
											<div id="attSearchDiv2" class="col-sm-9"
												style="width: 300px; height: 100px;">ex)박필, 채은비, 정경덕,
												신재원, 김지황</div>
										</div>



										<div class="form-group">
											<label class="col-sm-3 control-label">메모</label>
											<div class="col-sm-9">
												<textarea id="content" name="content"
													style="height: 100px; width: 300px; padding: 0px; word-break: break-all; border-style: none;"
													readonly>ex)내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용</textarea>
											</div>
										</div>

									</form>
								</div>
							</div>
							<hr />
							<div align="right">
								<button type="button" class="btn btn-primary"
									data-dismiss="modal">수정</button>
								<button type="button" class="btn btn-default"
									data-dismiss="modal">닫기</button>
							</div>
						</div>
					</div>
				</div>
				<!-- <div id="testmodal2" style="padding: 5px 20px;">
								<form id="antoform2" class="form-horizontal calender"
									role="form">
									<div class="form-group">
										<label class="col-sm-3 control-label"><h3>제목</h3></label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="title2"
												name="title2">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">Description</label>
										<div class="col-sm-9">
											<textarea class="form-control" style="height: 55px;"
												id="descr2" name="descr"></textarea>
										</div>
									</div>

								</form>
							</div> -->
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default antoclose2"
					data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary antosubmit2">Save
					changes</button>
			</div>
		</div>
	</div>
	</div>

	<div id="fc_create" data-toggle="modal" data-target="#CalenderModalNew"></div>
	<div id="fc_edit" data-toggle="modal" data-target="#CalenderModalEdit"></div>

	<!-- End Calender modal -->
	<script src="${contextPath }/resources/js/bootstrap.min.js"></script>
	<script src="${contextPath }/resources/js/moment/moment.min.js"></script>
	<script src="${contextPath }/resources/js/calendar/fullcalendar.min.js"></script>
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

	<!-- flot js -->
	<!--[if lte IE 8]><script type="text/javascript" src="js/excanvas.min.js"></script><![endif]-->
	<script type="text/javascript"
		src="${contextPath }/resources/js/flot/jquery.flot.js"></script>
	<script type="text/javascript"
		src="${contextPath }/resources/js/flot/jquery.flot.pie.js"></script>
	<script type="text/javascript"
		src="${contextPath }/resources/js/flot/jquery.flot.orderBars.js"></script>
	<script type="text/javascript"
		src="${contextPath }/resources/js/flot/jquery.flot.time.min.js"></script>
	<script type="text/javascript"
		src="${contextPath }/resources/js/flot/date.js"></script>
	<script type="text/javascript"
		src="${contextPath }/resources/js/flot/jquery.flot.spline.js"></script>
	<script type="text/javascript"
		src="${contextPath }/resources/js/flot/jquery.flot.stack.js"></script>
	<script type="text/javascript"
		src="${contextPath }/resources/js/flot/curvedLines.js"></script>
	<script type="text/javascript"
		src="${contextPath }/resources/js/flot/jquery.flot.resize.js"></script>
	<script>
		$(window).load(function() {

			var date = new Date();
			var d = date.getDate();
			var m = date.getMonth();
			var y = date.getFullYear();
			var started;
			var categoryClass;

			var calendar = $('#calendar').fullCalendar({
				header : {
					left : 'prev,next today',
					center : 'title',
					right : 'month,agendaWeek,agendaDay'
				},
				selectable : true,
				selectHelper : true,
				select : function(start, end, allDay) {
					$('#fc_create').click();

					started = start;
					ended = end

					$(".antosubmit").on("click", function() {
						var title = $("#title").val();
						if (end) {
							ended = end
						}
						categoryClass = $("#event_type").val();

						if (title) {
							calendar.fullCalendar('renderEvent', {
								title : title,
								start : started,
								end : end,
								allDay : allDay
							}, true // make the event "stick"
							);
						}
						$('#title').val('');
						calendar.fullCalendar('unselect');

						$('.antoclose').click();

						return false;
					});
				},
				eventClick : function(calEvent, jsEvent, view) {
					/* alert(calEvent.title, jsEvent, view); */

					$('#fc_edit').click();
					$('#title2').val(calEvent.title);
					categoryClass = $("#event_type").val();
					$(".antosubmit2").on("click", function() {
						calEvent.title = $("#title2").val();

						calendar.fullCalendar('updateEvent', calEvent);
						$('.antoclose2').click();
					});
					calendar.fullCalendar('unselect');
				},
				editable : true,
				events : [ {
					title : 'All Day Event',
					start : new Date(y, m, 1)
				}, /*{
													   title: 'Long Event',
													   start: new Date(y, m, d - 5),
													   end: new Date(y, m, d - 2)
													 }, {
													   title: 'Meeting',
													   start: new Date(y, m, d, 10, 30),
													   allDay: false
													 }, {
													   title: 'Lunch',
													   start: new Date(y, m, d + 14, 12, 0),
													   end: new Date(y, m, d, 14, 0),
													   allDay: false
													 }, {
													   title: 'Birthday Party',
													   start: new Date(y, m, d + 1, 19, 0),
													   end: new Date(y, m, d + 1, 22, 30),
													   allDay: false
													 }, {
													   title: 'Click for Google',
													   start: new Date(y, m, 28),
													   end: new Date(y, m, 29),
													   url: 'http://google.com/'
													 }*/]
			});
		});
	</script>
</body>

</html>