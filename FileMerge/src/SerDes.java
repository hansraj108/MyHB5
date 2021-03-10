import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerDes {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Dog d1=new Dog();
		Cat c1=new Cat();
		System.out.println("Serialization started");
		FileOutputStream fos=new FileOutputStream("abc.ser");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(d1);
		oos.writeObject(c1);
		System.out.println("Serialization ended");
		System.out.println("Deserialization started");
		FileInputStream fis=new FileInputStream("abc.ser");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Dog d2=(Dog)ois.readObject();
		Cat c2=(Cat)ois.readObject();
		System.out.println("Deserialization ended");
		System.out.println(d2.i+"................"+d2.j);
		System.out.println(c2.i+"................"+c2.j);

		
		
		
	}

}
