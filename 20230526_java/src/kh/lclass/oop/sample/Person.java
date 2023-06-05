package kh.lclass.oop.sample;

import java.io.Serializable;

//import java.lang.String;	//쓸필요가 없다.
public class Person /*extends Object // 쓸필요가 없다2 */ implements Serializable{
	/**
	 * 주석은 일반적으로 녹색
	 * 이것은 파랑색
	 * java docs에 표시됨.
	 * 여기에 UID에 해당하는 생성날짜, 누가, 무엇때문에 작성하였는지를 남겨야 함.
	 */
	private static final long serialVersionUID = 2324920168885089596L;
	protected String name;	//주민등록증상 이름
	private int age;
	private transient char gender;
	
	
	//기본 생성자
	/**파랑색 작성위치 여기*/
	public Person() {}
	
	//allArgumentsConstructor
	//allArgumentsConstructor란 모든 매개인자를 받아서 처리하는 생성자
	//overloading으로 생성자
	public Person(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		
	}
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

	// getter /setter
	public String getName(){
		return name;
	}
	protected int getAge() {
		//만나이
		return age;
	}
	public char getGender() {
		return gender;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
}
