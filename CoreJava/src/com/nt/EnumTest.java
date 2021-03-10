package com.nt;

/*interface Mobile{
	String APPLE = "Apple";
	String SAMSUNG = "galaxy";
	String HTC = "g5";
}*/
enum Mobile{
	APPLE,SAMSUNG,HTC;
}


public class EnumTest {
	
	public static void main(String[] args) {
		Mobile m = Mobile.HTC;
		switch(m) {
		case APPLE:
			System.out.println("APPLE");
			break;
			
		case SAMSUNG:
			System.out.println("SAMSUNG");
			break;
			
		case HTC:
			System.out.println("HTC");
			break;
		}
		System.out.println(Mobile.APPLE);
	}

}
