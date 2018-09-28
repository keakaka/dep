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

	<title>Gentallela Alela! | </title>

	<!-- Bootstrap core CSS -->
	<link href="${contextPath }/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="${contextPath }/resources/fonts/css/font-awesome.min.css" rel="stylesheet">
	<link href="${contextPath }/resources/css/animate.min.css" rel="stylesheet">
	<!-- Custom styling plus plugins -->
	<link href="${contextPath }/resources/css/custom.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${contextPath }/resources/css/maps/jquery-jvectormap-2.0.3.css" />
	<link href="${contextPath }/resources/css/icheck/flat/green.css" rel="stylesheet" />
	<script src="${contextPath }/resources/js/jquery.min.js"></script>
	<link href="${contextPath }/resources/js/datatables/responsive.bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="${contextPath }/resources/js/datatables/jquery.dataTables.min.css" rel="stylesheet" type="text/css" />
	<link href="${contextPath }/resources/js/datatables/buttons.bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="${contextPath }/resources/js/datatables/fixedHeader.bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="${contextPath }/resources/js/datatables/responsive.bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="${contextPath }/resources/js/datatables/scroller.bootstrap.min.css" rel="stylesheet" type="text/css" />
	
</head>


<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">

					<jsp:include page="../common/sidebar.jsp"/>


			<!-- page content -->
      <div class="right_col" role="main">
        <div class="">
          <div class="page-title">
            <div class="title_left">
              <h3>
                    	결재함
                    <small>
                        	결재 대기 / 상신한 결재문서
                    </small>
                </h3>
            </div>

            <div class="title_right">
              <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
              </div>
            </div>
          </div>
          <div class="clearfix"></div>

          <div class="row">

            <div class="col-md-12 col-sm-12 col-xs-12">
              <div class="x_panel">
                <div class="x_title">
                  <h2>결재 대기 중</h2>
                  <div class="clearfix"></div>
                </div>
                <div class="x_content">
                  <table id="datatable" class="table table-striped table-bordered">
                    <thead>
                      <tr>
                        <th>Name</th>
                        <th>Position</th>
                        <th>Office</th>
                        <th>Age</th>
                        <th>Start date</th>
                        <th>Salary</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>Tiger Nixon</td>
                        <td>System Architect</td>
                        <td>Edinburgh</td>
                        <td>61</td>
                        <td>2011/04/25</td>
                        <td>$320,800</td>
                      </tr>
                      
                      <tr>
                        <td>Caesar Vance</td>
                        <td>Pre-Sales Support</td>
                        <td>New York</td>
                        <td>21</td>
                        <td>2011/12/12</td>
                        <td>$106,450</td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
            
            <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                      <div class="x_title">
                        <h2>내가 올린 결재 </h2>
                        <div class="clearfix"></div>
                      </div>
                      <div class="x_content">
                        <table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
                          <thead>
                            <tr>
                              <th>First name</th>
                              <th>Last name</th>
                              <th>Position</th>
                              <th>Office</th>
                              <th>Age</th>
                              <th>Start date</th>
                              <th>Salary</th>
                              <th>Extn.</th>
                              <th>E-mail</th>
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                              <td>Tiger</td>
                              <td>Nixon</td>
                              <td>System Architect</td>
                              <td>Edinburgh</td>
                              <td>61</td>
                              <td>2011/04/25</td>
                              <td>$320,800</td>
                              <td>5421</td>
                              <td>t.nixon@datatables.net</td>
                            </tr>
                            <tr>
                              <td>Garrett</td>
                              <td>Winters</td>
                              <td>Accountant</td>
                              <td>Tokyo</td>
                              <td>63</td>
                              <td>2011/07/25</td>
                              <td>$170,750</td>
                              <td>8422</td>
                              <td>g.winters@datatables.net</td>
                            </tr>
                            <tr>
                              <td>Tiger</td>
                              <td>Nixon</td>
                              <td>System Architect</td>
                              <td>Edinburgh</td>
                              <td>61</td>
                              <td>2011/04/25</td>
                              <td>$320,800</td>
                              <td>5421</td>
                              <td>t.nixon@datatables.net</td>
                            </tr>
                            <tr>
                              <td>Tiger</td>
                              <td>Nixon</td>
                              <td>System Architect</td>
                              <td>Edinburgh</td>
                              <td>61</td>
                              <td>2011/04/25</td>
                              <td>$320,800</td>
                              <td>5421</td>
                              <td>t.nixon@datatables.net</td>
                            </tr>
                            <tr>
                              <td>Tiger</td>
                              <td>Nixon</td>
                              <td>System Architect</td>
                              <td>Edinburgh</td>
                              <td>61</td>
                              <td>2011/04/25</td>
                              <td>$320,800</td>
                              <td>5421</td>
                              <td>t.nixon@datatables.net</td>
                            </tr>
                            <tr>
                              <td>Tiger</td>
                              <td>Nixon</td>
                              <td>System Architect</td>
                              <td>Edinburgh</td>
                              <td>61</td>
                              <td>2011/04/25</td>
                              <td>$320,800</td>
                              <td>5421</td>
                              <td>t.nixon@datatables.net</td>
                            </tr>
                            
                          </tbody>
                        </table>

                      </div>
                    </div>
                  </div>
            </div>
            </div>
            </div>
            
				<!-- footer content -->

				<footer>
					<div class="copyright-info">
						<p class="pull-right">Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>		
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
		<ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group">
		</ul>
		<div class="clearfix"></div>
		<div id="notif-group" class="tabbed_notifications"></div>
	</div>
	
	
	
	<script type="text/javascript">
          $(document).ready(function() {
            $('#datatable').dataTable();
            $('#datatable-keytable').DataTable({
              keys: true
            });
            $('#datatable-responsive').DataTable();
            $('#datatable-scroller').DataTable({
              ajax: "js/datatables/json/scroller-demo.json",
              deferRender: true,
              scrollY: 380,
              scrollCollapse: true,
              scroller: true
            });
            var table = $('#datatable-fixed-header').DataTable({
              fixedHeader: true
            });
          });
          TableManageButtons.init();
    </script>
    <!-- Datatables-->
    <script src="${contextPath }/resources/js/datatables/jquery.dataTables.min.js"></script>
    <script src="${contextPath }/resources/js/datatables/dataTables.bootstrap.js"></script>
    <script src="${contextPath }/resources/js/datatables/dataTables.buttons.min.js"></script>
    <script src="${contextPath }/resources/js/datatables/buttons.bootstrap.min.js"></script>
    <script src="${contextPath }/resources/js/datatables/jszip.min.js"></script>
    <script src="${contextPath }/resources/js/datatables/pdfmake.min.js"></script>
    <script src="${contextPath }/resources/js/datatables/vfs_fonts.js"></script>
    <script src="${contextPath }/resources/js/datatables/buttons.html5.min.js"></script>
    <script src="${contextPath }/resources/js/datatables/buttons.print.min.js"></script>
    <script src="${contextPath }/resources/js/datatables/dataTables.fixedHeader.min.js"></script>
    <script src="${contextPath }/resources/js/datatables/dataTables.keyTable.min.js"></script>
    <script src="${contextPath }/resources/js/datatables/dataTables.responsive.min.js"></script>
    <script src="${contextPath }/resources/js/datatables/responsive.bootstrap.min.js"></script>
    <script src="${contextPath }/resources/js/datatables/dataTables.scroller.min.js"></script>
    
	<script src="${contextPath }/resources/js/bootstrap.min.js"></script>
	<!-- gauge js -->
	<script type="text/javascript" src="${contextPath }/resources/js/gauge/gauge.min.js"></script>
	<script type="text/javascript" src="${contextPath }/resources/js/gauge/gauge_demo.js"></script>
	<!-- bootstrap progress js -->
	<script src="${contextPath }/resources/js/nicescroll/jquery.nicescroll.min.js"></script>
	<!-- icheck -->
	<script src="${contextPath }/resources/js/icheck/icheck.min.js"></script>

	<script src="${contextPath }/resources/js/custom.js"></script>

	
	<!-- /footer content -->
</body>

</html>
