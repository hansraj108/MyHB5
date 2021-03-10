package com.nt;

public class ExceptionTestCustomExcp {

	public static void main(String[] args) throws HansException {
		try {
			int i = 9;
			int j = 0;
			int k = i / j;

			System.out.println(k);
			// System.out.println("Bye");

		} catch (Exception e) {
			throw new HansException("hans excp");
		} finally {
			System.out.println("Bye");
		}

	}

}
