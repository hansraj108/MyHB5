package com.nt;
 //Encapsulation -> binding data with methods
// always access variables with the methods, so we can set the log record of the variable and we can
// also check in method whether the user is logged in or not
class A4{
	private int rollNo;
	private String name;
	
	Integer ii;
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
public class EncapsulationTest {
	public static void main(String[] args) {
		A4 a = new A4();
		a.setName("hans");
		a.setRollNo(111);
	}

}
