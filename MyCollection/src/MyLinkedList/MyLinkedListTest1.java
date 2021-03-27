package MyLinkedList;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import MyArrayList.Employee;



public class MyLinkedListTest1 {

	public static void main(String[] args) {
		Employee emp4 = new Employee(2,"s","tan",23);
		LinkedList<Employee> list = new LinkedList<>();
		list.add(new Employee(1,"hans","tan",20));
		list.add(new Employee(4,"ans","and",21));
		list.add(new Employee(3,"ns","n",22));
		list.add(emp4);
		
		System.out.println(list);
		/*
		 * list.add(new Employee(5,"s","tan",29)); System.out.println(list);
		 */list.add(1,new Employee(6,"s","tan",29));
		System.out.println(list);
		list.addFirst(new Employee(7,"s","tan",29));
		System.out.println(list.size());
		list.add(new Employee(5,"s","tan",29));
		System.out.println(list);
		System.out.println(list.addAll(1, list));
		System.out.println(list);
		System.out.println(list.contains(emp4));
		System.out.println(list.indexOf(emp4));
		System.out.println(list.lastIndexOf(emp4));
		System.out.println(list.subList(2, 4));
		Employee[] a=new Employee[list.size()]; 
		list.toArray(a);
		System.out.println("--------"+Arrays.toString(a));
		Collections.sort(list);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list.offer(emp4));
		Collections.sort(list);
		System.out.println(list.peek());
		Collections.sort(list);
		System.out.println(list.poll());
		Collections.sort(list);
		System.out.println(list);
	}

}
