<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>File Upload</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  
  <body>
    <h1>文件上传实例</h1>
    <!-- 表单enctype属性指定数据返回服务器时的编码类型， multipart/form-data表示不对字符编码，上传文件时使用-->
	<form method="post" action="ImageSaveServlet" enctype="multipart/form-data">
	选择一个文件:	<input type="file" name="uploadFile" />
    <br/><br/>
    <input type="submit" value="上传" />
	</form>
  </body>
</html>
