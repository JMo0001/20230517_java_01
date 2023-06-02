package kh.lclass.oop.sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Testpolymorphism {

	public static void main(String[] args) {
		
		
		ArrayList<Car> carArrList	  = new ArrayList<Car>();
		List<Car> carList			  = new ArrayList<Car>();	// 가장 흔하게 선언하는 방식
		List<Car> carList2			  = new LinkedList<Car>();	
		Collection<Car> carCollection = new ArrayList<Car>();
		
		
		
		TestInterface kh = new Kh();//kh만 쓰겠다.
		Kh kh2 = new Kh();		// 다 쓰겠다.

		((Kh)kh).khSpecial();			//kh. 안나옴(타입 testinterface >> ((Kh)kh) 캐스팅  		
		
		TestInterface bit;
		TestInterface bit2;
		kh2.khSpecial();
		kh2.method1();
		
		Driver ej = new DriverSub();
		ej.setMoney(10000);
		ej.buy(new Sonata());
		ej.buy(new Avante());
		Driver jh = new Driver2Sub();
		jh.setMoney(10000);
		jh.buy(new Sonata());
		jh.buy(new Avante());
	}

}
