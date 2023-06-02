package kh.lclass.oop.sample;


//classs 예약어키워드 abrtract 는 해당 클래스 내에 abstract메소드가 0개 이상 있을 것이라는 의미
public /*abstract*/ class Student extends Person{
	private String name;	//학생증용 name
//	private int age;
//	private char gender;
	private int score;
	private int grade;
	private final int maxCount = 10;
	

	public int getMaxCount() {
		return maxCount;
	}

	public Student() {
		super();//person()
		//super("김말똥",22,'남');	 // Person("김말똥",22,'남')
	}
	
	public Student(String name, char gender, int age, int grade) {
		super(name, age, gender);
		this.name = name;
		this.grade = grade;
	}
	
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + ", grade=" + grade 
								+ ", toString()=" + super.toString()
								+ "]";
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getGrade() {
		return grade;
	}
	//변수 선언
	//메소드 정의	//이 기능은 ~~~~~~ ~~~~~ 기능으로 되어있어.
	
	//메소드 선언	//이 기능은 ~~~~ 있을거야. or  있어야해.
	public /*abstract*/ void setGrade(int grade) {
		this.grade = grade;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
	@Override	//	Overriding	//부모 Person.getAge = 만나이, 여기서는 +1.	재정의.
				// 재정의 조건 : 상속한 클래스의 메소드와 동일한 메소드명
				// 매개변수 자료형, 개수 동일해야 함.
				// 리턴 타입도 동일함.
				// 접근제한자는 다를 수 있음.	//부모 메소드의 접근 제한자보다 넓은 범위 접근제한자 사용해야 함.
	public int getAge() {
		return super.getAge()+1;
	}
	
	
}
