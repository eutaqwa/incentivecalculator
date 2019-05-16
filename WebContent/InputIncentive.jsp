<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2><font size="6" color="green" face="Century">Input Incentive Data</font></h2>
<form action = "IncentiveCalculatorController" method="POST">
<table>
<tbody>
<tr>
<td><code>Employee Grade:</code></td>
<td><input type="text" name="grade" value="Input grade here..." onclick="this.value=''" style="width:360px"/></td>
</tr>
<tr>
<td><code>Employee Salary:</code></td>
<td><input type="text" name="salary" value="Input salary here..." onclick="this.value=''" style="width:360px"/></td>
</tr>
<tr>
<td><code>Incentive Percentages</code></td>
<td><input type="text" name="percentages" value="Input Incentive Percentages here..." onclick="this.value=''" style="width:360px"/></td>
</tr>
</tbody></table>
<input type="submit" value="Save"/></form>

</body>
</html>