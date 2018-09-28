<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
									<div class="x_title">
										<h2>주소록</h2>
										<div class="clearfix"></div>
									</div>
									<div class="form-group">
										<div class="col-sm-9" style="width: 30%;">
											<div class="input-group">
												<input type="text" class="form-control btn-round"> <span
													class="input-group-btn">
													<button type="button" class="btn btn-round btn-info"
														data-toggle="modal" data-target="#myModal">검색</button>
												</span>
											</div>
										</div>

										<!-- Modal -->
										<div class="modal fade" id="myModal" role="dialog"
											data-backdrop="static">
											<div class="modal-dialog">

												<!-- Modal content-->
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal">&times;</button>
														<h4 class="modal-title">검색한 사람들 정보 List</h4>
													</div>
													<div class="modal-body">
														<div class="row">

															<div class="col-md-6 col-sm-6 col-xs-12">
																<div class="x_panel" style="width: 565px;">
																	<div class="x_title">

																		<div class="clearfix"></div>
																	</div>
																	<div class="x_content">

																		<table class="table">
																			<thead>
																				<tr>
																					<th></th>
																					<th>부서명</th>
																					<th>이름</th>
																					<th>직위</th>
																					<th>직책</th>
																					<th>전화번호</th>
																					<th>메일주소</th>
																				</tr>
																			</thead>
																			<tbody>
																				<tr>
																					<td class="a-center "><input type="checkbox"
																						class="flat" name="table_records"></td>
																					<td>개발1팀</td>
																					<td>채은비</td>
																					<td>대리</td>
																					<td></td>
																					<td>010-1234-1234</td>
																					<td>eb0916@kh.com</td>
																				</tr>
																				<tr>
																					<td class="a-center "><input type="checkbox"
																						class="flat" name="table_records"></td>
																					<td>개발1팀</td>
																					<td>채은비</td>
																					<td>대리</td>
																					<td></td>
																					<td>010-1234-1234</td>
																					<td>eb0916@kh.com</td>
																				</tr>
																			</tbody>
																		</table>

																	</div>
																</div>
															</div>
														</div>
														<div align="right">
															<button type="button" class="btn btn-primary"
																data-dismiss="modal">주소록에 추가 하기</button>
															<button type="button" class="btn btn-default"
																data-dismiss="modal">취소</button>
														</div>
													</div>

												</div>

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

														<!-- <th class="bulk-actions" colspan="7"><a class="antoo"
								style="color: #fff; font-weight: 500;">Bulk Actions ( <span
									class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
							</th> -->
													</tr>
												</thead>
												<th></th>
												<th class="column-title">예시1</th>
												<th class="column-title">예시1</th>
												<th class="column-title">예시1</th>
												<th class="column-title">예시1</th>
												<th class="column-title">예시1</th>
												<th class="column-title">예시1</th>
												<tbody>

												</tbody>

											</table>
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