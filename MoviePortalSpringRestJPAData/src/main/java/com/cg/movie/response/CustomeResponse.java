package com.cg.movie.response;

public class CustomeResponse {
private String errorMessage;
private int statusCode;
public String getErrorMessage() {
	return errorMessage;
}
public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}
public int getStatusCode() {
	return statusCode;
}
public void setStatusCode(int statusCode) {
	this.statusCode = statusCode;
}
public CustomeResponse() {
	super();
}
public CustomeResponse(String errorMessage, int statusCode) {
	super();
	this.errorMessage = errorMessage;
	this.statusCode = statusCode;
}

}
