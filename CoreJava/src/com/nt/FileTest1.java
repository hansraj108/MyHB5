package com.nt;

import java.io.File;
import java.io.IOException;

public class FileTest1 {

	public static void main(String[] args) throws IOException {
		
		File f = new File("D:/ss/cricket.txt");
		System.out.println(f.exists());
		f.createNewFile();
		System.out.println(f.exists());

	}

}
