<%@page import="bean.ImageBean"%>
<%@page import="util.ImageDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="util.GeneralDao,java.sql.*" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>展示图片</title>

  </head>
  
  <body>
  <%
  	String sql = "select id,name from imgtest";
  	List<ImageBean> list = ImageDao.querySrc(sql);
  	// 如果结果集不为空
  	if (list.size() > 0) {
   %>
    <table>
    	<th>id</th><th>名称</th><th>图片</th>
    <%
    	for (ImageBean bean : list) {
	%>
		<tr>
		<td><%=bean.getId() %></td>
		<td><%=bean.getName() %></td>
		<!-- 通过bean.getId() 将图片id传给servlet，然后返回显示 -->
		<!-- 这里 src 路径，要根据目录结构来确定，如果图片显示个X，大多是路径问题 -->
		<td><img style="width:50px;height:50px" src="servlet/ImageOutServlet?id=<%=bean.getId()%>"></td>
		</tr>
	<%    	
    	} // for 
	}// if    
     %>
    	
    </table>
  </body>
</html>
