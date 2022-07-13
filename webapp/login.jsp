<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="Dashboard">
  <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
  <title>管理员登录</title>

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


<body>
  <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
  <div id="login-page">
    <div class="container">
      <form class="form-login" action="${pageContext.request.contextPath}/loginServlet" method="post">
        <h2 class="form-login-heading">sign in now</h2>
        <div class="login-wrap">
          <input type="text" name="adname" class="form-control" placeholder="用户名" autofocus>
          <br>
          <input type="password" name="adpasswd" class="form-control" placeholder="密码">
          <button class="btn btn-theme btn-block" type="submit" style="margin-top: 15px;"><i class="fa"></i> 登  录</button>
        </div>
      </form>
    </div>
  </div>
  <!--footer start-->
  <footer class="site-footer" style="margin-top: 30.5%;">
    <div class="text-center">
      <p>
        &copy; Copyrights <strong>Dashio</strong>. All Rights Reserved
      </p>
      <div class="credits">
        <!--
          You are NOT allowed to delete the credit link to TemplateMag with free version.
          You can delete the credit link only if you bought the pro version.
          Buy the pro version with working PHP/AJAX contact form: https://templatemag.com/dashio-bootstrap-admin-template/
          Licensing information: https://templatemag.com/license/
        -->
        Created with Dashio template by <a href="https://templatemag.com/">TemplateMag</a>
      </div>
      <a href="variable.jsp#" class="go-top">
        <i class="fa fa-angle-up"></i>
        </a>
    </div>
  </footer>
  <!-- js placed at the end of the document so the pages load faster -->
  <script src="lib/jquery/jquery.min.js"></script>
  <script src="lib/bootstrap/js/bootstrap.min.js"></script>
  <!--BACKSTRETCH-->
  <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
  <script type="text/javascript" src="lib/jquery.backstretch.min.js"></script>
  <script type="text/javascript">
    $.backstretch("img/login-bg.jpg", {
      speed: 500
    });
    var msg="${login_msg}";
   	if(msg == "LOGIN_ERROR")
   		alert("用户名或密码错误！");
  </script>
</body>
</html>
