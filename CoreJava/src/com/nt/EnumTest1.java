package com.nt;
enum Mobile1{
	APPLE(100),SAMSUNG,HTC(1000);
	
	int price;
	Mobile1(){
		price = 80;
	}
	
	Mobile1(int p){
		this.price = p;
	}
	
	int getPrice() {
		return price;
	}
}

public class EnumTest1 {

	public static void main(String[] args) {
		System.out.println(Mobile1.APPLE.getPrice());
		System.out.println(Mobile1.SAMSUNG.getPrice());
		System.out.println(Mobile1.HTC.getPrice());
		
		Mobile[] m = Mobile.values();
		for(Mobile m1 : m) {
			System.out.println(m1);
		}
		//m.forEach(i -> System.out.println(1));
	}
}
