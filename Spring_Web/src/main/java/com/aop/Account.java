package com.aop;

public class Account {

	private int id;
	private String name;
	private int number;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Account(int id, String name, int number) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", number=" + number + "]";
	}

}
