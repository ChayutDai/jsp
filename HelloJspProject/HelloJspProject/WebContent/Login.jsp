<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.Date"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><%  
if(request.getAttribute("err")!= null){
	out.print(request.getAttribute("err"));
}%></h1>

<br />
<br />
	<form action="LoginServlet" method="post">
		Username :<input type="text" name="username">
		<br>
		Password :<input type="password" name="password">
		<br>
		<input type="radio" name="language" value="thai" checked>Thai
		<br>
		<input type="radio" name="language" value="english">English
		<br>
		<input type="submit" value=" Login ">
		<input type="reset" value="Cear">
</form> 


</body>
</html>