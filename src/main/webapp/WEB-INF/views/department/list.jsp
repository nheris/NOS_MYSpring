<%@page import="com.winter.app.departments.DepartmentDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<DepartmentDTO> ar = (List<DepartmentDTO>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Departments List</h1>
	<table>
		<thead>
			<tr>
				<th>DEPARTMENT_ID</th>
				<th>DEPARTMENT_NAME</th>
				<th>LOCATION_ID</th>
				<th>MANAGER_ID</th>
			</tr>
		</thead>
		<tbody>
			<% for(DepartmentDTO departmentDTO :ar){%>
				<tr>
					<td><%= departmentDTO.getDepartment_id()%></td>
					<td><a href="./detail.jsp?department_name=<%= departmentDTO.getDepartment_name() %>"><%= departmentDTO.getDepartment_name()%></a></td>
					<td><%= departmentDTO.getLocation_id()%></td>
					<td><%= departmentDTO.getManager_id()%></td>
				</tr>
			<% } %>
		
		</tbody>
	</table>
	
	<a href="./add.jsp">추가</a>
</body>
</html>