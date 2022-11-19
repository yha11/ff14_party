<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>6.1 24인 레이드 헤딩 파티</title>
<link rel="stylesheet" type="text/css" href="css/partycss.css">
<script type="text/javascript" src="script/partyscript.js"></script>
</head>
<body>
<div align="center">
	<h1>관리자 로그인</h1>
	<form action="adminlogin.do" method="post" name="frm">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th>서버</th>
				<td>
					<input type="radio" name="server" value="1" checked="checked">카벙클
					<input type="radio" name="server" value="2">초코보
					<input type="radio" name="server" value="3">모그리
					<input type="radio" name="server" value="4">톤베리
					<input type="radio" name="server" value="5">펜리르
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd"></td>
			</tr>
		</table><br>
		<input type="submit" value="로그인" onclick="return productCheck()">
		<input type="button" value="파티현황" onclick="location.href='partylist.do'">
	</form>
</div>
</body>
</html>