package by.kalilaska.rest.controllers;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Test {
	
	private int id;
	private String name;	
	
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}	

}
