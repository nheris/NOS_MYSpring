<%@page import="java.util.List"%>
<%@page import="com.winter.app.regions.RegionDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   <!-- c라는 태그 만들겟다 -->
<%
	//List<RegionDTO> ar = (List<RegionDTO>)request.getAttribute("list");//onject라 형변환 필요.이제안쓸거림
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Bootstrap demo</title>
  <c:import url="../temps/bootStrap_css.jsp"></c:import>
</head>
<body>
	
	<c:import url="../temps/header.jsp"></c:import>

	<h1>Regions List</h1>
	
	<div>
		<form class="row g-3">
			<div class="col-auto">
				<select name="kind" class="form-select" aria-label="Default select example">
				  <option value="kind1">Title</option>
				  <option value="kind2">Contents</option>
				  <option value="kind3">Writer</option>
				  <option value="kind4">Title+Contents+Writer</option>
				</select>
			</div>
			
		  <div class="col-auto">
		    <label for="search" class="visually-hidden">Search</label>
		    <input type="text" class="search" id="inputPassword2" placeholder="Password">
		  </div>
		  <div class="col-auto">
		    <button type="submit" class="btn btn-primary mb-3">검색</button>
		  </div>
		</form>
	</div>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
			</tr>
		</thead>
		<!-- for(int i=0; i<;i++) -->
		<!-- for(타입명 변수명: 배열명) -->
		<c:forEach items="${requestScope.list}" var="dto"> <!-- 형변환 필요x -->
			<tr>
				<td>${pageScope.dto.region_id}</td><!--겟터 이름에서 겟빼고 첫글자소문자  -->
								         <!-- 스코프명 생략가능 젤 작게사는애부터 찾음 찾자마자 종료-->
				<td><a href="./detail?region_id=${dto.region_id}">${pageScope.dto.region_name}</td>
			
			</tr>
		</c:forEach>
		
		<tbody>
			
		</tbody>
	</table>
	
	<div>
		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		  	<c:if test="${!pager.start}">
		    <li class="page-item">
		      <a class="page-link" href="./list?page=${pager.startNum-1}" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    </c:if>
		    
		    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
		    <li class="page-item"><a class="page-link" href="./list?page=${i}">${i}</a></li>
		    </c:forEach>
		   
		   <c:if test="${!pager.last}"> 
		    <li class="page-item">
		      <a class="page-link" href="./list?page=${pager.lastNum+1}" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		    </c:if>
		  </ul>
		</nav>
	</div>
	
	<!-- href="add" ./안써도 현재위치 -->
	<a href="./add" class="btn btn-success" >Add</a>
	
	<c:import url="../temps/bootStrap_js.jsp"></c:import>
</body>
</html>