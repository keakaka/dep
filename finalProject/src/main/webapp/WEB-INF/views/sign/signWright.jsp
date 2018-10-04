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
                                            	1. 양식 선택 <br />
                                            <small>양식을 선택하세요</small>
                                        </span>
                        </a>
                      </li>
                      <li>
                        <a href="#step-2">
                          <span class="step_no">2</span>
                          <span class="step_descr">
                                            2. 작성<br />
                                            <small>문서를 작성하세요</small>
                                        </span>
                        </a>
                      </li>
                      <li>
                        <a href="#step-3">
                          <span class="step_no">3</span>
                          <span class="step_descr">
                                            3. 수신 참조<br />
                                            <small>수신 참조자 추가</small>
                                        </span>
                        </a>
                      </li>
                      <li>
                        <a href="#step-4">
                          <span class="step_no">4</span>
                          <span class="step_descr">
                                            4. 확인<br />
                                            <small>상신 전 확인</small>
                                        </span>
                        </a>
                      </li>
                    </ul>
                    <div id="step-1" align="center">
						<div class="col-md-12 col-sm-12 col-xs-18" align="center">
		              <div class="x_panel" align="center">
		                <div class="x_title" align="center">
		                  <h2>양식 선택 <small>양식을 선택하세요</small></h2>
		                  <div class="clearfix" align="center"></div>
		                </div>
		                <button onclick="rtcOpen();">테스트</button>
		                <div class="x_content" align="center">
		                  <table class="table table-hover" align="center">
		                    <thead>
		                      <tr>
		                        <th>#</th>
		                        <th>First Name</th>
		                        <th>Last Name</th>
		                        <th>Username</th>
		                      </tr>
		                    </thead>
		                    <tbody>
		                      <tr>
		                        <th scope="row">1</th>
		                        <td>Mark</td>
		                        <td>Otto</td>
		                        <td>@mdo</td>
		                      </tr>
		                      <tr>
		                        <th scope="row">2</th>
		                        <td>Jacob</td>
		                        <td>Thornton</td>
		                        <td>@fat</td>
		                      </tr>
		                      <tr>
		                        <th scope="row">3</th>
		                        <td>Larry</td>
		                        <td>the Bird</td>
		                        <td>@twitter</td>
		                      </tr>
		                    </tbody>
		                  </table>

                </div>
              </div>
            </div>
                    </div>
                    <div id="step-2">
                      <h2 class="StepTitle">문서 작성</h2>
						<textarea id="summernote" name="proContent" required>
							
						</textarea>
						<input type="file" name="eSignFile"/>
                    </div>
                    <div id="step-3">
                      <h2 class="StepTitle">수신참조자 설정</h2>
                       <div class="clearfix"></div>

            <div class="col-md-12 col-sm-12 col-xs-16">
              <div class="x_panel">
                <div class="x_content">

                  <div class="col-xs-1">
                    <!-- required for floating -->
                    <!-- Nav tabs -->
                    <br><br>
                    <ul class="nav nav-tabs tabs-left">
                      <li class="active"><a href="#home" data-toggle="tab">인사관리부</a>
                      </li>
                      <li><a href="#profile" data-toggle="tab">회계부</a>
                      </li>
                      <li><a href="#messages" data-toggle="tab">영업부</a>
                      </li>
                      <li><a href="#settings" data-toggle="tab">비서실</a>
                      </li>
                    </ul>
                  </div>

                  <div class="col-xs-11">
                    <!-- Tab panes -->
                    <div class="tab-content">
                      <div class="tab-pane active" id="home">
                <div class="x_title">
                  <h2>부서명 <small>수신참조자 선택</small></h2>
                  <div class="clearfix"></div>
                </div>

                <div class="x_content">
                  <table class="table table-striped responsive-utilities jambo_table bulk_action">
                    <thead>
                      <tr class="headings">
                        <th>
                          <input type="checkbox" id="check-all" class="flat">
                        </th>
                        <th class="column-title"> 부서 </th>
                        <th class="column-title"> 이름 </th>
                        <th class="column-title no-link last"><span class="nobr"> 직급</span>
                        </th>
                        <th class="bulk-actions" colspan="7">
                          <a class="antoo" style="color:#fff; font-weight:500;">전원 선택 ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
                        </th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr class="even pointer">
                        <td class="a-center ">
                          <input type="checkbox" class="flat" name="table_records">
                        </td>
                        <td class=" ">name</td>
                        <td class="a-right a-right ">$7.45</td>
                        <td class=" last"><a href="#">View</a>
                        </td>
                      </tr>
                      <tr class="odd pointer">
                        <td class="a-center ">
                          <input type="checkbox" class="flat" name="table_records">
                        </td>
                        <td class=" ">name</td>
                        <td class="a-right a-right ">$741.20</td>
                        <td class=" last"><a href="#">View</a>
                        </td>
                      </tr>
                      <tr class="even pointer">
                        <td class="a-center ">
                          <input type="checkbox" class="flat" name="table_records">
                        </td>
                        <td class=" ">name</td>
                        <td class="a-right a-right ">$432.26</td>
                        <td class=" last"><a href="#">View</a>
                        </td>
                      </tr>
                      <tr class="odd pointer">
                        <td class="a-center ">
                          <input type="checkbox" class="flat" name="table_records">
                        </td>
                        <td class=" ">name</td>
                        <td class="a-right a-right ">$333.21</td>
                        <td class=" last"><a href="#">View</a>
                        </td>
                      </tr>
                      <tr class="even pointer">
                        <td class="a-center ">
                          <input type="checkbox" class="flat" name="table_records">
                        </td>
                        <td class=" ">Paid</td>
                        <td class="a-right a-right ">$7.45</td>
                        <td class=" last"><a href="#">View</a>
                        </td>
                      </tr>
                      <tr class="odd pointer">
                        <td class="a-center ">
                          <input type="checkbox" class="flat" name="table_records">
                        </td>
                        <td class=" ">name</td>
                        <td class="a-right a-right ">$741.20</td>
                        <td class=" last"><a href="#">View</a>
                        </td>
                      </tr>
                      <tr class="even pointer">
                        <td class="a-center ">
                          <input type="checkbox" class="flat" name="table_records">
                        </td>
                        <td class=" ">name</td>
                        <td class="a-right a-right ">$432.26</td>
                        <td class=" last"><a href="#">View</a>
                        </td>
                      </tr>
                      <tr class="odd pointer">
                        <td class="a-center ">
                          <input type="checkbox" class="flat" name="table_records">
                        </td>
                        <td class=" ">name</td>
                        <td class="a-right a-right ">$333.21</td>
                        <td class=" last"><a href="#">View</a>
                        </td>
                      </tr>

                      <tr class="even pointer">
                        <td class="a-center ">
                          <input type="checkbox" class="flat" name="table_records">
                        </td>
                        <td class=" ">Paid</td>
                        <td class="a-right a-right ">$7.45</td>
                        <td class=" last"><a href="#">View</a>
                        </td>
                      </tr>
                      <tr class="odd pointer">
                        <td class="a-center ">
                          <input type="checkbox" class="flat" name="table_records">
                        </td>
                        <td class=" ">Paid</td>
                        <td class="a-right a-right ">$741.20</td>
                        <td class=" last"><a href="#">View</a>
                        </td>
                      </tr>
                    </tbody>

                  </table>
                </div>
            </div>
            
                      <div class="tab-pane" id="profile">
                      <div class="x_title">
                  <h2>부서명 <small>수신참조자 선택</small></h2>
                  <div class="clearfix"></div>
                </div>

                <div class="x_content">
                  <table class="table table-striped responsive-utilities jambo_table bulk_action">
                    <thead>
                      <tr class="headings">
                        <th>
                          <input type="checkbox" id="check-all" class="flat">
                        </th>
                        <th class="column-title"> 부서 </th>
                        <th class="column-title"> 이름 </th>
                        <th class="column-title no-link last"><span class="nobr"> 직급</span>
                        </th>
                        <th class="bulk-actions" colspan="7">
                          <a class="antoo" style="color:#fff; font-weight:500;">전원 선택 ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
                        </th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr class="even pointer">
                        <td class="a-center ">
                          <input type="checkbox" class="flat" name="table_records">
                        </td>
                        <td class=" ">Paid</td>
                        <td class="a-right a-right ">$7.45</td>
                        <td class=" last"><a href="#">View</a>
                        </td>
                      </tr>
                      <tr class="odd pointer">
                        <td class="a-center ">
                          <input type="checkbox" class="flat" name="table_records">
                        </td>
                        <td class=" ">Paid</td>
                        <td class="a-right a-right ">$741.20</td>
                        <td class=" last"><a href="#">View</a>
                        </td>
                      </tr>
                      <tr class="even pointer">
                        <td class="a-center ">
                          <input type="checkbox" class="flat" name="table_records">
                        </td>
                        <td class=" ">Paid</td>
                        <td class="a-right a-right ">$432.26</td>
                        <td class=" last"><a href="#">View</a>
                        </td>
                      </tr>
                      <tr class="odd pointer">
                        <td class="a-center ">
                          <input type="checkbox" class="flat" name="table_records">
                        </td>
                        <td class=" ">Paid</td>
                        <td class="a-right a-right ">$333.21</td>
                        <td class=" last"><a href="#">View</a>
                        </td>
                      </tr>
                      <tr class="even pointer">
                        <td class="a-center ">
                          <input type="checkbox" class="flat" name="table_records">
                        </td>
                        <td class=" ">Paid</td>
                        <td class="a-right a-right ">$7.45</td>
                        <td class=" last"><a href="#">View</a>
                        </td>
                      </tr>
                      <tr class="odd pointer">
                        <td class="a-center ">
                          <input type="checkbox" class="flat" name="table_records">
                        </td>
                        <td class=" ">Paid</td>
                        <td class="a-right a-right ">$741.20</td>
                        <td class=" last"><a href="#">View</a>
                        </td>
                      </tr>
                      <tr class="even pointer">
                        <td class="a-center ">
                          <input type="checkbox" class="flat" name="table_records">
                        </td>
                        <td class=" ">Paid</td>
                        <td class="a-right a-right ">$432.26</td>
                        <td class=" last"><a href="#">View</a>
                        </td>
                      </tr>
                      <tr class="odd pointer">
                        <td class="a-center ">
                          <input type="checkbox" class="flat" name="table_records">
                        </td>
                        <td class=" ">Paid</td>
                        <td class="a-right a-right ">$333.21</td>
                        <td class=" last"><a href="#">View</a>
                        </td>
                      </tr>

                      <tr class="even pointer">
                        <td class="a-center ">
                          <input type="checkbox" class="flat" name="table_records">
                        </td>
                        <td class=" ">Paid</td>
                        <td class="a-right a-right ">$7.45</td>
                        <td class=" last"><a href="#">View</a>
                        </td>
                      </tr>
                      <tr class="odd pointer">
                        <td class="a-center ">
                          <input type="checkbox" class="flat" name="table_records">
                        </td>
                        <td class=" ">Paid</td>
                        <td class="a-right a-right ">$741.20</td>
                        <td class=" last"><a href="#">View</a>
                        </td>
                      </tr>
                    </tbody>

                  </table>
                </div>
                	
                </div>
                      <div class="tab-pane" id="messages">Messages Tab.</div>
                      <div class="tab-pane" id="settings">Settings Tab.</div>
                    </div>
                  </div>

                  <div class="clearfix"></div>

                </div>
              </div>
            </div>

                </div>
              
                    <div id="step-4">
                      <h2 class="StepTitle">Step 4 Content</h2>
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
                    height: 800,
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

	
	<!-- /footer content -->
</body>
<script type="text/javascript">
    $(document).ready(function() {
      // Smart Wizard
      $('#wizard').smartWizard();

      function onFinishCallback() {
        $('#wizard').smartWizard('showMessage', 'Finish Clicked');
        //alert('Finish Clicked');
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
