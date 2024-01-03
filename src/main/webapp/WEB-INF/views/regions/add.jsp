<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  	
  	<section id="contents" class="container-fluid">
  		<div class="row mt-4">
  			<!-- 부트 forms 탭에 overview  -->
  			<!-- 주소는 같지만 메서드 형식다르면 구별 가능 -->
			<form action="./add" method="post">
			  <div class="mb-3">
			    <label for="regionId" class="form-label">RegionID</label>
			    <input type="text" name="region_id" class="form-control" id="regionId" aria-describedby="emailHelp">
			    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
			  </div>
			  <div class="mb-3">
			    <label for="regionName" class="form-label">RegionName</label>
			    <input type="text" name="region_name" class="form-control" id="regionName">
			  </div>
			  <button type="submit" class="btn btn-primary">Add</button>
			</form>
  		
  		
  		
  		</div>
  	</section>
  	
		<c:import url="../temps/bootStrap_js.jsp"></c:import>
	</body>
</html>