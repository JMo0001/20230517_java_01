package kh.lclass.oop.sample;
//import java.lang.String;	//쓸필요가 없다.
public class Person /*extends Object // 쓸필요가 없다2 */ {
	protected String name;	//주민등록증상 이름
	private int age;
	private char gender;
	
	
	//기본 생성자
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
