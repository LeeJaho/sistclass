<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<!-- <html>
<head> -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1,  user-scalable=1"/>
<title>Insert title here</title>
<link href = "${ctx}/resources/CSS/style.css" type="text/css" rel="stylesheet"/>
<!-- </head>
<body> -->

	<%-- <header class="header">
		<h1>책 제목</h1>
		<nav class="main-menu">
			<h1 class="hidden">메인메뉴</h1>
				<ul>
					<li><a href=""><img src ="${ctx}/resources/images/ic_dehaze_black_24dp_1x.png"/></a></li>
					<li><a href=""><img src ="${ctx}/resources/images/ic_search_black_24dp_1x.png"/></a></li>
					<!-- <li></li> -->
				</ul>
		</nav>
	</header> --%>
	
	<main class="main">
		<section class="note-list">
			<h1 class="hidden">노트목록</h1>
			<ul class="">
				<c:forEach var="note" items="${notes}">
					<li class="text">
						<div><a href="">${note.title}</a></div>
						<div class="">
							<span class="text-concat">${note.content }</span>
						</div>
						<div><span>분류</span> <span>${note.regDate}</span></div>
					</li>
				</c:forEach>
			</ul>
		</section>
	</main>
	
<!-- 	
</body>
</html> -->