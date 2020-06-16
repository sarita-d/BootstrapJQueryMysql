<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="recursos/css/bootstrap.min.css">

</head>
<body>
<h1>Hola</h1>
<%
for(int i=0;i<10;i++){%>
<h1><% out.print(i); %></h1>
<% }%>
</body>
</html>