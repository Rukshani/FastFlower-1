package dataStructures;

import java.util.Iterator;

public class queue {

	private int maxsize;
	private int queue[];
	private int front;
	private int rear;
	private int numitem;
	public queue(int i){
		maxsize=i;
		queue =new int [maxsize];
		front=0;
		rear=-1;
		numitem=0;
		
	}
	
	public void enqueue(int num){
		if (rear!=maxsize-1) {
			queue[++rear]=num;
			numitem++;
		}
		
	}
	
	public int dequeue(){
		if (numitem!= 0) {
			numitem--;
			return queue[front++];
			
		}
		else{
			return (Integer)null;
		}
	}
	
	public int peek(){
		if (numitem !=0) {
			return queue[front];
		}
		else{
			return (Integer)null;
		}
	}
	
	public int number() {
		return numitem;
	}
	
	public static void main(String[] args) {
		queue q= new queue(3);
		
//			q.enqueue(6);
//			System.out.println(q.peek());
//			q.enqueue(7);
//			System.out.println(q.peek());
		
		
//		if (q.number() !=0) {
//			q.dequeue();
//			System.out.println(q.peek());
//			
			for (int i = 0; i < q.maxsize; i++) {
				q.enqueue(i);
				System.out.println(q.peek());
				
			}
			
			for (int i = 0; i < q.maxsize; i++) {
				q.dequeue();
				System.out.println(q.peek());
				
			}
		}

	}

