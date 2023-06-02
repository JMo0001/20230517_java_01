package kh.lclass.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import kh.lclass.oop.sample.Car;

public class TestCollection {
	
	public <E extends Number, J> String testGeneric(E a, J b) {
		System.out.println(a.getClass().getName());
		System.out.println(b.getClass().getName());
		return a.toString()+" 결과값 "+b.toString();
		
	}
	
	
	
	public void testStack() {
		Stack<String> strStack = new Stack<String>();
		strStack.push("안녕");
		strStack.add("하");
		strStack.push("세요");
		System.out.println(strStack.get(1));
		System.out.println(strStack);
		System.out.println(strStack.peek());
		System.out.println(strStack);
		System.out.println(strStack.pop());
		System.out.println(strStack);
	}
	
	
	
	
	public void testHashMap() {
		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("ej", 35.0);
		objMap.put("jy", "지영이네");
		objMap.put("hj", new Car(5000));
		System.out.println(objMap.toString());
		System.out.println("jy"+" : "+objMap.get("jy"));
		Set<String> keyset = objMap.keySet();
		System.out.println(keyset);
		System.out.println("=== Map : engenced for ===");
		for(String item : keyset) {
			Object value = objMap.get(item);
			System.out.println(item+" : "+value);
		}
		System.out.println("=== Map : Iterator for ===");
		Iterator<String> itr = keyset.iterator();
		System.out.println(itr);
		while (itr.hasNext()) {
			String item = itr.next();
			Object value = objMap.get(item);
			System.out.println(item+" : "+value);
		}
		
	}

	public void testHashSet() {
		Set<Integer> integerSet = new HashSet<Integer>();
		integerSet.add(11);
		integerSet.add(22);
		integerSet.add(33);
		integerSet.add(11);
		System.out.println(integerSet.toString());
		System.out.println("=== Set : enhanced for ===");
		for (Integer item : integerSet) {
			System.out.println(item);
		}

		System.out.println("=== Set : Iterator 사용 ===");
		Iterator<Integer> itr = integerSet.iterator();
		System.out.println(itr);
		while (itr.hasNext()) {
			Integer item = itr.next();
			System.out.println(item);
		}

	}

	public void testArrayList() {
		String[] strArr1 = new String[3];
		strArr1[0] = "바나나";
		strArr1[1] = "딸기";
		strArr1.clone();
//		System.out.println(strArr1[3]);		//오류남.

		/*
		 * 
		 * public class ArrayList implements List{ public boolean add(Object e){ // }
		 * public boolean add(String e){ // } public boolean add(integer e){ // } public
		 * boolean add(double e){ // } public boolean add(Car e){ // }
		 * 
		 * }
		 * 
		 */

		ArrayList<String> list = new ArrayList<String>();// ArrayList는 class

		ArrayList<Integer> list2 = new ArrayList<Integer>();
		ArrayList<Car> list3 = new ArrayList<Car>();
		list3.add(new Car(3000)); // 참조 자료형 넣는법.
		list2.add(25);
		list2.add(26);
		list2.add(null); // Integer 형태는 null 가능.
		list2.add(27);
		list2.add(55);

//		list2.add(2,56);		//끼워넣기 insert index 현재 크기 size()보다 클 수 없음.
		System.out.println(list2.get(2));
		System.out.println(list2.get(4));

		// 배열 for 짝궁
		// List - for
		for (int i = 0; i < list2.size(); i++) {
			Integer item = list2.get(i);
			System.out.println(list2.get(i));
		}

		// 배열 -for
		for (int i = 0; i < strArr1.length; i++) {
			String item = strArr1[i];
			System.out.println(strArr1[i]);
		}
		System.out.println("===== enhanced for =====");

		// enhenced for (향상된, 발달된 for)
		for (Integer item : list2) {
			System.out.println(item); // 처음부터 끝까지 나옴.
		}
		for (String item : strArr1) {
			System.out.println(item);
		}

		List<String> list4 = new ArrayList<String>(); // List 는 interface

//		ArrayList<int> list0 = new ArrayList<int>(); int 오류남. (기본자료형 x) 
		list2.clone();
		if (list.add("7번")) {
			System.out.println("list에 추가 성공하였습니다.");
		}
		list.add("2번");
		list.add("1번");
		list.add("2번");
		list.add("3번");
		list.add(1, "2번대신끼워넣기");
//		list.remove("2번");
		Collection<String> collection1 = new ArrayList<String>();
		collection1.add("2번");
//		collection1.add("3번");
		list.removeAll(collection1);
		ArrayList<String> copyList = (ArrayList<String>) list.clone();
		System.out.println(copyList);// list.colne()의 모양이 object.(클론 결과물 = object)
		if (list instanceof ArrayList) {
			@SuppressWarnings("unchecked")
			ArrayList<String> copylist = (ArrayList<String>) list.clone();
			System.out.println(copylist);
		}

		list4.add("11번");
		list4.add("12번");
		list4.add("13번");
		((ArrayList<String>) list4).clone(); // interface는 clone()이 안됨. >> class로 형변환(ArrayList<String>)

		if (list4 instanceof ArrayList) { // if문으로 확인 후에 오류 suppress
			@SuppressWarnings("unchecked")
			ArrayList<String> copylist2 = (ArrayList<String>) ((ArrayList<String>) list4).clone();
			System.out.println(copylist2);
		}
//		ArrayList<String> copyList2 = (ArrayList<String>)((ArrayList<String>)list4).clone(); 
//		System.out.println(list4);
//		System.out.println(copyList2);

//		list.remove(0);		//중간에 있는걸 삭제, 뒤에 있는걸 밀어올림
//		list.clear();
		System.out.println(list);
	}

}
