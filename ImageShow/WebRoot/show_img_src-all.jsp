<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="bean.ImageBean"%>
<%@page import="util.ImageDao"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>根据图片地址来显示</title>

  </head>
  
  <body>
     <p>请输入图片序号和判读结果,单位是cm</p>
     <form id="form" action="Get_imgById_Servlet" method="post">
     图片序号:<input type="text" name="s" id="ss" />
     人工判读:<input type="text" name="pd" id="pd"/>
     <input type="submit" value="提交结果">
     </form>
     <table>
    
     <c:forEach items="${lists}" var="lists">
     <tr>图片序号是：${lists.id}</tr>    
     <td>图片真实人工标注是：${lists.groundtruth}cm</td>
     <tr>
     <td><img style="width:200px;height:100px" src="${lists.src}"></td>
     </tr>
     <td>  你的判读结果是：${pd}cm</td> 
     <tr><td>  判读误差是：${wc}cm</td> </tr>
     </c:forEach>
     
     </table>
  </body>
  
  
  
</html>
