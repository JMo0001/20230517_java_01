package kh.lclass.oop.sample;

import java.io.Serializable;

public class Kh implements TestInterface, Serializable {
	// The serializable class Kh does not declare a static final serialVersionUID
	// field of type long
//	static final long serialVersionUID = 1L;d

	public void khSpecial() {
//		int a =Integer.parseInt("str");
		String str = "111122222";
		try {
			System.out.println("1");
			Car[] carArr = new Car[3];
//			carArr[0] = new Car();
			carArr[4].setPrice(5000);		//ArrayIndexoutOfBoundsException
			System.out.println("2");
			carArr[0].setPrice(5000); 		// NullPointerException
			int a = Integer.parseInt(str); 	// NumberFormatException
			int c = 10 / 0; 				// ArithmeticException
			c = 0 / 10;
		} catch (NumberFormatException e) {
			System.out.println(Integer.MAX_VALUE + "까지의 정수만 입력해주세요.");
			e.printStackTrace(); // 오류 내용 나
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눈 수는 나타낼 수 없습니다.");
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("읎어.");
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 길이를 초과하였습니다.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		try {
			System.out.println("1");
			Car[] carArr = new Car[3];
//			carArr[0] = new Car();
			carArr[4].setPrice(5000);		//ArrayIndexoutOfBoundsException
			System.out.println("2");
			carArr[0].setPrice(5000); 		// NullPointerException
			int a = Integer.parseInt(str); 	// NumberFormatException
			int c = 10 / 0; 				// ArithmeticException
			c = 0 / 10;
		} catch (NumberFormatException e) {
			System.out.println(Integer.MAX_VALUE + "까지의 정수만 입력해주세요.");
			e.printStackTrace(); // 오류 내용 나
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눈 수는 나타낼 수 없습니다.");
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("읎어.");
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 길이를 초과하였습니다.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("===여기가 마지막===");

	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub

	}

	@Override
	public String method2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int method3(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}

}
