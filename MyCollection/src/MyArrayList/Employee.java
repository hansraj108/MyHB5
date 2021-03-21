package MyArrayList;

import java.util.Comparator;

public class Employee implements Comparable<Employee>{

	private int id;
	private String fName;
	private String lName;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", fName=" + fName + ", lName=" + lName + ", age=" + age + "]";
	}
	public Employee(int id, String fName, String lName, int age) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.age = age;
	}
	@Override
	public int compareTo(Employee o) {
		return this.id-o.id;
	}
	
	
	
}
