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
	<h1>6.1 24인 레이드 파티 가입</h1>
	<form action="partyjoin.do" method="post" name="frm">
		<table>
			<tr>
				<th>닉네임</th>
				<td><input type="text" name="id" placeholder="인게임 닉네임"></td>
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
				<th>직업</th>
				<td>
					<select name="job">
						<optgroup label="탱커">
							<option value="1">나이트</option>
							<option value="2">전사</option>
							<option value="3">암흑기사</option>
							<option value="4">건브레이커</option>
						</optgroup>
						<optgroup label="힐러">
							<option value="5">백마도사</option>
							<option value="6">학자</option>
							<option value="7">점성술사</option>
							<option value="8">현자</option>
						</optgroup>
						<optgroup label="딜러">
							<option value="9">몽크</option>
							<option value="10">용기사</option>
							<option value="11">닌자</option>
							<option value="12">사무라이</option>
							<option value="13">리퍼</option>
							<option value="14">음유시인</option>
							<option value="15">기공사</option>
							<option value="16">무도가</option>
							<option value="17">흑마도사</option>
							<option value="18">소환사</option>
							<option value="19">적마도사</option>
						</optgroup>
					</select>
				</td>
			</tr>
			<tr>
				<th>연합파티</th>
				<td>
					<input type="radio" name="union" value="A" checked="checked">A
					<input type="radio" name="union" value="B">B
					<input type="radio" name="union" value="C">C
				</td>
			</tr>
		</table>
		<br>
		<input type="submit" value="파티가입" onclick="return productCheck()">
		<input type="reset" value="취소">
		<input type="button" value="파티현황" onclick="location.href='partylist.do'">
	</form>
</div>
</body>
</html>