// 프로필 -> 로그인 상태
function profile () {
		
    let email, emailA, emailId;
    
    if (document.cookie) {
        
        email = getCookie('email');
        
        if ( email ) {
            
        emailA = email.split('@');
        emailId = emailA[0];
        
        }
        
        let logoutBtn = $('<button />').attr('onclick','logout()').html('<i class="material-icons">logout</i>');
    
        if (emailId) {
            
            $('#profile').html('');
            $('#profile').append( $('<a />').append( $('<h6 />').html(emailId+'님').css('color','red') ) );
            $('#profile').append(logoutBtn);
            
        }
        
        
        
    }
    
}

// 쿠키 가져오기
function getCookie (cname) {

    let cookies = document.cookie.split('; ');

    for (let i = 0 ; i < cookies.length ; i ++) {

        if(cookies[i].indexOf(cname) === 0) {

            let result = cookies[i].substring(cname.length+1);
            return result;

        }

    }

    return null;

}

//쿠키 생성
function setCookie (cname, cval) {

	const times = 3;
	const d = new Date();
	//d.setTime(d.getTime() + 1000 * 60 * 60 * times);
	d.setTime(d.getTime() + 1000 );
	//console.log(d.toUTCString);
	document.cookie = cname + '=' + cval + '; expires=' + d.toUTCString + '; path=/';
	
}


//로그아웃
function logout () {


    if (confirm('로그아웃 하시겠습니까?')) {
        
        document.cookie = 'email=; expires=0; path=/';
        document.cookie = 'author=; expires=0; path=/';
        window.location.href="homepage.html";
    
    }
    
}