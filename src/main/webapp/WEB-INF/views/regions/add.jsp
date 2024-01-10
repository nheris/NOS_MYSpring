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
	<!-- summer note -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
  </head>
  <body>
  	
	<c:import url="../temps/header.jsp"></c:import>
  	
  	<section id="contents" class="container-fluid">
  		<div class="row mt-4">
  			<!-- 부트 forms 탭에 overview  -->
  			<!-- 주소는 같지만 메서드 형식다르면 구별 가능 -->
			<form action="./add" method="post" enctype="multipart/form-data">
			  <!-- <div class="mb-3">
			    <label for="regionId" class="form-label">RegionID</label>
			    <input type="text" name="region_id" class="form-control" id="regionId" aria-describedby="emailHelp">
			    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
			  </div> 시퀀스 써서 이제 필요없음-->

			  <div class="mb-3">
			    <label for="regionName" class="form-label">RegionName</label>
			    <input type="text" name="region_name" class="form-control" id="regionName">
			  </div>
			  
			  <div class="mb-3">
				<!-- Contents 있다 가정하에 -->
				<label for="regionContents" class="form-label">RegionContents</label>
				<textarea id="regionContents" class="form-control"></textarea>
			  </div>

			  <!-- 파일첨부 -->
			  <div class="mb-3">
					<input type="file" name="photo">
			  </div>

			  <button type="submit" class="btn btn-primary">Add</button>
			</form>
  		
  		
  		
  		</div>
  	</section>
  	<script>
		$('#regionContents').summernote()
	</script>
		<c:import url="../temps/bootStrap_js.jsp"></c:import>
	</body>
</html>