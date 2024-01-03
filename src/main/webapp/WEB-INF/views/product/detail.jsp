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


<c:forEach items="${not empty dto}">

</c:forEach>

<c:import url="../temps/bootStrap_js.jsp"></c:import>
</html>