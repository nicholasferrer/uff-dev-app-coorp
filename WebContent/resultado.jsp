<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultado</title>
</head>
<body>
<% 
	String svalorA = request.getParameter("valorA");
	String svalorB = request.getParameter("valorB");
	String opcao = request.getParameter("opcao");
	String resultado = request.getAttribute("resultado").toString();
%>

Valor A: <% out.print(svalorA); %> Operação: <% out.print(opcao); %> Valor B: <% out.print(svalorB); %>
<br>
Resultado: <% out.print(resultado); %>
</body>
</html>