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
											<h3>
												Empty <small>no content</small>
											</h3>
										</div>
										<div class="col-md-6"></div>
									</div>

									<div class="col-md-12 col-sm-12 col-xs-12">
										<div id='calendar'></div>
									</div>

									<div class="clearfix">
										<div class="container">
											
											<h2>Large Modal</h2>
											<!-- Trigger the modal with a button -->
											<button type="button" class="btn btn-info btn-lg"
												data-toggle="modal" data-target="#myModal">쪽지</button>

											<!-- Modal -->
											<div class="modal fade" id="myModal" role="dialog">
												<div class="modal-dialog modal-lg">
													<div class="modal-content">
														<div class="modal-header">
															<button type="button" class="close" data-dismiss="modal">&times;</button>
															<h4 class="modal-title">쪽지함</h4>
														</div>
														<div class="modal-body">
															
															<div class="x_panel">
                <div class="x_title">
                  <h2><i class="fa fa-bars"></i> 쪽지함 <small>Float left</small></h2>
            
                  <div class="clearfix"></div>
                </div>
                <div class="x_content">

                  <div class="" role="tabpanel" data-example-id="togglable-tabs">
                    <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
                      <li role="presentation" class="active"><a href="#tab_content1" id="home-tab" role="tab" data-toggle="tab" aria-expanded="true">쪽지보내기</a>
                      </li>
                      <li role="presentation" class=""><a href="#tab_content2" role="tab" id="profile-tab" data-toggle="tab" aria-expanded="false">보낸쪽지함</a>
                      </li>
                      <li role="presentation" class=""><a href="#tab_content3" role="tab" id="profile-tab2" data-toggle="tab" aria-expanded="false">받은쪽지함</a>
                      </li>
                   <!--    <li role="presentation" class=""><a href="#tab_content4" role="tab" id="profile-tab3" data-toggle="tab" aria-expanded="false">휴지통</a>
                      </li> -->
                      
                    </ul>
                    <div id="myTabContent" class="tab-content">
                      <div role="tabpanel" class="tab-pane fade active in" id="tab_content1" aria-labelledby="home-tab">
                        
                        <div class="col-md-18 col-sm-18 col-xs-18">
              			<div class="x_panel">
                
                        <p>
						
						<!-- 부서 -->
						<label for="heard">부서</label>
                        <select id="heard" class="form-control" required>
                          <option value="">인사과</option>
                     	  <option value="">총무과</option>
                          <option value="">영업부</option>
                     
                        </select>
						<br>
						<!-- 사원명 -->
                        <label for="heard">사원</label>
                        <select id="heard" class="form-control" required>
                          <option value="">Choose..</option>
                          <option value="press">Press</option>
                          <option value="net">Internet</option>
                          <option value="mouth">Word of mouth</option>
                        </select>
						
						<br><br>
						
                        <label for="message">Message (20 chars min, 100 max) :</label>
                        <textarea id="message" required="required" class="form-control" name="message" data-parsley-trigger="keyup" data-parsley-minlength="20" data-parsley-maxlength="100" data-parsley-minlength-message="Come on! You need to enter at least a 20 caracters long comment.."
                          data-parsley-validation-threshold="10"></textarea>

                        <br/>
                        <button class="btn btn-primary">보내기</button>

						</p>
					  </div>
					  </div>
                      </div>
                      
                      
            <div role="tabpanel" class="tab-pane fade" id="tab_content2" aria-labelledby="profile-tab">
                      				
	         <div class="col-md-18 col-sm-18 col-xs-18">
              <div class="x_panel">
                <div class="x_title">
                  <h2>보낸쪽지함 <small>Users</small></h2>
                  <ul class="nav navbar-right panel_toolbox">
                    <li><a href="#"><i class="fa fa-chevron-up"></i></a>
                    </li>
                    <li class="dropdown">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                      <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Settings 1</a>
                        </li>
                        <li><a href="#">Settings 2</a>
                        </li>
                      </ul>
                    </li>
                    <li><a href="#"><i class="fa fa-close"></i></a>
                    </li>
                  </ul>
                  <div class="clearfix"></div>
                </div>
                <div class="x_content">
                  <div class="row">
                    <div class="col-sm-12">
                      <div class="card-box table-responsive">
                        <p class="text-muted font-13 m-b-30">
                        </p>

                        <table id="datatable-keytable" class="table table-striped table-bordered">
                          <thead>
                            <tr>
                              <th>보낸사람</th>
                              <th>제목</th>
                              <th>받은날짜</th>
                              <th>삭제</th>
                        
                            </tr>
                          </thead>


                          <tbody>
                            <tr>
                              <td>Brielle Williamson</td>
                              <td>Integration Specialist</td>
                              <td>New York</td>
                              <td><button>삭제하기</button></td>
                           
                            </tr>
                          
                           
                          </tbody>
                        </table>
                      </div>
                    </div>
                  </div>
                </div>

                </div>
                </div>
                </div>
                      <div role="tabpanel" class="tab-pane fade" id="tab_content3" aria-labelledby="profile-tab">
                       <p>보낸쪽지함입니다.</p>
                       <div class="col-md-18 col-sm-18 col-xs-18">
              <div class="x_panel">
                <div class="x_title">
                  <h2>받은쪽지함 <small>Users</small></h2>
                  <ul class="nav navbar-right panel_toolbox">
                    <li><a href="#"><i class="fa fa-chevron-up"></i></a>
                    </li>
                    <li class="dropdown">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                      <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Settings 1</a>
                        </li>
                        <li><a href="#">Settings 2</a>
                        </li>
                      </ul>
                    </li>
                    <li><a href="#"><i class="fa fa-close"></i></a>
                    </li>
                  </ul>
                  <div class="clearfix"></div>
                </div>
                <div class="x_content">
                  <div class="row">
                    <div class="col-sm-12">
                      <div class="card-box table-responsive">
                        <p class="text-muted font-13 m-b-30">
                        </p>

                        <table id="datatable-keytable" class="table table-striped table-bordered">
                          <thead>
                            <tr>
            				  <th>보낸사람</th>
                              <th>제목</th>
                              <th>받은날짜</th>
                              <th>삭제</th>
                            </tr>
                          </thead>


                          <tbody>
                            <tr>
                              <td>Brielle Williamson</td>
                              <td>Integration Specialist</td>
                              <td>New York</td>
                              <td><button class="btn btn-round btn-default">삭제하기</button></td>
                            </tr>
                          
                           
                          </tbody>
                        </table>
                      </div>
                    </div>
                  </div>
                </div>

                </div>
                </div>
                      </div>
      
                      </div>
                    </div>
                  </div>
															
															
															
														</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-default"
																data-dismiss="modal">Close</button>
														</div>
													</div>
												</div>
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


			<!-- /footer content -->
</body>

</html>
