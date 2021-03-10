import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileMerge {

	public static void main(String[] args) throws IOException {
		
	
	PrintWriter pw = new PrintWriter("thirdfile.txt");
	BufferedReader br = new BufferedReader(new FileReader("firstfile.txt"));
	String line = br.readLine();
	while (line != null) {
		pw.println(line);
		line = br.readLine();
		br = new BufferedReader(new FileReader("secondfile.txt"));
		line = br.readLine();
		while (line != null) {
			pw.println(line);
			line = br.readLine();
		}
	}
	
	pw.flush();
	br.close();
	pw.close();
}
}