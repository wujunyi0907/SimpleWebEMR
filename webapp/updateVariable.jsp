<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <title>新增基础变量</title>

    <!-- Favicons -->
    <link href="img/favicon.png" rel="icon">
    <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Bootstrap core CSS -->
    <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!--external css-->
    <link href="lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <style type="text/css">
        .main{
            width: auto;
            height: auto;
            margin: auto;
        }
        .add-variable{
            width: 450px;
            height: 400px;
            position: absolute;
            margin: auto;
            left: 0;
            right: 0;
            top: -200px;
            bottom: 0;
        }
        .input-group {
            font-size: 18px;
        }
    </style>
</head>
<body>
   <div class="main">
       <div class="add-variable">
           <div class="var-input" style="padding: 100px 100px 10px;">
               <form class="bs-example bs-example-form" role="form" action="${pageContext.request.contextPath}/updateVariableServlet?varid=${variable.varid}" method="post">
                   <div class="input-group">
                       <span class="input-group-addon">变量名称</span>
                       <input type="text" class="form-control" style="width: 250px" id="varname" name="varname" onblur="ExtractInitials()" value="${variable.varname}" placeholder="">
                   </div>
                   <br>
                   <div class="input-group">
                       <span class="input-group-addon">变量编码</span>
                       <input type="text" class="form-control" style="width: 250px" id="varcode" name="varcode" value="${variable.varcode}" placeholder="">
                   </div>
                   <br>
                   <div class="input-group">
                       <span class="input-group-addon">显示名称</span>
                       <input type="text" class="form-control" style="width: 250px" id="showname" name="showname" value="${variable.showname}" placeholder="">
                   </div>
                   <br>
                   <div class="input-group">
                       <span class="input-group-addon">变量类型</span>
                       <select class="form-select form-select-lg mb-3 form-control" style="width: 250px" id="vartype" name="vartype" aria-label=".form-select-sm example">
                           <c:if test="${variable.vartype=='单选-名称在前'}">
                              <option value="单选-名称在前" selected>单选-名称在前</option>
                              <option value="单选-名称在后">单选-名称在后</option>
                              <option value="多选-名称在前">多选-名称在前</option>
                              <option value="多选-名称在后">多选-名称在后</option>
                              <option value="文本">文本</option>
                           </c:if>
                           <c:if test="${variable.vartype=='单选-名称在后'}">
                              <option value="单选-名称在前" selected>单选-名称在前</option>
                              <option value="单选-名称在后">单选-名称在后</option>
                              <option value="多选-名称在前">多选-名称在前</option>
                              <option value="多选-名称在后">多选-名称在后</option>
                              <option value="文本">文本</option>
                           </c:if>
                           <c:if test="${variable.vartype=='多选-名称在前'}">
                              <option value="单选-名称在前">单选-名称在前</option>
                              <option value="单选-名称在后">单选-名称在后</option>
                              <option value="多选-名称在前" selected>多选-名称在前</option>
                              <option value="多选-名称在后">多选-名称在后</option>
                              <option value="文本">文本</option>
                           </c:if>
                           <c:if test="${variable.vartype=='多选-名称在后'}">
                              <option value="单选-名称在前">单选-名称在前</option>
                              <option value="单选-名称在后">单选-名称在后</option>
                              <option value="多选-名称在前">多选-名称在前</option>
                              <option value="多选-名称在后" selected>多选-名称在后</option>
                              <option value="文本">文本</option>
                           </c:if>
                           <c:if test="${variable.vartype=='文本'}">
                              <option value="单选-名称在前">单选-名称在前</option>
                              <option value="单选-名称在后">单选-名称在后</option>
                              <option value="多选-名称在前">多选-名称在前</option>
                              <option value="多选-名称在后">多选-名称在后</option>
                              <option value="文本" selected>文本</option>
                           </c:if>
                       </select>
                   </div>
                   <br>
                   <div class="form-group" style="text-align: center">
                       <input class="btn btn-primary" type="submit" value="提交" />
                       <input class="btn btn-default" type="reset" value="重置" />
                   </div>
               </form>
           </div>
       </div>
   </div>
   <script src="lib/jquery/jquery.min.js"></script>
   <script src="lib/bootstrap/js/bootstrap.min.js"></script>
   <!--BACKSTRETCH-->
   <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
   <script type="text/javascript" src="lib/jquery.backstretch.min.js"></script>
   <script src="lib/ChineseExtractInitials.js"></script>
   <script type="text/javascript">
       function ExtractInitials(){
           let simple=document.getElementById("varname").value;
           let result=$lybF12(simple);
           document.getElementById("varcode").value=result[1];
       }
   </script>
   <script type="text/javascript">
       $.backstretch("img/login-bg.jpg", {
           speed: 500
       });
   </script>
</body>
</html>