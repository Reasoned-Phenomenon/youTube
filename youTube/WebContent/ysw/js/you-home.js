//트렌딩 -> 댓글수 순 정렬
function trendingNow (home) {
    //생성
        //sm6
     let sm6 = $('<div />').addClass('col-lg-4 col-md-6 col-sm-6');

        //pi
        let pi = $('<div />').addClass('product__item');
            //bg
            let bg = $('<div />').addClass('product__item__pic set-bg');
                $(bg).attr('data-setbg',"../upload/"+home.tnTitle); // 섬네일-main.js에서 일괄적용.
                $(bg).css('background-image', 'url(../upload/'+home.tnTitle+')'); // 섬네일(수동)
                //$(bg).html('<a href="'+'#'+'"></a>');             //영상페이지 주소 넣어서 영상클릭시에도 이동하게하기
                let ep = $('<div />').addClass('ep');
                    ep.html('10/10');                                                   //회차정보, 임의로 넣어둠
                let comment = $('<div />').addClass('comment');
                    let ic = $('<i />').addClass('fa fa-comments'); 
                    $(ic).html(home.commentCnt);                                        //댓글수
                let view = $('<div />').addClass('view');
                    let iv = $('<i />').addClass('fa fa-eye').html(home.viewNum);        //조회수

            //pit
            let pit = $('<div />').addClass('product__item__text');
                let ul = $('<ul />').append(
                    $('<li />').html('대분류'),                                             //분류1
                    $('<li />').html('소분류')                                              //분류2
                );
                let h5 = $('<h5 />').append(
                    $('<a />').attr('onclick', 'viNumSender('+home.viNum+')').html(home.title)               //영상페이지 주소,제목 넣기
                );

    //구조
    $(sm6).append(

        $(pi).append(

            $(bg).append(
                ep,
                $(comment).append(ic),
                $(view).append(iv)
            ),

            $(pit).append(ul, h5)
        )
    );
    
    $('.trending__product').children().eq(1).append(sm6);

}

//탑 뷰 - 뷰순 정렬
function topView (home) {
    //생성
        //sv
     let sv = $('<div />').addClass('product__sidebar__view__item set-bg mix').attr('data-setbg','../template/img/sidebar/tv-1.jpg');
     $(sv).css('background-image', 'url(../upload/'+home.tnTitle+')');

        //ep
        let ep = $('<div />').addClass('ep');
        	ep.html('10/10'); //에피소드 숫자
            
        // view    
        let view = $('<div />').addClass('view');
            let icon = $('<i />').addClass('fa fa-eye');
       	view.html(home.viewNum);
       	
       	//h5
       	let h5 = $('<h5 />')
       		//let a = $('<a />').attr('href', '#').html(home.title)
       		let a = $('<a />').attr('onclick', 'viNumSender('+home.viNum+')').html(home.title) //링크 걸어주기
            

    //구조
    $(sv).append(
    		ep,
    		$(view).append(icon),
            $(h5).append(a)
    );
    
    
    $('.filter__gallery').append(sv);

}


//jsp 호출
function viNumSender(viNum) {
	
	setCookie('viNum',viNum);
	
	let param = 'viNum='+viNum;
	
	  $.ajax({
		url:'../youWatchServlet',
		data: param,
		type:'get',
		dataType:'json',
		success: function (result) {
			console.log(result.viNum);
			window.location.href="youwatching.jsp?viNum="+result.viNum;
		},
		error: function (reject) {
			console.log(reject);
		}
		
	})
	
	
	
	
	
}