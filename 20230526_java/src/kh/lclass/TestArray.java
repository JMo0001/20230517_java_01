package kh.lclass;

import java.util.Arrays;

import kh.lclass.vo.TestVo;

public class TestArray {
	public static void main(String[] args) {
		String[] strArr  = new String[3];	//배열 생성, 배열 선언
		strArr[0] = "apple";				//기본자료
		strArr[1] = "banana";				//기본자료
		strArr[2] = new String ("mango");	//참조자료
		//strArr을 복사할 strCopyArr 생성
		String[] strCopyArr = new String[strArr.length];
		for(int i=0; i<strArr.length; i++) {
			strCopyArr[i] = strArr[i];
		}
		strArr[2]="orange";
		strCopyArr[1]="딸기";
		for(int i=0; i<strArr.length; i++) {
			System.out.println(strArr[i]+" : "+strCopyArr[i]);
		}
		System.out.println("==========");
		
		int a =101;
		//a.
		int[] arrA = new int[3];
		arrA[2] =20;
		int[] arrB = arrA.clone();
		System.out.println(arrB.length);
		System.out.println(arrB[2]);
		
		System.out.println("===Arrays.copyOf===");
		String[] strCopyArr2 = Arrays.copyOf(strArr,5);
		for(int i=0; i<strCopyArr2.length; i++) {
			System.out.println(strCopyArr2[i]);
		}
		
		
		System.out.println("=== System. ===");
		String[] strCopyArr3 = new String[5];
		System.arraycopy(strArr, 0, strCopyArr3, 1, 3);
		for(int i=0; i<strCopyArr3.length; i++) {
			System.out.println(strCopyArr3[i]);
		}
				
		String[] strArr2 = {"apple", "basasa", new String("mango")};
		String[] strArr3 = {new String("apple"), new String("basasa"), new String("mango")};
		String[] strArr4 = new String[] {"apple","banana",new String("mango")};
		String[] strArr5 = new String[] {new String("apple"), new String("basasa"), new String("mango")};
		System.out.println("strArr의 1번째 과일은 "+strArr[0]);		//시작0~2까지 1씩 증가
		System.out.println("strArr의 2번째 과일은 "+strArr[1]);
		System.out.println("strArr의 3번째 과일은 "+strArr[2]);
//		for(int i=0; i<=strArr.length-1; i++){ 되긴 됨.
		for(int i=0; i<strArr.length; i++) {
			System.out.println("strArr의 "+i+"번째 과일은 "+strArr[i]);
			//System.out.printf("strArr의 %d번째 과일은 %d\n",i,strArr[i]); 
			                            //앞에 %d번째 과일은 = i= int 
										//뒤의 %d > strArr[i] 는 String(String strArr)
			System.out.printf("strArr의 %d번째 과일은 %s\n",i,strArr[i]); 
		}
		
	 
		
		
		
		//IndexOutOfBoundsException 오류발생
		//System.out.println(strArr[3]);
		
		int[] intArr = new int[3];
		System.out.println(intArr[1]);

		int[] intArr2 = new int[] {1,2,3};
		int[] intArr3 = {1,2,3};
		
		
		
		
		
		
		//Student[] studentArr = new 
	}

}
