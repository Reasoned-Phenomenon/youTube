function makeDiv(home) {
    	
    let outDiv = $('<div />').addClass('anime__review__item');
    let pic = $('<div />').addClass('anime__review__item__pic');
        let img = $('<img />').attr("src","../template/img/review-1.jpg");
    $(pic).append(img);
    
    let txt = $('<div />').addClass('anime__review__item__text');
        let h6 = $('<h6 />').html(home.cmtAuthor);
            let cmtTime = $('<span />').html(home.cmtDate);
        let p = $('<p />').html(home.cmtContent);
    $(txt).append( $(h6).append($(cmtTime)), $(p) );
    
    $(outDiv).append(pic,txt);
    
    $('.anime__details__review').append(outDiv);
    
}

function showList() {
    
        let param = 'viNum='+1;
        
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

function setVideo() {
    
    let viNum = '<%=viNum%>';
    let param = 'viNum='+viNum;
    
    $.ajax({
        url:'../youWatchServlet',
        data: param,
        success: function(result) {
            
            let data = JSON.parse(result);
            
            $('#viTitleSpan').text(data.title); // 영상 제목
            
            let vi = $('<video controls preload playsinline/>').attr('src','../template/videos/title'+data.viNum+'.mp4'); //영상 주소
            
            $(vi).attr('width','1000px');
            $(vi).attr('height','500px');
            $(vi).attr('poster','../template/thumbnail/'+data.tnTitle); //섬네일
            
            $('.anime__video__player').append(vi);
        },
        error: function() {
            
        }
    });
    
}