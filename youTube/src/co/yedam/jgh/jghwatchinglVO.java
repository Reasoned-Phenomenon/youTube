package co.yedam.jgh;

public class jghwatchinglVO {
 
   int cmtNum;    // 댓글 순서번호.
   String author; // 아이디.
   int userNum;   // 아이디 대신 들어 올 수 있는 값.
   int viNum;     // 영상번호.
   String content; // 댓글 내용.
   String cmtDay;  // 댓글 작성 날짜.
   
public int getCmtNum() {
	return cmtNum;
}
public void setCmtNum(int cmtNum) {
	this.cmtNum = cmtNum;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public int getUserNum() {
	return userNum;
}
public void setUserNum(int userNum) {
	this.userNum = userNum;
}
public int getViNum() {
	return viNum;
}
public void setViNum(int viNum) {
	this.viNum = viNum;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getCmtDay() {
	return cmtDay;
}
public void setCmtDay(String cmtDay) {
	this.cmtDay = cmtDay;
}
   
  
}
