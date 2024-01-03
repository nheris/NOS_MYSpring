<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<header>
<c:import url="../temps/bootStrap_css"></c:import>
</header>

<body>
<c:import url="../temps/header.jsp"></c:import>



<table>
<thead>
<tr>
<th>상품번호</th>
<th>상품명</th>
<th>설명</th>
<th>이자율</th>
<th>평점</th>
</tr>
</thead>
<tbody>
<c:forEach items=""></c:forEach>
</tbody>

</table>

</body>
<c:import url="../temps/bootStrap_js.jsp"></c:import>
</html>