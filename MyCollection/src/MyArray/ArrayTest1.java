package MyArray;

import java.util.Arrays;

public class ArrayTest1 {

	public static void main(String[] args) {
		
		Integer[] origArray = new Integer[] { 1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8 };
		 
        // This array has duplicate elements
        System.out.println(Arrays.toString(origArray));
        
        Integer[] tempArray = removeDuplicates(origArray);
        Object [] tempArray1 =  Arrays.stream(tempArray).filter(x -> x !=null).toArray();
        System.out.println(Arrays.toString(tempArray1));
		
		
		int[] r = new int[10];
		String[] a = new String[] {"hans","raj"};
		System.out.println(Arrays.toString(a));
		for(int i=0;i<10;i++) {
			r[i]=i;
		}
		
		boolean b = Arrays.stream(r).anyMatch(i->i ==4);
			System.out.println(b);
		
		//System.out.println(a.);
		
		for(String x:a)
			System.out.println(x);

		//to check element is there in array
		boolean x = Arrays.asList(a).contains("hans");
		System.out.println(x);
		
		
		boolean y = Arrays.asList(a).stream().anyMatch(z -> z.equalsIgnoreCase("hans"));
		System.out.println(y);
	}

	private static Integer[] removeDuplicates(Integer[] origArray) {
		Integer[] tempArray = new Integer[origArray.length];
		
		int j=0;
		for(int i=0; i<origArray.length-1;i++) {
			Integer currentIndex = origArray[i];
			if(currentIndex != origArray[i+1]) {
				tempArray[j++] = currentIndex;
			}
			
		}
		
		return tempArray;
	}

}
