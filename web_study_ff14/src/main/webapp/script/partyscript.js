function productCheck() {
	if(document.frm.id.value.length==0) {
		alert("닉네임을 입력하세요.");
		frm.id.focus();
		
		return false;
	}
	
	if(document.frm.id.value.length>9) {
		alert("닉네임은 9글자 이하입니다.");
		frm.id.focus();
		
		return false;
	}
	
	if(document.frm.pwd.value.length==0) {
		alert("비밀번호를 입력하세요.");
		frm.pwd.focus();
		
		return false;
	}
	
	if(isNaN(document.frm.pwd.value)) {
		alert("숫자만 입력해야 합니다.");
		frm.pwd.focus();
		
		return false;
	}
	
	return true;
}