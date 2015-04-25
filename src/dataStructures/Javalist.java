package dataStructures;

import java.util.LinkedList;

public class Javalist {

	public static void main(String[] args) {
		LinkedList<Integer> list=new LinkedList<Integer>();
		list.add(2);
		list.addLast(4);
		System.out.println(list.getFirst());
		list.addFirst(45);
		System.out.println(list.getLast());
		
	}
}
