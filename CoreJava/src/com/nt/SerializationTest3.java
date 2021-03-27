package com.nt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Dog1 implements Serializable{
	static int i=10;
	static final int j=8;
	
}



public class SerializationTest3 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Dog1 dog = new Dog1();
		
		FileOutputStream fos = new FileOutputStream("D:/ss/abc.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(dog);
	
		FileInputStream fis = new FileInputStream("D:/ss/abc.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Object o = ois.readObject();
		
		if(o instanceof Dog1) {
			Dog1 d = (Dog1)o;
			System.out.println(d.i +" "+d.j);
		}else if(o instanceof Cat) {
			Cat c = (Cat) o;
			System.out.println(c.k +" "+c.l);
		}
		
	//	Dog d1 = (Dog) ois.readObject(); 	//Exception in thread "main" java.lang.ClassCastException: com.nt.Dog cannot be cast to com.nt.Cat
	/*	System.out.println(d.i +" "+d.j);
		System.out.println(d.i +" "+d.j);
		System.out.println(c.k +" "+c.l);
	*/

	}

}
