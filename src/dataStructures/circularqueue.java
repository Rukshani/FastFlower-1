package dataStructures;

import java.util.Iterator;

public class circularqueue {
	private int maxsize;
	private int rear;
	private int front;
	private int nitems;
	
	private int cq[];
	
	public circularqueue(int i){
		maxsize= i;
		cq= new int[maxsize];
		rear=-1;
		front=0;
		nitems=0;
	}
	
	public void enque(int i){
		if (!isFull()) {
			nitems++;
			if (rear < maxsize) {
				cq[++rear]=i;
			}
			if (rear==maxsize) {
				rear=0;
				
			}
		}
	}
	
	@SuppressWarnings("null")
	public int dequeue(){
		if (!isEmpty()) {
			nitems--;
			if (front < maxsize) {
				return cq[front++];
			}
			if (front==maxsize) {
				front=0;
			}
			}
			
		
		return (Integer) null;
	}
	
	@SuppressWarnings("null")
	public int peek(){
//		if (!isEmpty()) {
			return cq[front];
//		} else {
//			return (Integer) null;

//		}
	}
	
	public boolean isFull(){
		if (nitems==maxsize) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isEmpty(){
		if (nitems== 0) {
			return true;
		} else {
			return false;

		}
	}

	public static void main(String[] args) {
		circularqueue c=new circularqueue(4);
		for (int i = 0; i < 5; i++) {
			c.enque(i);
			System.out.println(c.peek()+""+c.nitems);
			
		}
		
		for (int i = 0; i < 5; i++) {
			c.dequeue();
			System.out.println(c.peek()+" "+c.nitems);
		}
	}
}
