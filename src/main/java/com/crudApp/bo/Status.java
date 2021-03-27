package com.crudApp.bo;

import org.springframework.http.HttpStatus;

public class Status {

	HttpStatus httpStatus;
	StudentBO bo;
	/**
	 * @return the httpStatus
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	/**
	 * @param httpStatus the httpStatus to set
	 */
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	/**
	 * @return the bo
	 */
	public StudentBO getBo() {
		return bo;
	}
	/**
	 * @param bo the bo to set
	 */
	public void setBo(StudentBO bo) {
		this.bo = bo;
	}
	@Override
	public String toString() {
		return "Status [httpStatus=" + httpStatus + ", bo=" + bo + "]";
	}
	
	
	
}
