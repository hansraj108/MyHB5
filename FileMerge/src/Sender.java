import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Sender {
	public static void main(String[] args) throws Exception {
		
		Dog d = new Dog();
	FileOutputStream fos = new FileOutputStream("abc1.ser");
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	oos.writeObject(d);
	}
}
