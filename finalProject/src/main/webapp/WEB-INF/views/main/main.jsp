<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Meta, title, CSS, favicons, etc. -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>DBDBDep! </title>

	<!-- Bootstrap core CSS -->
	<link href="${contextPath }/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="${contextPath }/resources/fonts/css/font-awesome.min.css" rel="stylesheet">
	<link href="${contextPath }/resources/css/animate.min.css" rel="stylesheet">
	<!-- Custom styling plus plugins -->
	<link href="${contextPath }/resources/css/custom.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${contextPath }/resources/css/maps/jquery-jvectormap-2.0.3.css" />
	<link href="${contextPath }/resources/css/icheck/flat/green.css" rel="stylesheet" />
	<script src="${contextPath }/resources/js/jquery.min.js"></script>

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
                    DBDBDep
                </h3>
            </div>

          </div>
          <div class="clearfix"></div>


          <div class="row">

            <div class="col-md-6 col-sm-6 col-xs-12">
              <div class="x_panel">
                <div class="x_title">
                  <h2> 전자결재함  </h2>
                  <div class="clearfix"></div>
                </div>
                <div class="x_content">

                  <table class="table">
                    <thead>
                      <tr>
                        <th>결재해야할 문서</th>
                        <th><a href="signApprovalList.sg?empNo=${loginUser.empNo }"><c:out value="${signCount[0] }"/></a></th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <th>수신받은 문서</th>
                        <td><a href="signReceive.sg?empNo=${loginUser.empNo }"><c:out value="${signCount[1] }"/></a></td>
                      </tr>
                    </tbody>
                  </table>
                  <p>=====================================================================================================</p>
                  <h2> 오늘 할 일  </h2>
					<div class="">
                      <ul class="to_do">
                      <c:set var="now" value="<%=new java.util.Date()%>" />
                    	<c:set var="now"><fmt:formatDate value="${now}" pattern="yyyy-MM-dd" /></c:set> 
                      		<c:forEach var="to" items="${myCalendar }">
                      		<fmt:parseDate value="${to.scheStartDate}" var="startDate" pattern="yyyy-MM-dd"/>
							<c:set var="tod"><fmt:formatDate value="${startDate}" pattern="yyyy-MM-dd"/></c:set>
							<c:if test="${ now eq tod}">
                      		<li>
                          		<p><input type="checkbox" class="flat">&nbsp;&nbsp;&nbsp;&nbsp; ${to.scheduleTitle }</p>
                        	</li>
                        	</c:if>
                      	</c:forEach>
                      
                      </ul>
                    </div>
                </div>
              </div>
            </div>


            <div class="col-md-6 col-sm-6 col-xs-12">
              <div class="x_panel">
                <div class="x_title">
                  <h2>부서 게시판 </h2>
                  <div class="clearfix"></div>
                </div>
                <div class="x_content">

                  <table class="table table-bordered">
                    <thead>
                      <tr>
                        <th>제목</th>
                        <th>조회수</th>
                        <th>작성자</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="b" items="${boardList }" varStatus="index">
                      <c:if test="${index.index <= 5 }">
                      <tr>
                        <td><a href="boardList.bo?depName=${loginUser.depName}">${b.boardTitle }</a></td>
                        <td>${b.selectCount }</td>
                        <td>${b.empName }</td>
                      </tr>
                      </c:if>
                     </c:forEach>
                    </tbody>
                  </table>

                </div>
              </div>
            </div>

            <!-- Start to do list -->
              <div class="col-md-6 col-sm-6 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2> 오늘의 부서 일정 </h2>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
					<table class="table table-bordered">
                    <thead>
                      <tr>
                        <th>일정 제목</th>
                        <th>일시</th>
                        <th>게시자</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:set var="now" value="<%=new java.util.Date()%>" />
                    <c:set var="now"><fmt:formatDate value="${now}" pattern="yyyy-MM-dd" /></c:set> 
                    <c:forEach var="dep" items="${depCalendar }" varStatus="index">
                    	<fmt:parseDate value="${dep.scheStartDate}" var="startDate" pattern="yyyy-MM-dd"/>
						<c:set var="dat"><fmt:formatDate value="${startDate}" pattern="yyyy-MM-dd"/></c:set>
                    	
                      <c:if test="${index.index < 5}">
                      <c:if test="${now eq dat }">
                      <tr>
                        <td><a href="calendarDep.ca">${dep.scheduleTitle }</a></td>
                        <td>${dat }</td>
                        <td>${dep.empName }</td>
                      </tr>
                      </c:if>
                      </c:if>
                    </c:forEach>
                    </tbody>
                  </table>
                    
                  </div>
                </div>
              </div>
              <!-- End to do list -->


				<!-- footer content -->
			</div>
			</div>
				<footer>
					<div class="copyright-info">
						<p class="pull-right">DBDBDep - B오전 Final Project by <a href="http://www.iei.or.kr/main/main.kh?src=overture&kw=003DFA&gclid=Cj0KCQjw9ZDeBRD9ARIsAMbAmoZTJZP5ENi7OkIuimgnF0lSAzQFJc29u1JYoV58VDyCQIAEFRCY9SEaAr4hEALw_wcB">KH Academy</a>
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
