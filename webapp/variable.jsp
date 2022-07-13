<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="Dashboard">
  <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
  <title>中医电子病历系统</title>

  <!-- Favicons -->
  <link href="img/favicon.png" rel="icon">
  <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Bootstrap core CSS -->
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!--external css-->
  <link href="lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet">
</head>

<body>
  <div id="container">
    <!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
    <!--header start-->
    <header class="header black-bg">
      <!--logo start-->
      <a href="index.html" class="logo"><b>WEB<span>EMR</span></b></a>
      <!--logo end-->
      <div class="top-menu">
        <ul class="nav pull-right top-menu">
          <li><a class="logout" href="login.html">注销</a></li>
        </ul>
      </div>
    </header>
    <!--header end-->
    <!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** --> 
	<!--sidebar start-->
    <aside>
      <div id="sidebar" class="nav-collapse ">
        <ul class="sidebar-menu" id="nav-accordion">
          <p class="centered"><a href="profile.html"><img src="img/ui-sam.jpg" class="img-circle" width="80" alt=""></a></p>
          <h5 class="centered">${user.adname}</h5>
          <li class="sub-menu">
          	<li>
          	  <a href="variable.jsp">
          	    <i class="fa fa-map-marker"></i>
          	    <span>基 础 变 量 </span>
          	  </a>
          	</li>		  
          </li>
          <!-- <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-desktop"></i>
              <span>UI Elements</span>
              </a>
            <ul class="sub">
              <li><a href="general.html">General</a></li>
              <li><a href="buttons.html">Buttons</a></li>
              <li><a href="panels.html">Panels</a></li>
              <li><a href="font_awesome.html">Font Awesome</a></li>
            </ul>
          </li>
          <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-cogs"></i>
              <span>Components</span>
              </a>
            <ul class="sub">
              <li><a href="grids.html">Grids</a></li>
              <li><a href="calendar.html">Calendar</a></li>
              <li><a href="gallery.html">Gallery</a></li>
              <li><a href="todo_list.html">Todo List</a></li>
              <li><a href="dropzone.html">Dropzone File Upload</a></li>
              <li><a href="inline_editor.html">Inline Editor</a></li>
              <li><a href="file_upload.html">Multiple File Upload</a></li>
            </ul>
          </li>
          <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-book"></i>
              <span>Extra Pages</span>
              </a>
            <ul class="sub">
              <li><a href="blank.html">Blank Page</a></li>
              <li><a href="login.html">Login</a></li>
              <li><a href="lock_screen.html">Lock Screen</a></li>
              <li><a href="profile.html">Profile</a></li>
              <li><a href="invoice.html">Invoice</a></li>
              <li><a href="pricing_table.html">Pricing Table</a></li>
              <li><a href="faq.html">FAQ</a></li>
              <li><a href="404.html">404 Error</a></li>
              <li><a href="500.html">500 Error</a></li>
            </ul>
          </li>
          <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-tasks"></i>
              <span>Forms</span>
              </a>
            <ul class="sub">
              <li><a href="form_component.html">Form Components</a></li>
              <li><a href="advanced_form_components.html">Advanced Components</a></li>
              <li><a href="form_validation.html">Form Validation</a></li>
              <li><a href="contactform.html">Contact Form</a></li>
            </ul>
          </li>
          <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-th"></i>
              <span>Data Tables</span>
              </a>
            <ul class="sub">
              <li><a href="basic_table.html">Basic Table</a></li>
              <li><a href="responsive_table.html">Responsive Table</a></li>
              <li><a href="advanced_table.html">Advanced Table</a></li>
            </ul>
          </li>
          <li>
            <a href="inbox.html">
              <i class="fa fa-envelope"></i>
              <span>Mail </span>
              <span class="label label-theme pull-right mail-info">2</span>
              </a>
          </li>
          <li class="sub-menu">
            <a href="javascript:;">
              <i class=" fa fa-bar-chart-o"></i>
              <span>Charts</span>
              </a>
            <ul class="sub">
              <li><a href="morris.html">Morris</a></li>
              <li><a href="chartjs.html">Chartjs</a></li>
              <li><a href="flot_chart.html">Flot Charts</a></li>
              <li><a href="xchart.html">xChart</a></li>
            </ul>
          </li>
          <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-comments-o"></i>
              <span>Chat Room</span>
              </a>
            <ul class="sub">
              <li><a href="lobby.html">Lobby</a></li>
              <li><a href="chat_room.html"> Chat Room</a></li>
            </ul>
          </li> -->
        </ul>
      </div>
    </aside>
    <!--sidebar end--> 
    <!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
    <!--main content start-->
    <div id="main-content">
      <div class="wrapper site-min-height">
        <div class="row mt">
          <div class="col-sm-12">
            <div class="panel">
              <header class="panel-heading">
                <a style="font-size: large;">基础变量</a>
				<form class="form-inline" style="float: right;" action="${pageContext.request.contextPath}/findVariableByPageServlet?rows=10&currentPage=1" method="post">
				    <div class="input-group">
				      <input type="text" class="form-control" name="varname" value="${varname}" placeholder="变量名/变量编码">
				    </div>
				  <button type="submit" class="btn btn-primary">查找</button>
				</form>	
              </header>
              <div class="panel-body">
                <div id="gmap-list">
					<table class="table table-hover table-bordered">
						<tr>
						    <th style="width: 6%; text-align: center;"></th>
							<th>变量编码</th>
							<th>变量名称</th>
							<th>显示名称</th>
							<th>变量类型</th>
						</tr>
						<c:forEach items="${pageVariable.list}" var="variable">
						<tr>
						    <td class="btn-group-xs" style="text-align: center;">
							    <button type="button" class="btn btn-primary btn-warning" onclick="window.location.href='${pageContext.request.contextPath}/findVariableServlet?varid=${variable.varid}'" value="${variable.varid}">修改</button>
					            <button type="button" class="btn btn-primary btn-danger" onclick="window.location.href='${pageContext.request.contextPath}/delVariableServlet?varid=${variable.varid}'" value="${variable.varid}">停用</button>
					        </td>
							<td>${variable.varcode}</td>
							<td>${variable.varname}</td>
							<td>${variable.showname}</td>
							<td>${variable.vartype}</td>
						</tr>
						</c:forEach>
					</table>
				</div>
				<div class="btn-group" style="float: left; margin-top: -5px;">
					    <button type="button" onclick="window.location.href='${pageContext.request.contextPath}/addvariable.jsp'" class="btn btn-default">新增</button> 
				</div>
					<ul class="pagination" style="float: right; margin-top: -5px;">
			            <li><a href="${pageContext.request.contextPath}/findVariableByPageServlet?rows=10&currentPage=${pageVariable.currentPage-1}&varname=${varname}">&laquo;</a></li>
				        <c:forEach begin="1" end="${pageVariable.totalPage}" var="i">
				            <c:if test="${pageVariable.currentPage!=i}">
				        		<li><a href="${pageContext.request.contextPath}/findVariableByPageServlet?rows=10&currentPage=${i}">${i}</a></li>
				            </c:if>
				            <c:if test="${pageVariable.currentPage==i}">
				        		<li class="active"><a href="${pageContext.request.contextPath}/findVariableByPageServlet?rows=10&currentPage=${i}">${i}</a></li>
				            </c:if>
				        </c:forEach>
    			        <li>
    			            <a href="${pageContext.request.contextPath}/findVariableByPageServlet?rows=10&currentPage=${pageVariable.currentPage+1}&varname=${varname}">&raquo;</a>
    			        </li>
				    </ul>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-sm-12">
            <div class="panel">
              <div class="panel-body">
				  <a style="font-size: initial;">值域</a>
				  <div id="gmap-tabs">
				  	<table class="table table-hover table-bordered  table-condensed">
				  		<tr class="">
				  			<th style="width: 70%;">选项</th>
				  			<th style="width: 30%;">是否为默认值</th>
				  		</tr>
				  		<tr>
				  			<td>无</td>
				  			<td>是</td>
				  		</tr>
				  		<tr>
				  			<td>有</td>
				  			<td>否</td>
				  		</tr>
				  	</table>					
				  </div>
              </div>
            </div>
          </div>
        </div>
        <!-- page end-->
      </div>
      <!-- /wrapper -->
    </div>
    <!-- /MAIN CONTENT -->
    <!--main content end-->
  </div>
  <!-- js placed at the end of the document so the pages load faster -->
  <script src="lib/jquery/jquery.min.js"></script>
  <script src="lib/bootstrap/js/bootstrap.min.js"></script>
  <script class="include" type="text/javascript" src="lib/jquery.dcjqaccordion.2.7.js"></script>
  <script src="lib/jquery.scrollTo.min.js"></script>
  <script src="lib/jquery.nicescroll.js" type="text/javascript"></script>
  <!--common script for all pages-->
  <script src="lib/common-scripts.js"></script>
  <!--script for this page-->
  <!--Google Map-->
  <script src="http://maps.google.com/maps/api/js?sensor=false&libraries=geometry&v=3.7"></script>
  <script src="lib/google-maps/maplace.js"></script>
  <script src="lib/google-maps/data/points.js"></script>
  <script type="text/javascript">
  function delVariable(varid){
	   if(confirm("确定删除此用户信息？"))
		   location.href="${pageContext.request.contextPath}/delVariableServlet?varid="+varid;
  } 
  </script>
</body>

</html>
