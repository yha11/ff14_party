<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>6.1 24인 레이드 헤딩 파티</title>
<link rel="stylesheet" type="text/css" href="css/partycss.css">
</head>
<body>
<div align="center">
	<h1>연합파티 현황</h1>
	<h5 style="text-align:right;"><a href="adminlogin.do">관리자 로그인</a>&nbsp;&nbsp;</h5>
	<div class="parent" style="width: 1000px;">
	    <div class="child">
			<table class="list">
				<tr>
					<th colspan="2" style="border:white; text-align:center;">A 파티</th>
				</tr>
				<c:forEach var="party" items="${plist}">
					<c:if test="${party.union=='A'}">
						<tr>
							<td>${party.job}</td>
							<td>${party.id}</td>
						</tr>
					</c:if>
				</c:forEach>
			</table>
	    </div>
	    <div class="child">
	    	<table class="list">
				<tr>
					<th colspan="2" style="border:white; text-align:center;">B 파티</th>
				</tr>
				<c:forEach var="party" items="${plist}">
					<c:if test="${party.union=='B'}">
						<tr>
							<td>${party.job}</td>
							<td>${party.id}</td>
						</tr>
					</c:if>
				</c:forEach>
			</table>
	    </div>
	    <div class="child">
	    	<table class="list">
				<tr>
					<th colspan="2" style="border:white; text-align:center;">C 파티</th>
				</tr>
				<c:forEach var="party" items="${plist}">
					<c:if test="${party.union=='C'}">
						<tr>
							<td>${party.job}</td>
							<td>${party.id}</td>
						</tr>
					</c:if>
				</c:forEach>
			</table><br>
    	</div>
	</div>
	<br>
	<input type="button" value="공지사항" onclick="location.href='main.do'">
	<input type="button" value="파티가입" onclick="location.href='partyjoin.do'">
</div>
</body>
</html>