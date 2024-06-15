package model;

public class Student {
	
	private String name;
	private int age;
	private boolean gender;
	private String address;
	private int pincode;
	
	public Student(String name , int age,boolean gender,String address,int pincode){
		this.name= name;
		this.age = age;
		this.gender= gender;
		this.address = address;
		this.pincode = pincode;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public boolean getGender() {
		return this.gender;
	}

	public String getAddress() {
		return this.address;
	}

	public int getPincode() {
		return this.pincode;
	}
	
	

}
