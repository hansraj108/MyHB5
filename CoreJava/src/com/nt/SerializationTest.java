package com.nt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Dog implements Serializable{
	int i;
	int j;
	Dog(int i, int j){
		this.i=i;
		this.j=j;
	}
	
}

class Cat implements Serializable{
	 int k=50;
	int l=60;
	
	
}
public class SerializationTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Dog dog = new Dog(10,20);
		Dog dog1 = new Dog(30,40);
		Cat cat = new Cat();
		FileOutputStream fos = new FileOutputStream("D:/ss/abc.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
	//	oos.writeObject(dog);
	//	oos.writeObject(dog1);
		oos.writeObject(cat);
		FileInputStream fis = new FileInputStream("D:/ss/abc.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Object o = ois.readObject();
		
		if(o instanceof Dog) {
			Dog d = (Dog)o;
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
