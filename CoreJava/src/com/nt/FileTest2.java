package com.nt;

import java.io.File;
import java.io.IOException;

public class FileTest2 {

	public static void main(String[] args) throws IOException {
		File f = new File("cricket1122");
		System.out.println(f.exists());
		f.createNewFile();
		System.out.println(f.exists());

	}

}
