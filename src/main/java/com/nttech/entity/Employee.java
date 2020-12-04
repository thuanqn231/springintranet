package com.nttech.entity;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Employee {
	

	String name;
	String adress;
	int age;
	List <String> list;
	Map <String, Object> map;
	Properties properties;
	Director director;
	
	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public  Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public  Employee(String name, int age) {
		this.name = name;
		this.age = age;
		// TODO Auto-generated constructor stub
	}
	
	public void start() {
		System.out.println("Init");
	}
	
	public void destroy() {
		System.out.println("Destroy");
	}
	
	public void getMessage() {
		System.out.println("Welcome Mr.Thuan" + name + "Age: " + age);
	}
}
