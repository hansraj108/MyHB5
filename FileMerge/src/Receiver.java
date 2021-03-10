import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

public class Receiver {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("abc1.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Dog d = (Dog) ois.readObject();
		System.out.println(d.i+"-----"+d.j);
	}
}
