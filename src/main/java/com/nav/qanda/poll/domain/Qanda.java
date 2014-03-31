package com.nav.qanda.poll.domain;

public class Qanda {
private Long id;	
private String questionText; 
private String questionAnswerA, questionAnswerB, questionAnswerC, questionAnswerD;
private String usersResponse;


public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getQuestionText() {
	return questionText;
}
public void setQuestionText(String questionText) {
	this.questionText = questionText;
}
public String getQuestionAnswerA() {
	return questionAnswerA;
}
public void setQuestionAnswerA(String questionAnswerA) {
	this.questionAnswerA = questionAnswerA;
}
public String getQuestionAnswerB() {
	return questionAnswerB;
}
public void setQuestionAnswerB(String questionAnswerB) {
	this.questionAnswerB = questionAnswerB;
}
public String getQuestionAnswerC() {
	return questionAnswerC;
}
public void setQuestionAnswerC(String questionAnswerC) {
	this.questionAnswerC = questionAnswerC;
}
public String getQuestionAnswerD() {
	return questionAnswerD;
}
public void setQuestionAnswerD(String questionAnswerD) {
	this.questionAnswerD = questionAnswerD;
}
public String getUsersResponse() {
	return usersResponse;
}
public void setUsersResponse(String usersResponse) {
	this.usersResponse = usersResponse;
}

}
