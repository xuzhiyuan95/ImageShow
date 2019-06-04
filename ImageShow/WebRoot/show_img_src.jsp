<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
     <FORM method="post" action="show_img_src.jsp">
        <INPUT type="text"  name="Request" >
        <INPUT type="submit" value="提交"  class="button">
    </FORM>
    <%
  String textContent=request.getParameter("Request");
  if ("A".equals(textContent)){
      out.println("输入了A");
  }else{
      out.println("没有A");
  }
  %>
    <%
  	String sql = "select * from img_src";
  	List<ImageBean> list = ImageDao.querySrc(sql);
  	// 如果结果集不为空
  	if (list.size() > 0) {
   %>
    <table>
    	<th>id</th><th>名称</th><th>人工读取值</th><th>图片</th>
    <%
    	for (ImageBean bean : list) {
	%>
		<tr>
		<td><%=bean.getId() %></td>
		<td><%=bean.getName() %></td>
		<td><%=bean.getGroundtruth() %></td>
		<!-- 这里 src 路径，要根据目录结构来确定，如果图片显示个X，大多是路径问题 -->
		<td><img style="width:100px;height:50px" src="<%=bean.getSrc()%>"></td>
		
		</tr>
	<%    	
    	} // for 
	}// if    
     %>
    
      <%
  	
  	// 如果结果集不为空
  	   %>
  </body>
  
     
  
</html>
