package com.highlion.domain;

import java.io.Serializable;

public class User implements Serializable{
private String name;
private String pwd;
public User() {
	
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
}
