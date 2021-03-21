package MyArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayListTest1 {

	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1,"hans","tan",20));
		list.add(new Employee(4,"ans","and",21));
		list.add(new Employee(3,"ns","n",22));
		list.add(new Employee(2,"s","tan",23));
		
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);
		
		Collections.reverse(list);
		System.out.println(list);
		
		Collections.sort(list, new NameSorting());
		System.out.println(list);
		
		Collections.sort(list, new AgeShorting());
		System.out.println(list);
		
		Collections.sort(list, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getfName().compareTo(o2.getfName());
				
			}
		});
		System.out.println(list);
		
		Comparator<Employee> myComparator = Comparator.comparing(Employee::getfName).thenComparing(Employee::getlName);
		Collections.sort(list, myComparator);
	}

}
