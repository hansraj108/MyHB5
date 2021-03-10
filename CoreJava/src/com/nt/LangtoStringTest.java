package com.nt;

public class LangtoStringTest {

	int i;
	
	LangtoStringTest(int i){
		this.i=i;
	}
	public static void main(String[] args) {
		LangtoStringTest l1 = new LangtoStringTest(100);
		LangtoStringTest l2 = new LangtoStringTest(200);
		LangtoStringTest l3 = new LangtoStringTest(300);
		
		
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(l3);
		
		String s=new String("bhaskar");
		s.concat("software");
		System.out.println(s);//bhaskar
	}

	
/*	  @Override public String toString() { // TODO Auto-generated method stub
	  return "i value: "+i+" "+ Integer.toHexString(hashCode()); }
	 
	@Override
	public int hashCode() {
		System.out.println("hash");
		return i;
	}*/
	
	
}

