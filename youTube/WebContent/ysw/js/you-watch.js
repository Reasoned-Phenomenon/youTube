
function makeDiv(cmt) {
    	
    let outDiv = $('<div />').addClass('anime__review__item');

    let pic = $('<div />').addClass('anime__review__item__pic');
        let img = $('<img />').attr("src","../template/img/anime/review-"+cmt.cmtNum+".jpg"); // 프로필 사진

    let txt = $('<div />').addClass('anime__review__item__text');
        let h6 = $('<h6 />').html(cmt.cmtAuthor+" - "); //작성자 이름
            let cmtTime = $('<span />').html(cmt.cmtDate); //작성 날짜
        let p = $('<p />').html(cmt.cmtContent); //댓글내용

            $(pic).append(img);
            $(txt).append( $(h6).append($(cmtTime)), $(p) );
        $(outDiv).append(pic,txt);
    $('.anime__details__review').append(outDiv);
    
}

function getComment(viNum) {

    let param = 'viNum='+viNum;

    $.ajax({
        url:'../youShowListServlet',
        data: param,
        type: 'post',
        dataType: 'json',
        success: function (result) {

            console.log(result);

            for( let datum of result ) {
                makeDiv(datum);
            }

        },
        error: function (reject) {
            console.log(reject);
        }
    });

}

function setComment(viNum,cmtContent) {

	let param = 'viNum='+viNum+'&cmtContent='+cmtContent;
	
	$.ajax({
        url:'../',
        data: param,
        type: 'post',
        dataType: 'json',
        success: function (result) {

            console.log(result);

                makeDiv(result);
            

        },
        error: function (reject) {
            console.log(reject);
        }
    });

}

function delComment () {

}


function showList(viNum) {

        let param = 'viNum='+viNum;
        
        $.ajax({
            url: '../youShowListServlet',
            data: param,
            type: 'get',
            dataType: 'json',
            success: function (result) {
                console.log(result);
            },
            error: function (reject) {
                console.log(reject);
            }
            })
    
}

function setVideo(viNum) {
    
    let param = 'viNum='+viNum;
    
    $.ajax({
        url:'../youWatchServlet',
        data: param,
        success: function(result) {
            
            let data = JSON.parse(result);
            
            $('#viTitleSpan').text(data.title); // 영상 제목
            
            let vi = $('<video controls preload playsinline/>').attr('src','../upload/title'+data.viNum+'.mp4'); //영상 주소
            
            $(vi).attr('width','1000px');
            $(vi).attr('height','500px');
            $(vi).attr('poster','../upload/'+data.tnTitle); //섬네일
            
            $('.anime__video__player').append(vi);
        },
        error: function() {
            
        }
    });
    
}