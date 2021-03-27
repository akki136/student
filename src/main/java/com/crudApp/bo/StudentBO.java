package com.crudApp.bo;

import io.swagger.annotations.ApiModelProperty;

public class StudentBO {

	Integer  id;
	
	@ApiModelProperty(required = true,dataType = "String")
	String name;
	
	@ApiModelProperty(required = true,dataType = "String")
	String password;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "StudentBO [name=" + name + ", password=" + password + "]";
	}
	
	
}
