package com.nt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Hans implements Serializable{
	String name="hans";
	transient String pwd= "hans1";
	
	private void writeObject(ObjectOutputStream os) throws Exception{
		os.defaultWriteObject();
		String epwd = "123"+pwd;
		os.writeObject(epwd);
	}
	
	private void readObject(ObjectInputStream is) throws Exception{
		is.defaultReadObject();
		String epwd1 = (String) is.readObject();
		pwd = epwd1.substring(3);
	}
	
}
public class SerializableTest2 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("D:/ss/abc2.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Hans hans = new Hans();
		oos.writeObject(hans);
		
		FileInputStream fis = new FileInputStream("D:/ss/abc2.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object o = ois.readObject();
		
		if(o instanceof Hans) {
			Hans h = (Hans) o;
			System.out.println(h.name+" "+h.pwd);
		}

	}

}
