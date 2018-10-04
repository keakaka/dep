  
      <%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
     	 <%@
         	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
          %>
         
      <div class="navbar nav_title" style="border: 0;">
         <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>DBDBDep</span></a>
      </div>
      <div class="clearfix"></div>
      
      <!-- menu prile quick info -->
      <div class="profile">
         <div class="profile_pic">
            <img src="images/img.jpg" alt="..." class="img-circle profile_img">
         </div>
         <div class="profile_info">
            <span> 환영합니다 </span>
            <h2> ${ sessionScope.loginUser.empName } 님 </h2>
         </div>
      </div>
      <!-- /menu prile quick info -->
      <br />
      <!-- sidebar menu -->
      <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
         <div class="menu_section">
            <h3>${loginUser.depName }</h3>
            <ul class="nav side-menu">
               <li>
                  <a><i class="fa fa-user"></i> 마이페이지 <span
                     class="fa fa-chevron-down"></span></a>
                  <ul class="nav child_menu" style="display: none">
                     <li><a href="myInfo.me">개인 정보 수정</a></li>
                     <li><a href="mySalary.me">급여 내역 조회</a></li>
                     <li><a href="myJobPosition.me">직급 변경 이력 조회</a></li>
                     <li><a href="myDepartment.me">부서이동 이력 조회</a></li>
                     <li><a href="myJobDuty.me">직책 변경 이력 조회</a></li>
                     <li><a href="myWorkingHours.me">근태 이력 조회</a></li>
                     <li><a href="myVacation.me">휴가 내역 조회</a></li>
                  </ul>
               </li>
               <li>
                  <a><i class="fa fa-envelope"></i> 전자메일 <span
                     class="fa fa-chevron-down"></span></a>
                  <ul class="nav child_menu" style="display: none">
                     <li><a href="writingMail.ma">편지 쓰기</a></li>
                     <li><a href="myMail.ma">받은 메일함</a></li>
                     <li><a href="sentMail.ma">보낸 메일함</a></li>
                     <li><a href="mailBin.ma">휴지통</a></li>
                  </ul>
               </li>
               <li>
                  <a><i class="fa fa-newspaper-o"></i> 전자결재 <span   class="fa fa-chevron-down"></span></a>
                  <ul class="nav child_menu" style="display: none">
                     <li><a href="empty.html">기안하기</a></li>
                     <li><a href="empty.html">결재함</a></li>
                     <li><a href="empty.html">수신함</a></li>
                  </ul>
               </li>
               <li>
                  <a><i class="fa fa-video-camera"></i> 화상회의 
                     <span class="fa fa-chevron-down"></span>
                  </a>
                  <ul class="nav child_menu" style="display: none">
                     <li><a href="empty.html">화상회의 하기</a></li>
                     <li><a href="empty.html">회의록 보기</a></li>
                  </ul>
               </li>
               <li><a><i class="fa fa-clipboard"></i> 부서게시판 </a></li>
               <li><a href="calendar.ca"><i class="fa fa-calendar"></i> 일정 관리 </a></li>
               <li><a href="addressBook.ad"><i class="fa fa-star"></i> 주소록 </a></li>
               <li><a href="salary.me"><i class="fa fa-won"></i> 회계관리 </a></li>
           		<c:if test="">
               <li><a><i class="fa fa-users"></i> 인사관리 </a></li>
               <li><a><i class="fa fa-barcode"></i> 출근관리 </a></li>
          		</c:if>
            </ul>
         </div>
      </div>
      <!-- /sidebar menu -->
      </div>
      </div>
      <!-- top navigation -->

      <div class="top_nav">

        <div class="nav_menu">
          <nav class="" role="navigation">
            <div class="nav toggle">
              <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>

            <ul class="nav navbar-nav navbar-right">
              <li role="presentation" class="dropdown">
                <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                  <i class="fa fa-envelope-o"></i>
                  <span class="badge bg-green">6</span>
                </a>
                <ul id="menu1" class="dropdown-menu list-unstyled msg_list animated fadeInDown" role="menu">
                  <li>
                    <a>
                      <span class="image">
                                        <img src="images/img.jpg" alt="Profile Image" />
                                    </span>
                      <span>
                                        <span>John Smith</span>
                      <span class="time">3 mins ago</span>
                      </span>
                      <span class="message">
                                        Film festivals used to be do-or-die moments for movie makers. They were where...
                                    </span>
                    </a>
                  </li>
                  <li>
                    <a>
                      <span class="image">
                                        <img src="images/img.jpg" alt="Profile Image" />
                                    </span>
                      <span>
                                        <span>John Smith</span>
                      <span class="time">3 mins ago</span>
                      </span>
                      <span class="message">
                                        Film festivals used to be do-or-die moments for movie makers. They were where...
                                    </span>
                    </a>
                  </li>
                  <li>
                    <div class="text-center">
                      <a>
                        <strong>See All Alerts</strong>
                        <i class="fa fa-angle-right"></i>
                      </a>
                    </div>
                  </li>
                </ul>
              </li>

            </ul>
          </nav>
        </div>

      </div>
      <!-- /top navigation -->