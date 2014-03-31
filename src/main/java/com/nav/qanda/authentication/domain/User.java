package com.nav.qanda.authentication.domain;

public class User {

private Long userId;
private String userN, userP;

public User() {
}


public Long getUserId() {
	return userId;
}


public void setUserId(Long userId) {
	this.userId = userId;
}


public String getUserN() {
	return userN;
}

public void setUserN(String userN) {
	this.userN = userN;
}

public String getUserP() {
	return userP;
}

public void setUserP(String userP) {
	this.userP = userP;
} 

}
