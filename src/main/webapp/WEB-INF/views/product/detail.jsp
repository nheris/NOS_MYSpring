<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<header>
<c:import url="../temps/bootStrap_css"></c:import>
</header>

<body>
<c:import url="../temps/header.jsp"></c:import>
</body>


<section class="container-fluid">

<div>
<c:if test="${not empty dto}">
	<h3>${dto.productNum}</h3>
	<div>${dto.productName}</div>
	<div>${dto.productContents}</div>
	<div>${dto.productRate}</div>
	<div>${dto.productJumsu}</div>
</c:if>
</div>
<c:if test="${empty dto}">
<h3>없음</h3>
</c:if>
</section>


<c:import url="../temps/bootStrap_js.jsp"></c:import>
</html>