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


</head>
<style>

</style>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">

					<jsp:include page="../common/sidebar.jsp" />
					
					<div class="right_col" role="main" align="center">
						<div class="content" style="width:60%;">
							<div class="header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">참석자 검색</h4>
							</div>
							<div class="body">
								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">
										<div class="x_content">
											<br />
											<div class="col-md-12 col-sm-12 col-xs-12">
												<div class="x_content" align="left">
														<form action="/searchMemberByName.ca"
															method="post" name="name_search_form"
															onsubmit="return nameSearchFormCheck()">
															<div class="input-group" style="width: 200px;">
																<input type="text" name="name" class="form-control btn-round">
																<span class="input-group-btn">
																	<input type="submit" class="btn btn-round btn-info" value="검색">
																</span>
															</div>
														</form>
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
																	class="antoo" style="color: #fff; font-weight: 500;">Bulk
																		Actions ( <span class="action-cnt"> </span> ) <i
																		class="fa fa-chevron-down"></i>
																</a></th>
															</tr>
														</thead>

														<tbody>

														</tbody>

													</table>
												</div>
											</div>
										</div>

									</div>
								</div>
							</div>
							<div align="right">
								<button type="button" class="btn btn-primary">참석자에 추가하기</button>
								<button type="button" class="btn btn-default"
									data-toggle="modal" data-target="#myModal">취소</button>
							</div>
						</div>


					</div>
				</div>
			</div>
		</div>
	</div>

</body>


</html>