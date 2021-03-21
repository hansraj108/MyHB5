package com.nt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Animal implements Serializable{
	Lion lion = new Lion();
}
class Lion implements Serializable{
	Zebra zebra = new Zebra();
}
class Zebra implements Serializable{
	Rat rat = new Rat();
}
class Rat implements Serializable{
	int j=10;
}

public class SerializableTest1 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// serialization
		FileOutputStream fos = new FileOutputStream("D:/ss/abc1.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Animal animal = new Animal();
		oos.writeObject(animal);
		// deserialization
		FileInputStream fis = new FileInputStream("D:/ss/abc1.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object o = ois.readObject();
		
		if(o instanceof Animal) {
			Animal a = (Animal) o;
			System.out.println(a.lion.zebra.rat.j);
		}
	}

}
