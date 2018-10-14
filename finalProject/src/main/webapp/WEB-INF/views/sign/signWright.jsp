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
	<link href="${contextPath }/resources/css/floatexamples.css" rel="stylesheet" type="text/css" />
	<link href="${contextPath }/resources/css/calendar/fullcalendar.css" rel="stylesheet">
  	<link href="${contextPath }/resources/css/calendar/fullcalendar.print.css" rel="stylesheet" media="print">
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

					<jsp:include page="../common/sidebar.jsp"/>


			<!-- page content -->
      <div class="right_col" role="main">

        <div class="">
          <div class="page-title">
            <div class="title_left">
              <h3>DBDBDep</h3>
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
                  <h2>전자결재 <small>기안하기</small></h2>
                  <div class="clearfix"></div>
                </div>
                <div class="x_content">
                  <!-- Smart Wizard -->
                  <div id="wizard" class="form_wizard wizard_horizontal">
                    <ul class="wizard_steps">
                      <li>
                        <a href="#step-1">
                          <span class="step_no">1</span>
                          <span class="step_descr">
                                            	1. 작성 <br />
                                            <small>문서를 작성하세요</small>
                                        </span>
                        </a>
                      </li>
                      <li>
                        <a href="#step-2">
                          <span class="step_no">2</span>
                          <span class="step_descr">
                                            2. 결재선 관리<br />
                                            <small>결재선 및 수신참조자를 설정하세요</small>
                                        </span>
                        </a>
                      </li>
                      <li>
                        <a href="#step-3">
                          <span class="step_no">3</span>
                          <span class="step_descr">
                                            3. 상신 전 확인<br />
                                            <small>작성한 문서를 확인하세요</small>
                                        </span>
                        </a>
                      </li>
                    </ul>
                   <form class="form-horizontal form-label-left" id="signForm" action="insertSign.sg" method="post">
                    <div id="step-1">
						<h2 class="StepTitle">문서 작성</h2>
						<textarea id="summernote" name="signContent" required>
							
						</textarea>
						<input type="file" name="signFile"/>
                    </div>
                    <div id="step-2">
                    <h2 class="StepTitle">결재선 지정<small>(먼저 선택하신 분이 최종 결재자입니다.)</small></h2>
                       <div class="clearfix"></div>

            <div class="col-md-12 col-sm-12 col-xs-16">
              <div class="x_panel">
                <div class="x_content">
                    <!-- required for floating -->
                    <!-- Nav tabs -->
                    <br><br>
                    
				<script>
					$(function(){
						$("#depList").change(function(){
							var depName = $("#depList option:selected").val();
							console.log(depName);
							$.ajax({
								url : "depEmpSelect.sg",
								data : {depName : depName},
								success : function(data){
									var $tbody = $('.depMemberList');
									$tbody.html("");
									var i = 0;
									$.each(data, function(index, val){
										var ename = decodeURIComponent(val.empName);
										var $tr = $("<tr role='row' class='odd'>");
										var $empNo = $('<td>').text(decodeURIComponent(val.empNo));
										var $empName = $('<td class="ename">').text(decodeURIComponent(val.empName));
										var $depName = $('<td>').text(decodeURIComponent(val.depName));
										var $jobName = $('<td>').text(decodeURIComponent(val.jobName));
										var $positionName = $('<td>').text(decodeURIComponent(val.positionName));
										var $appButton = $('<td>').html('<button type="button" class="btn btn-default btn-xs appBtn">결재선에 추가</button>');
										var $recButton = $('<td>').html('<button type="button" class="btn btn-default btn-xs recBtn">수신참조자에 추가</button>');
										var $hidden = $('<input type="hidden" value="'+ename+'">'); 
										
										$tr.append($hidden);
										$tr.append($empNo);
										$tr.append($empName);
										$tr.append($depName);
										$tr.append($jobName);
										$tr.append($positionName);
										$tr.append($appButton);
										$tr.append($recButton);
										$tbody.append($tr);
										
									})
										$(function(){
									        $(".appBtn").click(function(){
									        	var $appBody = $('.appTable');
									        	var $appTr = $('<tr role="row" class="odd">');
									        	var appName = $(this).parent().parent().children('input').val();
									        	var $appName = $('<td rowspan>').text(appName);
									        	$appTr.append($appName);
									        	$appBody.append($appTr);
									        });
								        });
										$(function(){
									        $(".recBtn").click(function(){
									        	var $recBody = $('.recTable');
									        	var $recTr = $('<tr role="row" class="odd">');
									        	var recName = $(this).parent().parent().children('input').val();
									        	var $recName = $('<td rowspan>').text(recName);
									        	$recTr.append($recName);
									        	$recBody.append($recTr);
									        });
								        });
										
								},
								error : function(){
									
								}
							});
							
						});
					});
					
			        
			        
			        
			        
			        
				</script>

                  <div class="col-xs-12">
                    <!-- Tab panes -->
                    <div class="tab-content">
                      <div class="tab-pane active" id="home">
                <div class="x_title">
                  <select id="depList">
                  	<option>====</option>
					<option>인사부</option>
					<option>회계부</option>
					<option>총무부</option>
					<option>영업부</option>
				  </select>
				  <button type="button" onclick="resetApp();" class="btn btn-default btn-xs">결재선 및 수신 참조자 재설정</button>
				  <script>
				  	function resetApp(){
				  		
				  	}
				  </script>
                  <div class="clearfix"></div>
                </div>
				
                <div class="clearfix"></div>

          <div class="row">
			
            <div class="col-md-12 col-sm-12 col-xs-12">
              <div class="x_panel">
                <div class="x_content">
                  
                  <table class="table table-bordered">
                    <thead>
                      <tr>
                      	<th>사원번호</th>
                        <th>이름</th>
                        <th>부서명</th>
                        <th>직급</th>
                        <th>직책</th>
                        <th>결재선에 추가</th>
                        <th>수신 참조자에 추가</th>
                      </tr>
                    </thead>
                    <tbody class="depMemberList">
                    </tbody>
                  </table>
                  
                </div>
            <div class="col-xs-3">
            <table class="table table-bordered">
	      		<thead>
	               <tr>
	               	<th>결&nbsp;&nbsp;재&nbsp;&nbsp;자</th>
	               </tr>
	             </thead>
	             <tbody class="appTable">
	             </tbody>
	        </table>
	        </div>
	        <div class="col-xs-3">
	        <table class="table table-bordered">
	      		<thead>
	               <tr>
	                <th>수신참조자</th>
	               </tr>
	             </thead>
	             <tbody class="recTable">
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
                    <div id="step-3">
                      <h2 class="StepTitle">확인</h2>
                      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                        Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                      </p>
                      <p>
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor
                        in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                      </p>
                      <p>
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor
                        in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                      </p>
            </div>
            
                    </form>
					</div>
            		</div>
                  </div>
                  <!-- End SmartWizard Content -->
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
	<script>
             $(document).ready(function() {
         	  	 var fileExtension = ['.jpg', '.png', '.jpeg', '.gif',];
                $('#summernote').summernote({ // summernote를 사용하기 위한 선언
                    height: 500,
                    lang: 'ko-KR',
                    toolbar: [
                        // [groupName, [list of button]]
                        ['style', ['bold', 'italic', 'underline', 'clear']],
                        ['font', ['strikethrough', 'superscript', 'subscript']],
                        ['fontsize', ['fontname', 'fontsize']],
                        ['color', ['color']],
                        ['para', ['ul', 'ol', 'paragraph']],
                        ['height', ['height']],
                        ['insert', ['table', 'hr']]
                      ],
	                callbacks: { // 콜백을 사용
                        // 이미지를 업로드할 경우 이벤트를 발생
                   onImageUpload: function(files, editor, welEditable) {
                       console.log(files);
                         
                         for (var i = files.length - 1; i >= 0; i--) {
                        	 
                         	for(var j = 0; j < fileExtension.length; j++){
                         		var extleng = files[i].name.length;
                         		var extdot = files[i].name.lastIndexOf('.');
                         		var ext = files[i].name.substring(extdot, extleng).toLowerCase();

                        		 console.log(ext + ' / ' + fileExtension[j]) 
                        	 if(ext == fileExtension[j]){
                     		  sendFile(files[i], this); 
                         	}
                            }
                         }
                  },
                  onMediaDelete : function(target) {
                      alert(target[0].src);
                      deleteFile(target[0].src);
                      console.log(target[0].src)
               }
            }});
         }); 


    </script>
	<link href="${contextPath }/resources/css/summernote.css" rel="stylesheet">
	<script src="${contextPath }/resources/js/summernote.js"></script>
	<script src="${contextPath }/resources/js/bootstrap.min.js"></script>
	<script src="${contextPath }/resources/js/moment/moment.min.js"></script>
	<script src="${contextPath }/resources/js/calendar/fullcalendar.min.js"></script>
	<!-- gauge js -->
	<script type="text/javascript" src="${contextPath }/resources/js/gauge/gauge.min.js"></script>
	<script type="text/javascript" src="${contextPath }/resources/js/gauge/gauge_demo.js"></script>
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
	<!-- form wizard -->
  	<script type="text/javascript" src="${contextPath }/resources/js/wizard/jquery.smartWizard.js"></script>
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
	<!-- pace -->
        <script src="js/pace/pace.min.js"></script>
        <script>
          var handleDataTableButtons = function() {
              "use strict";
              0 !== $("#datatable-buttons").length && $("#datatable-buttons").DataTable({
                dom: "Bfrtip",
                buttons: [{
                  extend: "copy",
                  className: "btn-sm"
                }, {
                  extend: "csv",
                  className: "btn-sm"
                }, {
                  extend: "excel",
                  className: "btn-sm"
                }, {
                  extend: "pdf",
                  className: "btn-sm"
                }, {
                  extend: "print",
                  className: "btn-sm"
                }],
                responsive: !0
              })
            },
            TableManageButtons = function() {
              "use strict";
              return {
                init: function() {
                  handleDataTableButtons()
                }
              }
            }();
        </script>
		<script>
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
	<!-- /footer content -->
</body>
<script type="text/javascript">
    $(document).ready(function() {
      // Smart Wizard
      $('#wizard').smartWizard();

      function onFinishCallback() {
        $('#wizard').smartWizard('showMessage', 'Finish Clicked');
        alert('Finish Clicked');
        console.log('클릭');
      }
    });

    $(document).ready(function() {
      // Smart Wizard
      $('#wizard_verticle').smartWizard({
        transitionEffect: 'slide'
      });

    });
  </script>
  
  
</html>
