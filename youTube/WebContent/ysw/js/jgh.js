function makeCommentDiv(comment) {
    let outDiv = document.createElement('div');
    outDiv.className = "anime__review__item";
    outDiv.setAttribute('id',comment.cmtNum);
    
    let innerDiv = document.createElement('div');
    innerDiv.className = "anime__review__item__text";
    
    let firstDiv = document.createElement('div');
    firstDiv.className= "anime__review__item__pic";
    
    
    let img = document.createElement('img');
    img.setAttribute('src','../template/img/anime/review-1.jpg' );
    

    let h6 = document.createElement('h6')
    h6.innerText = comment.author + ' - ';
    //console.log(h6);
    
    let span = document.createElement('span');
    span.innerText = comment.cmtDay;
    //console.log(span);
    
    // x 아이콘 표현하기. => 누르면 삭제.
    let span2 = document.createElement('button');
    span2.className ="material-icons-sharp";
    span2.innerText='x';
    span2.id = "xspan"; 
    
    span2.setAttribute('onclick', 'textDel('+comment.cmtNum+')');  // 
    span2.setAttribute('style','float:right');
 
    h6.appendChild(span2);
    
    console.log(span2);

    /*
    // v 수정버튼 
    let span3 = document.createElement('button');
    span3.className = "material-icons-sharp";
    span3.innerText='v';
    span3.id = "vspan";
    
    span3.setAttribute('onclick', 'textUpdate('+comment.cmtNum+')');  // 
    span3.setAttribute('style','float:right'); // 위치.
 
    h6.appendChild(span3);
    
    console.log(span3);
    
    

    
    // 수정 화면 창.
    
    let p2 = document.createElement('input');
    let modbtn = document.createElement('button');
    modbtn.className = "material-icons-sharp";
    modbtn.innerText ='m';
    modbtn.setAttribute('onclick', 'modComment('+comment.cmtNum+')');
    
    let cancelbtn = document.createElement('button');
    cancelbtn.className = "material-icons-sharp";
    cancelbtn.innerText ='c';
    cancelbtn.setAttribute('onclick', 'cancelComment('+comment.cmtNum+')');
    
    let p3 = document.createElement('p');
    p3.id = "p"+comment.cmtNum ;
    p3.appendChild(p2);
    p3.appendChild(modbtn);
    p3.appendChild(cancelbtn);
    
    p3.style.display ='none';
    h6.appendChild(p3);
    */
    let p = document.createElement('p');
    p.innerText = comment.content; 
    // 
    h6.appendChild(span);
    
    innerDiv.appendChild(h6);
    innerDiv.appendChild(p);
    
    firstDiv.appendChild(img);
    
    outDiv.appendChild(firstDiv);
    outDiv.appendChild(innerDiv);
    
    
    return outDiv;
 } 

//화면출력
function tt () {
  let xhtp = new XMLHttpRequest();
 xhtp.open('get', '../jghwatchingServlet');
 xhtp.send();

 xhtp.onload = function() {
    let data = JSON.parse(xhtp.responseText);
    //console.log(data);
    
    for(let datum of data) {
       let target = document.getElementsByClassName("anime__details__review");
       //console.log(target);
       //console.log(target[0]);
       console.log(datum);
       target[0].appendChild(makeCommentDiv(datum));
    }
 };
}



 // 댓글등록 버튼.
function textAdd (event) {
   
   event.preventDefault(); 
   
   let comment = document.getElementsByTagName('textarea')[0].value;
   console.log(comment);
   
   let author = "qwerty";  // 나중에 아이디값이랑 같이 넘기기.
   let param = "author="+author+"&content="+comment;
   
   $.ajax({
      url:'../jghwatchingaddServlet',
      data: param,   
      type:'get',
      dataType:'json',
      success: function (result) {
         console.log("성공");
         console.log(result);
         let commentDiv = makeCommentDiv(result);
         //console.log(commentDiv);
      
         $('.anime__details__review').append(commentDiv);
         console.log($('textarea'));
         $('textarea').val('');  // 댓글입력 하고 나서 댓글입력 했던 내용은 사라지게 함.
         
      },
      error: function (reject){
         console.log("실패");
      }
   });
}

 // 삭제버튼을 누르면 삭제 함수를 부를 수 있게 하는 함수를 만들기.

//댓글삭제 버튼.
 function textDel (deletenum) { 
    
     event.preventDefault();
     console.log(deletenum);  
  
  let xhtp = new XMLHttpRequest();
  xhtp.open('get','../jghwatchingdeleteServlet?cmtNum='+ deletenum);
  xhtp.send();
  xhtp.onload = function() {
      let data = JSON.parse(xhtp.responseText);
      if (data.retcode =='fail') {
          window.alert('에러발생.');
          return;
      }
      console.log(data.cmtNum);
      let r = document.getElementById(data.cmtNum) ;
      console.log(r);
      
      // 화면에서 삭제.
      document.getElementById(deletenum).remove(); 
      
  }
  
} 



 /* 
 // 댓글 수정 버튼 .=> 수정 화면창 뜨게 나오게 하는 함수 만들기.
 function textUpdate (cmtNum) {
    
     let r = document.getElementById('p'+cmtNum);
     
     r.style.display = "block"; // 실행되었을 때 화면에서 보이게 함.

 } 
 
 // 댓글 수정 변경.
 function modComment (cmtNum) {
     
     let r = document.getElementById('p'+cmtNum);
     
     
     let content = document.getElementById('p'+cmtNum).children[0].value;
     console.log(content); // 
     
     let xhtp = new XMLHttpRequest();
     xhtp.onload = function() {
   
    // let data = JSON.parse(xhtp.responseText);
      
      
     tt();
    
      }
     
     xhtp.open('get', '../jghwatchingupdateServlet');
     xhtp.send ('cmtNum=' + cmtNum  + '&content=' + content);
 }

 
 // 댓글 수정 취소.
 function cancelComment (cmtNum) {
     
     let r = document.getElementById('p'+cmtNum);
     
     r.style.display = "none";
 }

 */