package co.yedam.jgh;

public class jghwatchinglVO {
 
   int num;  // 댓글 순서번호.
   String id; // 아이디.
   String content; // 댓글 내용.
   String commentDay;  // 댓글 작성 날짜.
   
   public int getNum() {
      return num;
   }
   public void setNum(int num) {
      this.num = num;
   }
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getContent() {
      return content;
   }
   public void setContent(String content) {
      this.content = content;
   }
   public String getCommentDay() {
      return commentDay;
   }
   public void setCommentDay(String commentDay) {
      this.commentDay = commentDay;
   }
   
}
